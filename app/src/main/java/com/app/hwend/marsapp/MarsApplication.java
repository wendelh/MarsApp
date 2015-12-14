package com.app.hwend.marsapp;

import android.app.Application;

import com.app.hwend.marsapp.utils.Keys;
import com.parse.Parse;
import com.parse.ParseCrashReporting;

import com.app.hwend.marsapp.utils.Constants;

public class MarsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable Crash Reporting
        ParseCrashReporting.enable(this);

        // Setup Parse
        Parse.initialize(this, Keys.PARSE_APP_ID, Keys.PARSE_CLIENT_KEY);
    }

}
