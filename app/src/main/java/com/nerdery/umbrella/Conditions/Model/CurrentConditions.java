package com.nerdery.umbrella.Conditions.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.nerdery.umbrella.Conditions.rest.WeatherClient;
import com.nerdery.umbrella.Conditions.util.UmbrellaApp;

import rx.Observable;

/**
 * Created by Polycap on 9/27/2015.
 */
public class CurrentConditions {
    @SerializedName("response")
    @Expose
    private Response response;
    @SerializedName("current_observation")
    @Expose
    private CurrentObservation currentObservation;

    /**
     *
     * @return
     * The response
     */
    public Response getResponse() {
        return response;
    }

    /**
     *
     * @param response
     * The response
     */
    public void setResponse(Response response) {
        this.response = response;
    }

    /**
     *
     * @return
     * The currentObservation
     */
    public CurrentObservation getCurrentObservation() {
        return currentObservation;
    }

    /**
     *
     * @param currentObservation
     * The current_observation
     */
    public void setCurrentObservation(CurrentObservation currentObservation) {
        this.currentObservation = currentObservation;
    }


    public class CurrentObservation {

        @SerializedName("image")
        @Expose
        private Image image;
        @SerializedName("display_location")
        @Expose
        private DisplayLocation displayLocation;
        @SerializedName("observation_location")
        @Expose
        private ObservationLocation observationLocation;
        @SerializedName("estimated")
        @Expose
        private Estimated estimated;
        @SerializedName("station_id")
        @Expose
        private String stationId;
        @SerializedName("observation_time")
        @Expose
        private String observationTime;
        @SerializedName("observation_time_rfc822")
        @Expose
        private String observationTimeRfc822;
        @SerializedName("observation_epoch")
        @Expose
        private String observationEpoch;
        @SerializedName("local_time_rfc822")
        @Expose
        private String localTimeRfc822;
        @SerializedName("local_epoch")
        @Expose
        private String localEpoch;
        @SerializedName("local_tz_short")
        @Expose
        private String localTzShort;
        @SerializedName("local_tz_long")
        @Expose
        private String localTzLong;
        @SerializedName("local_tz_offset")
        @Expose
        private String localTzOffset;
        @SerializedName("weather")
        @Expose
        private String weather;
        @SerializedName("temperature_string")
        @Expose
        private String temperatureString;
        @SerializedName("temp_f")
        @Expose
        private Float tempF;
        @SerializedName("temp_c")
        @Expose
        private Float tempC;
        @SerializedName("relative_humidity")
        @Expose
        private String relativeHumidity;
        @SerializedName("wind_string")
        @Expose
        private String windString;
        @SerializedName("wind_dir")
        @Expose
        private String windDir;
        @SerializedName("wind_degrees")
        @Expose
        private Integer windDegrees;
        @SerializedName("wind_mph")
        @Expose
        private Float windMph;
        @SerializedName("wind_gust_mph")
        @Expose
        private String windGustMph;
        @SerializedName("wind_kph")
        @Expose
        private Float windKph;
        @SerializedName("wind_gust_kph")
        @Expose
        private String windGustKph;
        @SerializedName("pressure_mb")
        @Expose
        private String pressureMb;
        @SerializedName("pressure_in")
        @Expose
        private String pressureIn;
        @SerializedName("pressure_trend")
        @Expose
        private String pressureTrend;
        @SerializedName("dewpoint_string")
        @Expose
        private String dewpointString;
        @SerializedName("dewpoint_f")
        @Expose
        private Integer dewpointF;
        @SerializedName("dewpoint_c")
        @Expose
        private Integer dewpointC;
        @SerializedName("heat_index_string")
        @Expose
        private String heatIndexString;
        @SerializedName("heat_index_f")
        @Expose
        private String heatIndexF;
        @SerializedName("heat_index_c")
        @Expose
        private String heatIndexC;
        @SerializedName("windchill_string")
        @Expose
        private String windchillString;
        @SerializedName("windchill_f")
        @Expose
        private String windchillF;
        @SerializedName("windchill_c")
        @Expose
        private String windchillC;
        @SerializedName("feelslike_string")
        @Expose
        private String feelslikeString;
        @SerializedName("feelslike_f")
        @Expose
        private String feelslikeF;
        @SerializedName("feelslike_c")
        @Expose
        private String feelslikeC;
        @SerializedName("visibility_mi")
        @Expose
        private String visibilityMi;
        @SerializedName("visibility_km")
        @Expose
        private String visibilityKm;
        @SerializedName("solarradiation")
        @Expose
        private String solarradiation;
        @SerializedName("UV")
        @Expose
        private String UV;
        @SerializedName("precip_1hr_string")
        @Expose
        private String precip1hrString;
        @SerializedName("precip_1hr_in")
        @Expose
        private String precip1hrIn;
        @SerializedName("precip_1hr_metric")
        @Expose
        private String precip1hrMetric;
        @SerializedName("precip_today_string")
        @Expose
        private String precipTodayString;
        @SerializedName("precip_today_in")
        @Expose
        private String precipTodayIn;
        @SerializedName("precip_today_metric")
        @Expose
        private String precipTodayMetric;
        @SerializedName("icon")
        @Expose
        private String icon;
        @SerializedName("icon_url")
        @Expose
        private String iconUrl;
        @SerializedName("forecast_url")
        @Expose
        private String forecastUrl;
        @SerializedName("history_url")
        @Expose
        private String historyUrl;
        @SerializedName("ob_url")
        @Expose
        private String obUrl;
        @SerializedName("nowcast")
        @Expose
        private String nowcast;

        /**
         *
         * @return
         * The image
         */
        public Image getImage() {
            return image;
        }

        /**
         *
         * @param image
         * The image
         */
        public void setImage(Image image) {
            this.image = image;
        }

        /**
         *
         * @return
         * The displayLocation
         */
        public DisplayLocation getDisplayLocation() {
            return displayLocation;
        }

        /**
         *
         * @param displayLocation
         * The display_location
         */
        public void setDisplayLocation(DisplayLocation displayLocation) {
            this.displayLocation = displayLocation;
        }

        /**
         *
         * @return
         * The observationLocation
         */
        public ObservationLocation getObservationLocation() {
            return observationLocation;
        }

        /**
         *
         * @param observationLocation
         * The observation_location
         */
        public void setObservationLocation(ObservationLocation observationLocation) {
            this.observationLocation = observationLocation;
        }

        /**
         *
         * @return
         * The estimated
         */
        public Estimated getEstimated() {
            return estimated;
        }

        /**
         *
         * @param estimated
         * The estimated
         */
        public void setEstimated(Estimated estimated) {
            this.estimated = estimated;
        }

        /**
         *
         * @return
         * The stationId
         */
        public String getStationId() {
            return stationId;
        }

        /**
         *
         * @param stationId
         * The station_id
         */
        public void setStationId(String stationId) {
            this.stationId = stationId;
        }

        /**
         *
         * @return
         * The observationTime
         */
        public String getObservationTime() {
            return observationTime;
        }

        /**
         *
         * @param observationTime
         * The observation_time
         */
        public void setObservationTime(String observationTime) {
            this.observationTime = observationTime;
        }

        /**
         *
         * @return
         * The observationTimeRfc822
         */
        public String getObservationTimeRfc822() {
            return observationTimeRfc822;
        }

        /**
         *
         * @param observationTimeRfc822
         * The observation_time_rfc822
         */
        public void setObservationTimeRfc822(String observationTimeRfc822) {
            this.observationTimeRfc822 = observationTimeRfc822;
        }

        /**
         *
         * @return
         * The observationEpoch
         */
        public String getObservationEpoch() {
            return observationEpoch;
        }

        /**
         *
         * @param observationEpoch
         * The observation_epoch
         */
        public void setObservationEpoch(String observationEpoch) {
            this.observationEpoch = observationEpoch;
        }

        /**
         *
         * @return
         * The localTimeRfc822
         */
        public String getLocalTimeRfc822() {
            return localTimeRfc822;
        }

        /**
         *
         * @param localTimeRfc822
         * The local_time_rfc822
         */
        public void setLocalTimeRfc822(String localTimeRfc822) {
            this.localTimeRfc822 = localTimeRfc822;
        }

        /**
         *
         * @return
         * The localEpoch
         */
        public String getLocalEpoch() {
            return localEpoch;
        }

        /**
         *
         * @param localEpoch
         * The local_epoch
         */
        public void setLocalEpoch(String localEpoch) {
            this.localEpoch = localEpoch;
        }

        /**
         *
         * @return
         * The localTzShort
         */
        public String getLocalTzShort() {
            return localTzShort;
        }

        /**
         *
         * @param localTzShort
         * The local_tz_short
         */
        public void setLocalTzShort(String localTzShort) {
            this.localTzShort = localTzShort;
        }

        /**
         *
         * @return
         * The localTzLong
         */
        public String getLocalTzLong() {
            return localTzLong;
        }

        /**
         *
         * @param localTzLong
         * The local_tz_long
         */
        public void setLocalTzLong(String localTzLong) {
            this.localTzLong = localTzLong;
        }

        /**
         *
         * @return
         * The localTzOffset
         */
        public String getLocalTzOffset() {
            return localTzOffset;
        }

        /**
         *
         * @param localTzOffset
         * The local_tz_offset
         */
        public void setLocalTzOffset(String localTzOffset) {
            this.localTzOffset = localTzOffset;
        }

        /**
         *
         * @return
         * The weather
         */
        public String getWeather() {
            return weather;
        }

        /**
         *
         * @param weather
         * The weather
         */
        public void setWeather(String weather) {
            this.weather = weather;
        }

        /**
         *
         * @return
         * The temperatureString
         */
        public String getTemperatureString() {
            return temperatureString;
        }

        /**
         *
         * @param temperatureString
         * The temperature_string
         */
        public void setTemperatureString(String temperatureString) {
            this.temperatureString = temperatureString;
        }

        /**
         *
         * @return
         * The tempF
         */
        public Float getTempF() {
            return tempF;
        }

        /**
         *
         * @param tempF
         * The temp_f
         */
        public void setTempF(Float tempF) {
            this.tempF = tempF;
        }

        /**
         *
         * @return
         * The tempC
         */
        public Float getTempC() {
            return tempC;
        }

        /**
         *
         * @param tempC
         * The temp_c
         */
        public void setTempC(Float tempC) {
            this.tempC = tempC;
        }

        /**
         *
         * @return
         * The relativeHumidity
         */
        public String getRelativeHumidity() {
            return relativeHumidity;
        }

        /**
         *
         * @param relativeHumidity
         * The relative_humidity
         */
        public void setRelativeHumidity(String relativeHumidity) {
            this.relativeHumidity = relativeHumidity;
        }

        /**
         *
         * @return
         * The windString
         */
        public String getWindString() {
            return windString;
        }

        /**
         *
         * @param windString
         * The wind_string
         */
        public void setWindString(String windString) {
            this.windString = windString;
        }

        /**
         *
         * @return
         * The windDir
         */
        public String getWindDir() {
            return windDir;
        }

        /**
         *
         * @param windDir
         * The wind_dir
         */
        public void setWindDir(String windDir) {
            this.windDir = windDir;
        }

        /**
         *
         * @return
         * The windDegrees
         */
        public Integer getWindDegrees() {
            return windDegrees;
        }

        /**
         *
         * @param windDegrees
         * The wind_degrees
         */
        public void setWindDegrees(Integer windDegrees) {
            this.windDegrees = windDegrees;
        }

        /**
         *
         * @return
         * The windMph
         */
        public Float getWindMph() {
            return windMph;
        }

        /**
         *
         * @param windMph
         * The wind_mph
         */
        public void setWindMph(Float windMph) {
            this.windMph = windMph;
        }

        /**
         *
         * @return
         * The windGustMph
         */
        public String getWindGustMph() {
            return windGustMph;
        }

        /**
         *
         * @param windGustMph
         * The wind_gust_mph
         */
        public void setWindGustMph(String windGustMph) {
            this.windGustMph = windGustMph;
        }

        /**
         *
         * @return
         * The windKph
         */
        public Float getWindKph() {
            return windKph;
        }

        /**
         *
         * @param windKph
         * The wind_kph
         */
        public void setWindKph(Float windKph) {
            this.windKph = windKph;
        }

        /**
         *
         * @return
         * The windGustKph
         */
        public String getWindGustKph() {
            return windGustKph;
        }

        /**
         *
         * @param windGustKph
         * The wind_gust_kph
         */
        public void setWindGustKph(String windGustKph) {
            this.windGustKph = windGustKph;
        }

        /**
         *
         * @return
         * The pressureMb
         */
        public String getPressureMb() {
            return pressureMb;
        }

        /**
         *
         * @param pressureMb
         * The pressure_mb
         */
        public void setPressureMb(String pressureMb) {
            this.pressureMb = pressureMb;
        }

        /**
         *
         * @return
         * The pressureIn
         */
        public String getPressureIn() {
            return pressureIn;
        }

        /**
         *
         * @param pressureIn
         * The pressure_in
         */
        public void setPressureIn(String pressureIn) {
            this.pressureIn = pressureIn;
        }

        /**
         *
         * @return
         * The pressureTrend
         */
        public String getPressureTrend() {
            return pressureTrend;
        }

        /**
         *
         * @param pressureTrend
         * The pressure_trend
         */
        public void setPressureTrend(String pressureTrend) {
            this.pressureTrend = pressureTrend;
        }

        /**
         *
         * @return
         * The dewpointString
         */
        public String getDewpointString() {
            return dewpointString;
        }

        /**
         *
         * @param dewpointString
         * The dewpoint_string
         */
        public void setDewpointString(String dewpointString) {
            this.dewpointString = dewpointString;
        }

        /**
         *
         * @return
         * The dewpointF
         */
        public Integer getDewpointF() {
            return dewpointF;
        }

        /**
         *
         * @param dewpointF
         * The dewpoint_f
         */
        public void setDewpointF(Integer dewpointF) {
            this.dewpointF = dewpointF;
        }

        /**
         *
         * @return
         * The dewpointC
         */
        public Integer getDewpointC() {
            return dewpointC;
        }

        /**
         *
         * @param dewpointC
         * The dewpoint_c
         */
        public void setDewpointC(Integer dewpointC) {
            this.dewpointC = dewpointC;
        }

        /**
         *
         * @return
         * The heatIndexString
         */
        public String getHeatIndexString() {
            return heatIndexString;
        }

        /**
         *
         * @param heatIndexString
         * The heat_index_string
         */
        public void setHeatIndexString(String heatIndexString) {
            this.heatIndexString = heatIndexString;
        }

        /**
         *
         * @return
         * The heatIndexF
         */
        public String getHeatIndexF() {
            return heatIndexF;
        }

        /**
         *
         * @param heatIndexF
         * The heat_index_f
         */
        public void setHeatIndexF(String heatIndexF) {
            this.heatIndexF = heatIndexF;
        }

        /**
         *
         * @return
         * The heatIndexC
         */
        public String getHeatIndexC() {
            return heatIndexC;
        }

        /**
         *
         * @param heatIndexC
         * The heat_index_c
         */
        public void setHeatIndexC(String heatIndexC) {
            this.heatIndexC = heatIndexC;
        }

        /**
         *
         * @return
         * The windchillString
         */
        public String getWindchillString() {
            return windchillString;
        }

        /**
         *
         * @param windchillString
         * The windchill_string
         */
        public void setWindchillString(String windchillString) {
            this.windchillString = windchillString;
        }

        /**
         *
         * @return
         * The windchillF
         */
        public String getWindchillF() {
            return windchillF;
        }

        /**
         *
         * @param windchillF
         * The windchill_f
         */
        public void setWindchillF(String windchillF) {
            this.windchillF = windchillF;
        }

        /**
         *
         * @return
         * The windchillC
         */
        public String getWindchillC() {
            return windchillC;
        }

        /**
         *
         * @param windchillC
         * The windchill_c
         */
        public void setWindchillC(String windchillC) {
            this.windchillC = windchillC;
        }

        /**
         *
         * @return
         * The feelslikeString
         */
        public String getFeelslikeString() {
            return feelslikeString;
        }

        /**
         *
         * @param feelslikeString
         * The feelslike_string
         */
        public void setFeelslikeString(String feelslikeString) {
            this.feelslikeString = feelslikeString;
        }

        /**
         *
         * @return
         * The feelslikeF
         */
        public String getFeelslikeF() {
            return feelslikeF;
        }

        /**
         *
         * @param feelslikeF
         * The feelslike_f
         */
        public void setFeelslikeF(String feelslikeF) {
            this.feelslikeF = feelslikeF;
        }

        /**
         *
         * @return
         * The feelslikeC
         */
        public String getFeelslikeC() {
            return feelslikeC;
        }

        /**
         *
         * @param feelslikeC
         * The feelslike_c
         */
        public void setFeelslikeC(String feelslikeC) {
            this.feelslikeC = feelslikeC;
        }

        /**
         *
         * @return
         * The visibilityMi
         */
        public String getVisibilityMi() {
            return visibilityMi;
        }

        /**
         *
         * @param visibilityMi
         * The visibility_mi
         */
        public void setVisibilityMi(String visibilityMi) {
            this.visibilityMi = visibilityMi;
        }

        /**
         *
         * @return
         * The visibilityKm
         */
        public String getVisibilityKm() {
            return visibilityKm;
        }

        /**
         *
         * @param visibilityKm
         * The visibility_km
         */
        public void setVisibilityKm(String visibilityKm) {
            this.visibilityKm = visibilityKm;
        }

        /**
         *
         * @return
         * The solarradiation
         */
        public String getSolarradiation() {
            return solarradiation;
        }

        /**
         *
         * @param solarradiation
         * The solarradiation
         */
        public void setSolarradiation(String solarradiation) {
            this.solarradiation = solarradiation;
        }

        /**
         *
         * @return
         * The UV
         */
        public String getUV() {
            return UV;
        }

        /**
         *
         * @param UV
         * The UV
         */
        public void setUV(String UV) {
            this.UV = UV;
        }

        /**
         *
         * @return
         * The precip1hrString
         */
        public String getPrecip1hrString() {
            return precip1hrString;
        }

        /**
         *
         * @param precip1hrString
         * The precip_1hr_string
         */
        public void setPrecip1hrString(String precip1hrString) {
            this.precip1hrString = precip1hrString;
        }

        /**
         *
         * @return
         * The precip1hrIn
         */
        public String getPrecip1hrIn() {
            return precip1hrIn;
        }

        /**
         *
         * @param precip1hrIn
         * The precip_1hr_in
         */
        public void setPrecip1hrIn(String precip1hrIn) {
            this.precip1hrIn = precip1hrIn;
        }

        /**
         *
         * @return
         * The precip1hrMetric
         */
        public String getPrecip1hrMetric() {
            return precip1hrMetric;
        }

        /**
         *
         * @param precip1hrMetric
         * The precip_1hr_metric
         */
        public void setPrecip1hrMetric(String precip1hrMetric) {
            this.precip1hrMetric = precip1hrMetric;
        }

        /**
         *
         * @return
         * The precipTodayString
         */
        public String getPrecipTodayString() {
            return precipTodayString;
        }

        /**
         *
         * @param precipTodayString
         * The precip_today_string
         */
        public void setPrecipTodayString(String precipTodayString) {
            this.precipTodayString = precipTodayString;
        }

        /**
         *
         * @return
         * The precipTodayIn
         */
        public String getPrecipTodayIn() {
            return precipTodayIn;
        }

        /**
         *
         * @param precipTodayIn
         * The precip_today_in
         */
        public void setPrecipTodayIn(String precipTodayIn) {
            this.precipTodayIn = precipTodayIn;
        }

        /**
         *
         * @return
         * The precipTodayMetric
         */
        public String getPrecipTodayMetric() {
            return precipTodayMetric;
        }

        /**
         *
         * @param precipTodayMetric
         * The precip_today_metric
         */
        public void setPrecipTodayMetric(String precipTodayMetric) {
            this.precipTodayMetric = precipTodayMetric;
        }

        /**
         *
         * @return
         * The icon
         */
        public String getIcon() {
            return icon;
        }

        /**
         *
         * @param icon
         * The icon
         */
        public void setIcon(String icon) {
            this.icon = icon;
        }

        /**
         *
         * @return
         * The iconUrl
         */
        public String getIconUrl() {
            return iconUrl;
        }

        /**
         *
         * @param iconUrl
         * The icon_url
         */
        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        /**
         *
         * @return
         * The forecastUrl
         */
        public String getForecastUrl() {
            return forecastUrl;
        }

        /**
         *
         * @param forecastUrl
         * The forecast_url
         */
        public void setForecastUrl(String forecastUrl) {
            this.forecastUrl = forecastUrl;
        }

        /**
         *
         * @return
         * The historyUrl
         */
        public String getHistoryUrl() {
            return historyUrl;
        }

        /**
         *
         * @param historyUrl
         * The history_url
         */
        public void setHistoryUrl(String historyUrl) {
            this.historyUrl = historyUrl;
        }

        /**
         *
         * @return
         * The obUrl
         */
        public String getObUrl() {
            return obUrl;
        }

        /**
         *
         * @param obUrl
         * The ob_url
         */
        public void setObUrl(String obUrl) {
            this.obUrl = obUrl;
        }

        /**
         *
         * @return
         * The nowcast
         */
        public String getNowcast() {
            return nowcast;
        }

        /**
         *
         * @param nowcast
         * The nowcast
         */
        public void setNowcast(String nowcast) {
            this.nowcast = nowcast;
        }

    }
    public class DisplayLocation {

        @SerializedName("full")
        @Expose
        private String full;
        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("state")
        @Expose
        private String state;
        @SerializedName("state_name")
        @Expose
        private String stateName;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("country_iso3166")
        @Expose
        private String countryIso3166;
        @SerializedName("zip")
        @Expose
        private String zip;
        @SerializedName("magic")
        @Expose
        private String magic;
        @SerializedName("wmo")
        @Expose
        private String wmo;
        @SerializedName("latitude")
        @Expose
        private String latitude;
        @SerializedName("longitude")
        @Expose
        private String longitude;
        @SerializedName("elevation")
        @Expose
        private String elevation;

        /**
         *
         * @return
         * The full
         */
        public String getFull() {
            return full;
        }

        /**
         *
         * @param full
         * The full
         */
        public void setFull(String full) {
            this.full = full;
        }

        /**
         *
         * @return
         * The city
         */
        public String getCity() {
            return city;
        }

        /**
         *
         * @param city
         * The city
         */
        public void setCity(String city) {
            this.city = city;
        }

        /**
         *
         * @return
         * The state
         */
        public String getState() {
            return state;
        }

        /**
         *
         * @param state
         * The state
         */
        public void setState(String state) {
            this.state = state;
        }

        /**
         *
         * @return
         * The stateName
         */
        public String getStateName() {
            return stateName;
        }

        /**
         *
         * @param stateName
         * The state_name
         */
        public void setStateName(String stateName) {
            this.stateName = stateName;
        }

        /**
         *
         * @return
         * The country
         */
        public String getCountry() {
            return country;
        }

        /**
         *
         * @param country
         * The country
         */
        public void setCountry(String country) {
            this.country = country;
        }

        /**
         *
         * @return
         * The countryIso3166
         */
        public String getCountryIso3166() {
            return countryIso3166;
        }

        /**
         *
         * @param countryIso3166
         * The country_iso3166
         */
        public void setCountryIso3166(String countryIso3166) {
            this.countryIso3166 = countryIso3166;
        }

        /**
         *
         * @return
         * The zip
         */
        public String getZip() {
            return zip;
        }

        /**
         *
         * @param zip
         * The zip
         */
        public void setZip(String zip) {
            this.zip = zip;
        }

        /**
         *
         * @return
         * The magic
         */
        public String getMagic() {
            return magic;
        }

        /**
         *
         * @param magic
         * The magic
         */
        public void setMagic(String magic) {
            this.magic = magic;
        }

        /**
         *
         * @return
         * The wmo
         */
        public String getWmo() {
            return wmo;
        }

        /**
         *
         * @param wmo
         * The wmo
         */
        public void setWmo(String wmo) {
            this.wmo = wmo;
        }

        /**
         *
         * @return
         * The latitude
         */
        public String getLatitude() {
            return latitude;
        }

        /**
         *
         * @param latitude
         * The latitude
         */
        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        /**
         *
         * @return
         * The longitude
         */
        public String getLongitude() {
            return longitude;
        }

        /**
         *
         * @param longitude
         * The longitude
         */
        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        /**
         *
         * @return
         * The elevation
         */
        public String getElevation() {
            return elevation;
        }

        /**
         *
         * @param elevation
         * The elevation
         */
        public void setElevation(String elevation) {
            this.elevation = elevation;
        }

    }
    public class Estimated {


    }
    public class Features {

        @SerializedName("conditions")
        @Expose
        private Integer conditions;

        /**
         *
         * @return
         * The conditions
         */
        public Integer getConditions() {
            return conditions;
        }

        /**
         *
         * @param conditions
         * The conditions
         */
        public void setConditions(Integer conditions) {
            this.conditions = conditions;
        }

    }
    public class Image {

        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("link")
        @Expose
        private String link;

        /**
         *
         * @return
         * The url
         */
        public String getUrl() {
            return url;
        }

        /**
         *
         * @param url
         * The url
         */
        public void setUrl(String url) {
            this.url = url;
        }

        /**
         *
         * @return
         * The title
         */
        public String getTitle() {
            return title;
        }

        /**
         *
         * @param title
         * The title
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         *
         * @return
         * The link
         */
        public String getLink() {
            return link;
        }

        /**
         *
         * @param link
         * The link
         */
        public void setLink(String link) {
            this.link = link;
        }

    }
    public class ObservationLocation {

        @SerializedName("full")
        @Expose
        private String full;
        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("state")
        @Expose
        private String state;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("country_iso3166")
        @Expose
        private String countryIso3166;
        @SerializedName("latitude")
        @Expose
        private String latitude;
        @SerializedName("longitude")
        @Expose
        private String longitude;
        @SerializedName("elevation")
        @Expose
        private String elevation;

        /**
         *
         * @return
         * The full
         */
        public String getFull() {
            return full;
        }

        /**
         *
         * @param full
         * The full
         */
        public void setFull(String full) {
            this.full = full;
        }

        /**
         *
         * @return
         * The city
         */
        public String getCity() {
            return city;
        }

        /**
         *
         * @param city
         * The city
         */
        public void setCity(String city) {
            this.city = city;
        }

        /**
         *
         * @return
         * The state
         */
        public String getState() {
            return state;
        }

        /**
         *
         * @param state
         * The state
         */
        public void setState(String state) {
            this.state = state;
        }

        /**
         *
         * @return
         * The country
         */
        public String getCountry() {
            return country;
        }

        /**
         *
         * @param country
         * The country
         */
        public void setCountry(String country) {
            this.country = country;
        }

        /**
         *
         * @return
         * The countryIso3166
         */
        public String getCountryIso3166() {
            return countryIso3166;
        }

        /**
         *
         * @param countryIso3166
         * The country_iso3166
         */
        public void setCountryIso3166(String countryIso3166) {
            this.countryIso3166 = countryIso3166;
        }

        /**
         *
         * @return
         * The latitude
         */
        public String getLatitude() {
            return latitude;
        }

        /**
         *
         * @param latitude
         * The latitude
         */
        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        /**
         *
         * @return
         * The longitude
         */
        public String getLongitude() {
            return longitude;
        }

        /**
         *
         * @param longitude
         * The longitude
         */
        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        /**
         *
         * @return
         * The elevation
         */
        public String getElevation() {
            return elevation;
        }

        /**
         *
         * @param elevation
         * The elevation
         */
        public void setElevation(String elevation) {
            this.elevation = elevation;
        }

    }
    public class Response {

        @SerializedName("version")
        @Expose
        private String version;
        @SerializedName("termsofService")
        @Expose
        private String termsofService;
        @SerializedName("features")
        @Expose
        private Features features;

        /**
         *
         * @return
         * The version
         */
        public String getVersion() {
            return version;
        }

        /**
         *
         * @param version
         * The version
         */
        public void setVersion(String version) {
            this.version = version;
        }

        /**
         *
         * @return
         * The termsofService
         */
        public String getTermsofService() {
            return termsofService;
        }

        /**
         *
         * @param termsofService
         * The termsofService
         */
        public void setTermsofService(String termsofService) {
            this.termsofService = termsofService;
        }

        /**
         *
         * @return
         * The features
         */
        public Features getFeatures() {
            return features;
        }

        /**
         *
         * @param features
         * The features
         */
        public void setFeatures(Features features) {
            this.features = features;
        }

    }

    static public Observable<CurrentConditions> returnCurrentConditions( String mUserZipCode){
        WeatherClient mWeatherClient = new WeatherClient(UmbrellaApp.getContext());
        return mWeatherClient.getCurrentConditions(mUserZipCode);
    }
}
