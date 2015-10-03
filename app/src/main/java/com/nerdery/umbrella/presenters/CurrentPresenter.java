package com.nerdery.umbrella.presenters;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.nerdery.umbrella.models.CurrentConditions;
import com.nerdery.umbrella.models.UmbrellaApp;
import com.nerdery.umbrella.views.IMainView;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Polycap on 9/27/2015.
 */
public class CurrentPresenter {
    public static final String MY_PREFS_NAME = "MyPrefsFile";

    private static final String TAG = CurrentPresenter.class.getSimpleName();
    IMainView view;

    public CurrentPresenter(IMainView mainView){
        this.view = mainView;

    }

    public void getData(){

        SharedPreferences preferences = UmbrellaApp.getContext().getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);
        String mZipcode = preferences.getString("UserZipCode", null);

        rx.Observable<CurrentConditions> conditionsObservable = CurrentConditions.returnCurrentConditions(mZipcode);
        conditionsObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(currentConditions -> {
                    Log.v(TAG, "successful fetched conditions");
                    displayData(currentConditions);
                }, Throwable::printStackTrace);
    }

    public void displayData(CurrentConditions currentConditions){
        view.displayData(currentConditions);

    }
}
