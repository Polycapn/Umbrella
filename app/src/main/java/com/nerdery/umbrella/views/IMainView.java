package com.nerdery.umbrella.views;

import com.nerdery.umbrella.models.CurrentConditions;

/**
 * Created by Polycap on 9/27/2015.
 */
public interface IMainView {
    void displayData(CurrentConditions currentConditions);

    void setCurentConditions(CurrentConditions currentConditions, boolean metricMode);
}
