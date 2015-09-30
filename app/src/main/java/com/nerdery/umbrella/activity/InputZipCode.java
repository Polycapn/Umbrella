package com.nerdery.umbrella.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.widget.EditText;

import com.nerdery.umbrella.Conditions.model.CurrentConditions;
import com.nerdery.umbrella.Conditions.presenter.CurrentPresenter;
import com.nerdery.umbrella.Conditions.util.UmbrellaApp;
import com.nerdery.umbrella.Conditions.view.IMainView;
import com.nerdery.umbrella.R;

/**
 * Created by Polycap on 9/29/2015.
 */
public class InputZipCode extends DialogFragment  {

    private SharedPreferences sZipcode;
    private EditText editZipCode;
    String mZipcode;
    UmbrellaApp getContext;
    CurrentPresenter mCurrentPresenter;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.get_zipcode, null))
                // Add action buttons
                .setPositiveButton(R.string.enter, (dialog, id) -> {

                    sZipcode = getActivity().getSharedPreferences("ZipCode", Context.MODE_PRIVATE);
//                    editZipCode.getText();

                    SharedPreferences sharedPreferences = PreferenceManager
                            .getDefaultSharedPreferences(getContext);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("ZipCode", "");
                    editor.apply();
//                    PreferenceManager.getDefaultSharedPreferences(getContext).edit().putString("ZipCode", "ZipCode").commit();
//
                    String UserZipCode = PreferenceManager.getDefaultSharedPreferences(getContext).getString("ZipCode", "");
                    mCurrentPresenter.getData(UserZipCode);

                });
        return builder.create();
    }
}
