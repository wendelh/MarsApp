package com.app.hwend.marsapp.model;

public class Report {

    private String terrestrial_date;
    private String sol;
    private String ls;
    private String min_temp;
    private String min_temp_fahrenheit;
    private String max_temp;
    private String max_temp_fahrenheit;
    private String pressure;
    private String pressure_string;
    private String abs_humidity;
    private String wind_speed;
    private String wind_direction;
    private String atmo_opacity;
    private String season;
    private String sunrise;
    private String sunset;


    public Report(String terrestrial_date, String sol, String ls, String min_temp,
                  String min_temp_fahrenheit, String max_temp, String max_temp_fahrenheit,
                  String pressure, String pressure_string, String abs_humidity, String wind_speed,
                  String wind_direction, String atmo_opacity, String season, String sunrise, String sunset) {
        this.terrestrial_date = terrestrial_date;
        this.sol = sol;
        this.ls = ls;
        this.min_temp = min_temp;
        this.min_temp_fahrenheit = min_temp_fahrenheit;
        this.max_temp = max_temp;
        this.max_temp_fahrenheit = max_temp_fahrenheit;
        this.pressure = pressure;
        this.pressure_string = pressure_string;
        this.abs_humidity = abs_humidity;
        this.wind_speed = wind_speed;
        this.wind_direction = wind_direction;
        this.atmo_opacity = atmo_opacity;
        this.season = season;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    @Override
    public String toString() {
        return "Report{" +
                "terrestrial_date='" + terrestrial_date + '\'' +
                ", sol='" + sol + '\'' +
                ", ls='" + ls + '\'' +
                ", min_temp='" + min_temp + '\'' +
                ", min_temp_fahrenheit='" + min_temp_fahrenheit + '\'' +
                ", max_temp='" + max_temp + '\'' +
                ", max_temp_fahrenheit='" + max_temp_fahrenheit + '\'' +
                ", pressure='" + pressure + '\'' +
                ", pressure_string='" + pressure_string + '\'' +
                ", abs_humidity='" + abs_humidity + '\'' +
                ", wind_speed='" + wind_speed + '\'' +
                ", wind_direction='" + wind_direction + '\'' +
                ", atmo_opacity='" + atmo_opacity + '\'' +
                ", season='" + season + '\'' +
                ", sunrise='" + sunrise + '\'' +
                ", sunset='" + sunset + '\'' +
                '}';
    }

    public String getTerrestrial_date() {
        return terrestrial_date;
    }

    public String getSol() {
        return sol;
    }

    public String getLs() {
        return ls;
    }

    public String getMin_temp() {
        return min_temp;
    }

    public String getMin_temp_fahrenheit() {
        return min_temp_fahrenheit;
    }

    public String getMax_temp() {
        return max_temp;
    }

    public String getMax_temp_fahrenheit() {
        return max_temp_fahrenheit;
    }

    public String getPressure() {
        return pressure;
    }

    public String getPressure_string() {
        return pressure_string;
    }

    public String getAbs_humidity() {
        return abs_humidity;
    }

    public String getWind_speed() {
        return wind_speed;
    }

    public String getWind_direction() {
        return wind_direction;
    }

    public String getAtmo_opacity() {
        return atmo_opacity;
    }

    public String getSeason() {
        return season;
    }

    public String getSunrise() {
        return sunrise;
    }

    public String getSunset() {
        return sunset;
    }
}
