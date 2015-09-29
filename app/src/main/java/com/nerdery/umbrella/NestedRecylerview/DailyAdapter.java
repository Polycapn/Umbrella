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
import com.nerdery.umbrella.model.ForecastCondition;
import com.nerdery.umbrella.widget.DynamicGridLayoutManager;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

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


    private static final String TAG = DailyAdapter.class.getSimpleName();
    private List<ForecastCondition> hourlyConditions;
    private int currentIndex;
    private Context context;

    public DailyAdapter(List<ForecastCondition> hourlyConditions) {
        this.hourlyConditions = hourlyConditions;
        currentIndex = 0;
        Log.v(TAG, "hourly conditions size: " + hourlyConditions.size());
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
        if (hourlyConditions.size() > (currentIndex)) {
            ForecastCondition hourCondition = hourlyConditions.get(currentIndex);
            holder.day.setText(hourCondition.day);
            int hld = 24 - hourCondition.hour;
            hld = (hld < 8) ? (24 - hourCondition.hour) : 8;

            List<ForecastCondition> dayBlock = new ArrayList<>();

            for (int i = 0; i < hld; i++) {
                if (hourlyConditions.size() > (currentIndex + i))
                    dayBlock.add(hourlyConditions.get(currentIndex + i));
            }

        Log.v(TAG,"day = "+hourlyConditions.get(position).day);
            if (dayBlock.size() > 0) {
                holder.forecastBlock.setLayoutManager(new  DynamicGridLayoutManager(context, 4));
                HourlyAdapter adapter = new HourlyAdapter(dayBlock);
                holder.forecastBlock.setAdapter(adapter);
            }
            currentIndex = (currentIndex == 0) ? hld : currentIndex + 24;
            Log.v(TAG, "final index:" + currentIndex);
        }

    }

    @Override
    public int getItemCount() {
        return 7;
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
        private List<ForecastCondition> dayBlock;

        public HourlyAdapter(List<ForecastCondition> dayBlock) {
            this.dayBlock = dayBlock;
        }

        @Override
        public BlockViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.hourlyitem, parent, false);
            return new BlockViewHolder(view);
        }

        @Override
        public void onBindViewHolder(BlockViewHolder holder, int position) {
            holder.temp.setText("" + (int) dayBlock.get(position).tempFahrenheit);
            holder.timeofday.setText(dayBlock.get(position).displayTime);
            String mCondition = dayBlock.get(position).condition;
            Log.v(TAG, "Condition: "+mCondition);

            switch (mCondition) {
                case CLEAR:
                    Picasso.with(context).load(IconEndpoint + "clear.png").placeholder(R.drawable.clear)
                            .into(holder.weatherIcon);
                    break;
                case CLOUDY:
                    Picasso.with(context).load(IconEndpoint + "cloudy.png").placeholder(R.drawable.cloudy)
                            .into(holder.weatherIcon);
                    break;
                case PARTLYCLOUDY:
                    Picasso.with(context).load(IconEndpoint + "partlycloudy.png").placeholder(R.drawable.partlycloudy)
                            .into(holder.weatherIcon);
                    break;
                case MOSTLYCLOUDY:
                    Picasso.with(context).load(IconEndpoint + "mostlycloudy.png").placeholder(R.drawable.mostlycloudy)
                            .into(holder.weatherIcon);
                    break;
                case HAZY:
                    Picasso.with(context).load(IconEndpoint + "hazy.png").placeholder(R.drawable.haze)
                            .into(holder.weatherIcon);
                    break;
                case RAIN:
                    Picasso.with(context).load(IconEndpoint + "rain.png").placeholder(R.drawable.rain)
                            .into(holder.weatherIcon);
                    break;
                case SNOW:
                    Picasso.with(context).load(IconEndpoint + "snow.png").placeholder(R.drawable.snow)
                            .into(holder.weatherIcon);
                    break;
                case SUNNY:
                    Picasso.with(context).load(IconEndpoint + "sunny.png").placeholder(R.drawable.sunny)
                            .into(holder.weatherIcon);
                    break;
                case PARTLYSUNNY:
                    Picasso.with(context).load(IconEndpoint + "partlysunny.png").placeholder(R.drawable.partlysunny)
                            .into(holder.weatherIcon);
                    break;
//                case PARTLYCLOUDY:
//                    Picasso.with(context).load(IconEndpoint + "partlycloudy.png").placeholder(R.drawable.partlycloudy)
//                            .into(holder.weatherIcon);
//                    break;
//                case PARTLYCLOUDY:
//                    Picasso.with(context).load(IconEndpoint + "partlycloudy.png").placeholder(R.drawable.partlycloudy)
//                            .into(holder.weatherIcon);
//                    break;
//                case PARTLYCLOUDY:
//                    Picasso.with(context).load(IconEndpoint + "partlycloudy.png").placeholder(R.drawable.partlycloudy)
//                            .into(holder.weatherIcon);
//                    break;
//                case PARTLYCLOUDY:
//                    Picasso.with(context).load(IconEndpoint + "partlycloudy.png").placeholder(R.drawable.partlycloudy)
//                            .into(holder.weatherIcon);
//                    break;
//                case PARTLYCLOUDY:
//                    Picasso.with(context).load(IconEndpoint + "partlycloudy.png").placeholder(R.drawable.partlycloudy)
//                            .into(holder.weatherIcon);
//                    break;
//                case PARTLYCLOUDY:
//                    Picasso.with(context).load(IconEndpoint + "partlycloudy.png").placeholder(R.drawable.partlycloudy)
//                            .into(holder.weatherIcon);
//                    break;
//                case PARTLYCLOUDY:
//                    Picasso.with(context).load(IconEndpoint + "partlycloudy.png").placeholder(R.drawable.partlycloudy)
//                            .into(holder.weatherIcon);
//                    break;

            }
        }

        @Override
        public int getItemCount() {
            return dayBlock.size();
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

