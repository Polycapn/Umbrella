package com.nerdery.umbrella.Conditions.view;

import com.nerdery.umbrella.model.CurrentConditions;

/**
 * Created by Polycap on 9/27/2015.
 */
public interface IMainView {
    void displayData(CurrentConditions currentConditions);

    void setCurentConditions(CurrentConditions currentConditions, boolean metricMode);
}
