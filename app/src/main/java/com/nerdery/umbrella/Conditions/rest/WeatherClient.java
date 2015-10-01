package com.nerdery.umbrella.Conditions.rest;

import android.content.Context;
import android.content.SharedPreferences;

import com.nerdery.umbrella.Conditions.model.CurrentConditions;
import com.nerdery.umbrella.Conditions.util.UmbrellaApp;
import com.nerdery.umbrella.R;

import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by Polycap on 9/27/2015.
 */
public class WeatherClient {
    private WeatherAPI wunderAPI;


    public static final String WEATHER_UNDERGROUND = "http://api.wunderground.com/api";
    public static final String MY_PREFS_NAME = "MyPrefsFile";

    public WeatherClient(Context context) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(WEATHER_UNDERGROUND)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        wunderAPI = restAdapter.create(WeatherAPI.class);


    }

    public Observable<CurrentConditions> getCurrentConditions (String mZipCode){


        String wunderGroundKey =  UmbrellaApp.getContext().getApplicationContext().getResources().getString(R.string.api_key);
        return wunderAPI.getCurrentWeather(wunderGroundKey, mZipCode);

    }

    public interface WeatherAPI {
        @GET("/{apikey}/conditions/hourly/q/{zipcode}.json")
        Observable<CurrentConditions> getCurrentWeather(
                @Path("apikey") String wunderground_key,
                @Path("zipcode") String mUserZipCode
        );
    }


}
