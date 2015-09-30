package com.nerdery.umbrella.Conditions.view;

import com.nerdery.umbrella.Conditions.model.CurrentConditions;

/**
 * Created by Polycap on 9/27/2015.
 */
public interface IMainView {
    void displayData(CurrentConditions currentConditions);

    void setCurentConditions(CurrentConditions currentConditions);
}
