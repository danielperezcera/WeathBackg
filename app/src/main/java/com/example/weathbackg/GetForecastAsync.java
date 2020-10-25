package com.example.weathbackg;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.util.List;

public class GetForecastAsync implements Runnable {
    private MainActivity activity;
    private String city;

    /**
     * Sets up the runnable to be called. It needs the MainActivity so it can run code on the
     * UI thread, and also the city so that it can get its weather conditions.
     * @param activity
     * @param city
     */

    public GetForecastAsync(MainActivity activity, String city) {
        this.activity = activity;
        this.city = city;
    }




    @Override
    public void run() {
        // This is the function that will be run on the background thread.
        WeatherDataLoader loader = new WeatherDataLoader();

        // Now, call the function that will get the results from the API and then when it is done,
        // it will call the "handleResult" function on this new WeatherConditionsResultHandler
        // object that we are giving it.

        final WeatherForecast forecast = loader.getForecastAndPostResults(city);

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // This is code that will now run on the UI thread. Call the function in
                // MainActivity that will update the UI correctly.
                activity.handleWeatherForecastResult(forecast);
            }
        });
    }
}