package com.app.hwend.marsapp;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseCrashReporting;

import utils.Constants;

public class MarsApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable Crash Reporting
        ParseCrashReporting.enable(this);

        // Setup Parse
        Parse.initialize(this, Constants.PARSE_APP_ID, Constants.PARSE_CLIENT_KEY);
    }


}
