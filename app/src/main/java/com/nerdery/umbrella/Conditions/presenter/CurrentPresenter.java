package com.nerdery.umbrella.Conditions.presenter;

import android.util.Log;

import com.nerdery.umbrella.Conditions.model.CurrentConditions;
import com.nerdery.umbrella.Conditions.view.IMainView;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Polycap on 9/27/2015.
 */
public class CurrentPresenter {
    private static final String TAG = CurrentPresenter.class.getSimpleName();
    IMainView view;

    public CurrentPresenter(IMainView mainView){
        this.view = mainView;

    }

    public void getData(String UserZipcode){
        rx.Observable<CurrentConditions> conditionsObservable = CurrentConditions.returnCurrentConditions(UserZipcode);
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
