package com.nerdery.umbrella.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nerdery.umbrella.Conditions.model.CurrentConditions;
import com.nerdery.umbrella.Conditions.presenter.CurrentPresenter;
import com.nerdery.umbrella.Conditions.view.IMainView;
import com.nerdery.umbrella.NestedRecylerview.DailyAdapter;
import com.nerdery.umbrella.NestedRecylerview.WeatherPresenter;
import com.nerdery.umbrella.R;
import com.nerdery.umbrella.model.ForecastCondition;

import java.util.List;


public class MainActivity extends AppCompatActivity implements IMainView {

    RecyclerView recyclerView;
    WeatherPresenter presenter;
    CurrentPresenter mCurrentPresenter;
    LinearLayout header;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        presenter = new WeatherPresenter(this);
        mCurrentPresenter = new CurrentPresenter(this);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);


    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getWeather();
        mCurrentPresenter.getData();

    }

    public void setList(List<ForecastCondition> hourlyConditions) {
        DailyAdapter adapter = new DailyAdapter(hourlyConditions);
        adapter.setHasStableIds(true);
        recyclerView.setAdapter(adapter);

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
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void displayData(CurrentConditions currentConditions) {
        setCurrentConditionsView(currentConditions);

    }

    private void setCurrentConditionsView(CurrentConditions currentConditions) {
        int basetemp = 60;
        TextView displayLocation = (TextView) findViewById(R.id.display_location_full);
        TextView tempf = (TextView) findViewById(R.id.temp);
        TextView weather = (TextView) findViewById(R.id.weather);

        displayLocation.setText(currentConditions.getCurrentObservation().getDisplayLocation().getFull());
        tempf.setText(String.valueOf(currentConditions.getCurrentObservation().getTempF()));
        weather.setText(currentConditions.getCurrentObservation().getWeather());
        if (currentConditions.getCurrentObservation().getTempF() > basetemp) {

            header = (LinearLayout) findViewById(R.id.condition);
            header.setBackgroundColor(getResources().getColor(R.color.weather_warm));
            toolbar.setBackgroundColor(getResources().getColor(R.color.weather_warm));

        } else {
            header = (LinearLayout) findViewById(R.id.condition);
            header.setBackgroundColor(getResources().getColor(R.color.weather_cool));
            toolbar.setBackgroundColor(getResources().getColor(R.color.weather_cool));


        }

    }
}
