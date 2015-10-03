package com.nerdery.umbrella.presenters;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.nerdery.umbrella.R;
import com.nerdery.umbrella.models.CurrentConditions;
import com.nerdery.umbrella.models.Day;
import com.nerdery.umbrella.models.DayConditions;
import com.nerdery.umbrella.models.ForecastCondition;
import com.nerdery.umbrella.models.UmbrellaApp;
import com.nerdery.umbrella.models.WeatherData;
import com.nerdery.umbrella.views.MainActivity;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Polycap on 9/27/2015.
 */
public class WeatherPresenter {

    public static final String MY_PREFS_NAME = "MyPrefsFile";
    final private static String TAG = WeatherPresenter.class.getSimpleName();
    CompositeSubscription mCompositeSubscription;
    private boolean metricMode = false;
    private MainActivity weatherView;
    private String mZipcode;
    private SharedPreferences preferences;


    public WeatherPresenter(MainActivity weatherView) {
        this.weatherView = weatherView;
        mCompositeSubscription = new CompositeSubscription();
        preferences = UmbrellaApp.getContext().getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);

    }

    public void getWeather(){
        getCurrentConditions();
    }

    public void getHourlyConditions() {
         Observable<WeatherData> weatherData = WeatherData.getWeatherData(Integer.parseInt(mZipcode));

         Subscription hourlySub = weatherData.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(weatherData1 -> {
                    List<ForecastCondition> hourlyConditions = weatherData1.forecast;
                    long yday = 0;
                    List<Day> days = new ArrayList<>();
                    for(ForecastCondition hourlyCon : hourlyConditions){
                        if(yday<hourlyCon.yday){
                            yday = hourlyCon.yday;
                            Day day = new Day();
                            day.dayName = hourlyCon.day;
                            day.yday = hourlyCon.yday;
                            day.conditions = new ArrayList<>();
                            setDayConditions(hourlyConditions, yday, day);
                            days.add(day);
                        }
                    }
                    weatherView.setList(days, metricMode);
                }, throwable -> {

                });
        mCompositeSubscription.add(hourlySub);
    }

    private void setDayConditions(List<ForecastCondition> hourlyConditions, long yday, Day day) {
        for(int i=0; i<hourlyConditions.size(); i++){
            ForecastCondition forecastCondition = hourlyConditions.get(i);
            if(forecastCondition.yday == yday) {
                DayConditions dayConditions = new DayConditions();
                dayConditions.condition = forecastCondition.condition;
                dayConditions.tempC = Math.round(forecastCondition.tempCelsius);
                dayConditions.tempF = Math.round(forecastCondition.tempFahrenheit);
                dayConditions.time = forecastCondition.displayTime;
                day.conditions.add(dayConditions);
            }
            if(day.conditions.size()==8){
                break;
            }
        }
    }


    public void getCurrentConditions() {
        getPreferences();

        Log.v(TAG,"ZipCode is "+mZipcode);
        //if zipcode is empty, prompt user for zipcode
        if (TextUtils.isEmpty(mZipcode)) {
            weatherView.getUserZipcode();
            return;
        }

        rx.Observable<CurrentConditions> conditionsObservable = CurrentConditions.returnCurrentConditions(mZipcode);
        Subscription conditionSub = conditionsObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(currentConditions -> {
                    Log.v(TAG, "successful fetched conditions");
                    if(currentConditions.getCurrentObservation()!=null){
                        displayCurrentConditions(currentConditions);
                    }else{
                        Toast.makeText(weatherView,"Location not found",Toast.LENGTH_SHORT).show();
                        weatherView.getUserZipcode();
                        return;
                    }
                    getHourlyConditions();
                }, Throwable::printStackTrace);
        mCompositeSubscription.add(conditionSub);
    }

    private void getPreferences() {
        mZipcode = preferences.getString(weatherView.getString(R.string.pref_location_key), "");
        metricMode = preferences.getString(weatherView.getString(R.string.pref_units_key), "english").equalsIgnoreCase(("metric"));
    }

    private void displayCurrentConditions(CurrentConditions currentConditions) {
        weatherView.setCurentConditions(currentConditions,metricMode);

    }


    public void cleanUpResources() {
        mCompositeSubscription.clear();
    }
}