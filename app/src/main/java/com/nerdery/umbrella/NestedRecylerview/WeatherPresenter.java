package com.nerdery.umbrella.NestedRecylerview;

import com.nerdery.umbrella.activity.MainActivity;
import com.nerdery.umbrella.model.CurrentObservation;
import com.nerdery.umbrella.model.ForecastCondition;
import com.nerdery.umbrella.model.WeatherData;

import java.util.List;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Polycap on 9/27/2015.
 */
public class WeatherPresenter {

    final private MainActivity weatherView;
    CompositeSubscription mCompositeSubscription;


    public WeatherPresenter(MainActivity weatherView) {
        this.weatherView = weatherView;
        mCompositeSubscription = new CompositeSubscription();
    }

    public void getWeather(){
//        int zipCode = weatherView.getSharedPreferences("UmbrellaPreferences", Context.MODE_PRIVATE).getInt("zipCode", 0xa);
        int zipCode = 55444;

        final Observable<WeatherData> weatherData = WeatherData.getWeatherData(zipCode);

        final Subscription weatherSubscription = weatherData.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(weatherData1 -> {
                    CurrentObservation currentConditions = weatherData1.currentObservation;
                    List<ForecastCondition> hourlyConditions = weatherData1.forecast;
                    weatherView.setList(hourlyConditions);
                }, throwable -> {

                });
        mCompositeSubscription.add(weatherSubscription);
    }

    public void cleanUpResources() {
        mCompositeSubscription.clear();
    }
}