package com.nerdery.umbrella.api;

import com.nerdery.umbrella.BuildConfig;
import com.nerdery.umbrella.model.WeatherData;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Retrofit interface for fetching weather data
 *
 * @author bherbst
 */
public interface WeatherApi {

    /**
     * Get the forecast for a given zip code
     */
    @GET("/api/" + BuildConfig.API_KEY + "/conditions/hourly10day/q/{zip}.json")
    Observable<WeatherData> getForecastForZip(@Path("zip") int zipCode);
}
