package com.nerdery.umbrella.NestedRecylerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nerdery.umbrella.R;
import com.nerdery.umbrella.model.Day;
import com.nerdery.umbrella.model.DayConditions;
import com.nerdery.umbrella.model.ForecastCondition;
import com.nerdery.umbrella.widget.DynamicGridLayoutManager;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.concurrent.locks.Condition;

/**
 * Created by Polycap on 9/27/2015.
 */
public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.DailyViewHolder> {
    private static final String CLEAR = "Clear";
    private static final String IconEndpoint = "http://nerdery-umbrella.s3.amazonaws.com/";

    private static final String CLOUDY = "Cloudy";
    private static final String PARTLYSUNNY = "Partly Sunny";
    private static final String PARTLYCLOUDY = "Partly Cloudy";
    private static final String MOSTLYCLOUDY = "Mostly Cloudy";
    private static final String HAZY = "Hazy";
    private static final String RAIN = "Rain";
    private static final String SUNNY = "Runny";
    private static final String SNOW = "Snow";
    private static final String OVERCAST = "Overcast";


    private static final String TAG = DailyAdapter.class.getSimpleName();
    private List<Day> dayConditions;
    private Context context;
    private boolean metricMode;
    private Long intialDay = 0L;

    public DailyAdapter(List<Day> dayConditions) {
        this.dayConditions = dayConditions;
        Log.v(TAG, "hourly conditions size: " + dayConditions.size());
    }

    @Override
    public DailyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forecast_cardview, parent, false);
        context = parent.getContext();
        return new DailyViewHolder(view);
    }

    /**
     * Index is initially set to 0 and after determining how many hours are left in the day
     * set the index to the number of hours left in the day if the index is zero, after that
     * increase the current index by 24 to get the next days information
     * <p>
     * always gets at most 8 hours out of every day to pass to the hourly grid
     */

    @Override
    public void onBindViewHolder(DailyViewHolder holder, int position) {

        if (dayConditions.size() > position) {
            if(intialDay == 0L)
            intialDay = dayConditions.get(position).yday;
            Day day = dayConditions.get(position);
            String dayName = day.dayName;

            if(intialDay.equals(dayConditions.get(position).yday)){
                dayName = "Today";
            }else if((intialDay+1L) == (dayConditions.get(position).yday)){
                dayName = "Tomorrow";
            }
            holder.day.setText(dayName);
            holder.forecastBlock.setLayoutManager(new DynamicGridLayoutManager(context, 4));
            HourlyAdapter adapter = new HourlyAdapter(day.conditions);
            adapter.setHasStableIds(true);
            holder.forecastBlock.setAdapter(adapter);

        }

    }

    @Override
    public long getItemId(int position) {
        return dayConditions.get(position).yday;
    }



    @Override
    public int getItemCount() {
        return dayConditions.size();
    }

    public void setMetricMode(boolean metricMode) {
        this.metricMode = metricMode;
    }

    public class DailyViewHolder extends RecyclerView.ViewHolder {
        RecyclerView forecastBlock;
        TextView day;

        public DailyViewHolder(View itemView) {
            super(itemView);
            day = (TextView) itemView.findViewById(R.id.day_of_the_week);
            forecastBlock = (RecyclerView) itemView.findViewById(R.id.hourlygrid);
        }
    }

    private class HourlyAdapter extends RecyclerView.Adapter<HourlyAdapter.BlockViewHolder> {
        private List<DayConditions> conditions;

        public HourlyAdapter(List<DayConditions> conditions) {
            this.conditions = conditions;
        }

        @Override
        public long getItemId(int position) {
            return conditions.get(position).hashCode();
        }

        @Override
        public BlockViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.hourlyitem, parent, false);
            return new BlockViewHolder(view);
        }

        @Override
        public void onBindViewHolder(BlockViewHolder holder, int position) {
            String degreeSign = String.valueOf((char) 0x00B0);

            if(!metricMode) {
                String fahrenheightDegrees = String.valueOf(conditions.get(position).tempF);
                holder.temp.setText(fahrenheightDegrees+degreeSign);
            }
            else {
                String celciusDegrees = String.valueOf(conditions.get(position).tempC);
                holder.temp.setText(celciusDegrees+degreeSign);
            }

            holder.timeofday.setText(conditions.get(position).time);
            String mCondition = conditions.get(position).condition;
            Log.v(TAG, "Condition: "+mCondition);
            mCondition = mCondition.toLowerCase().replace(" ","");

            Picasso.with(context)
                    .load(IconEndpoint + mCondition + ".png")
                    .placeholder(R.drawable.clear)
                            .into(holder.weatherIcon);
        }

        @Override
        public int getItemCount() {
            return conditions.size();
        }

        public class BlockViewHolder extends RecyclerView.ViewHolder {
            TextView temp;
            TextView timeofday;
            ImageView weatherIcon;

            public BlockViewHolder(View itemView) {
                super(itemView);
                temp = (TextView) itemView.findViewById(R.id.temperature_content);
                timeofday = (TextView) itemView.findViewById(R.id.timeof_day);
                weatherIcon = (ImageView) itemView.findViewById(R.id.weather_icon);
            }
        }
    }
}

