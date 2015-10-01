package com.nerdery.umbrella.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nerdery.umbrella.NestedRecylerview.WeatherPresenter;
import com.nerdery.umbrella.R;

/**
 * Created by Polycap on 10/1/2015.
 */
public class PreferenceFragment extends android.preference.PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPreferenceManager().setSharedPreferencesName(WeatherPresenter.MY_PREFS_NAME);
        addPreferencesFromResource(R.xml.preferences);
    }

    @Override
    public void onResume() {
        super.onResume();
        getView().setBackgroundColor(ContextCompat.getColor(getActivity(),android.R.color.white));
    }
}
