package com.nerdery.umbrella.model;

import com.google.gson.annotations.SerializedName;
import com.nerdery.umbrella.api.ApiManager;

import java.util.List;

import rx.Observable;

/**
 * Represents weather information returned from the Weather Underground API
 *
 * Does not include all available only data- only potentially useful fields are included
 *
 * @author bherbst
 */
public class WeatherData {
    @SerializedName("current_observation")
    public CurrentObservation currentObservation;

    @SerializedName("hourly_forecast")
    public List<ForecastCondition> forecast;
    public static Observable<WeatherData> getWeatherData(int zipCode){
        return ApiManager.getWeatherApi().getForecastForZip(zipCode);
    }
}
