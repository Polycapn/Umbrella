package com.nerdery.umbrella.activity;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.nerdery.umbrella.Conditions.model.CurrentConditions;
import com.nerdery.umbrella.Conditions.presenter.CurrentPresenter;
import com.nerdery.umbrella.Conditions.util.UmbrellaApp;
import com.nerdery.umbrella.Conditions.view.IMainView;
import com.nerdery.umbrella.NestedRecylerview.DailyAdapter;
import com.nerdery.umbrella.NestedRecylerview.WeatherPresenter;
import com.nerdery.umbrella.R;
import com.nerdery.umbrella.model.Day;
import com.nerdery.umbrella.model.ForecastCondition;

import java.util.List;


public class MainActivity extends AppCompatActivity implements IMainView {


    final public static String ZIP_CODE = "ZipCode";
    final public static boolean Metric = false;
    public static final String UMBRELLA_PREFERENCES = "MyPrefsFile";
    private static final String SETTINGS = "settings";
    private static final String TAG = MainActivity.class.getSimpleName();


    RecyclerView recyclerView;
    WeatherPresenter presenter;
    CurrentPresenter mCurrentPresenter;
    Toolbar toolbar;
    UmbrellaApp getContext;
    private SharedPreferences prefs;
    ProgressDialog progressDialog;
    SwipeRefreshLayout mSwipeRefreshLayout;


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Fetching Weather Updates");
        prefs = getSharedPreferences(UMBRELLA_PREFERENCES, MODE_PRIVATE);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        presenter = new WeatherPresenter(this);
        mCurrentPresenter = new CurrentPresenter(this);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.weather_swipe_refresh);
        mSwipeRefreshLayout.setOnRefreshListener(this.presenter::getWeather);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

    }

    public void dismissProgress() {
        progressDialog.dismiss();
    }

    public void showProgress() {
        progressDialog.show();
    }

    public void getUserZipcode() {
        final EditText mZipCodeEditText = new EditText(this);
        mZipCodeEditText.setInputType(InputType.TYPE_CLASS_PHONE);
        mZipCodeEditText.setRawInputType(InputType.TYPE_CLASS_NUMBER );
        int maxLength = 5;
        InputFilter[] fArray = new InputFilter[1];
        fArray[0] = new InputFilter.LengthFilter(maxLength);
        mZipCodeEditText.setFilters(fArray);

        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
        builder.setMessage("Please enter a valid 5 diget ZipCode")
                .setTitle("Enter Zipcode")
                .setView(mZipCodeEditText)
                .setPositiveButton("Ok", (dialog, which) -> {

                    String userZipcode = mZipCodeEditText.getText().toString();

                    SharedPreferences.Editor editor = getSharedPreferences(UMBRELLA_PREFERENCES, MODE_PRIVATE).edit();
                    editor.putString(getString(R.string.pref_location_key), userZipcode);
                    editor.apply();

                    showProgress();
                    presenter.getWeather();

                })
                .show();

    }





    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG,"On Resume");

        if (prefs.getBoolean("firstrun", true)){
            getUserZipcode();
            prefs.edit().putBoolean("firstrun", false).apply();
        }else {
            showProgress();
            presenter.getWeather();
        }

    }

    public void setList(List<Day> dayConditions, boolean metricMode) {
        DailyAdapter adapter = new DailyAdapter(dayConditions);
        adapter.setMetricMode(metricMode);
        adapter.setHasStableIds(true);
        recyclerView.setAdapter(adapter);
        mSwipeRefreshLayout.setRefreshing(false);
        dismissProgress();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.cleanUpResources();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Log.v(TAG,"Action Settings clicked");
            Fragment settingsFragment = getFragmentManager().findFragmentByTag(SETTINGS);
            if(settingsFragment==null) {
                getFragmentManager().beginTransaction()
                        .replace(android.R.id.content, new PreferenceFragment())
                        .addToBackStack(SETTINGS)
                        .commit();
            }else{
                getFragmentManager().beginTransaction()
                        .show(settingsFragment)
                        .commit();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void displayData(CurrentConditions currentConditions) {


    }

    @Override
    public void setCurentConditions(CurrentConditions currentConditions, boolean metricMode) {
        //TODO convert to celcius as well depending on the value of metricMode
        TextView displayLocation = (TextView) findViewById(R.id.display_location_full);
        TextView tempf = (TextView) findViewById(R.id.temp);
        TextView weather = (TextView) findViewById(R.id.weather);

        displayLocation.setText(currentConditions.getCurrentObservation().getDisplayLocation().getFull());
        int temp;
        int basetemp = 60;

        if(metricMode) {
            basetemp = ((5*(60-32))/(9));
            Log.v(TAG,"basetemp metric: "+basetemp);
            temp = Math.round(currentConditions.getCurrentObservation().getTempC());
        }else {
            temp = Math.round(currentConditions.getCurrentObservation().getTempF());
        }

        String temperatureDegrees = String.valueOf(temp) + (char) 0x00B0;

        tempf.setText(temperatureDegrees);

        weather.setText(currentConditions.getCurrentObservation().getWeather());


        if (temp > basetemp) {
            toolbar.setBackgroundColor(ContextCompat.getColor(this,R.color.weather_warm));

        } else {
            toolbar.setBackgroundColor(ContextCompat.getColor(this,R.color.weather_cool));


        }

    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount()>0){
            getFragmentManager().popBackStack();
            showProgress();
            presenter.getWeather();
        }else {
            super.onBackPressed();
        }
    }
}

