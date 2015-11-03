package com.app.hwend.marsapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.app.hwend.marsapp.maasAPI.MaasRequestTask;
import com.app.hwend.marsapp.model.Report;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.squareup.otto.ThreadEnforcer;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    static Bus bus = new Bus(ThreadEnforcer.MAIN);
    private static final String TAG = "MainActivity";

    @Bind(R.id.textView_atmo_opacity) TextView textView_atmo_opacity;
    @Bind(R.id.textView_max_temp) TextView textView_max_temp;
    @Bind(R.id.textView_min_temp) TextView textView_min_temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Register on OTTO-BUS
        bus.register(this);

        // Bind on ButterKnife
        ButterKnife.bind(this);

        textView_atmo_opacity.setText("waiting for data from curiosity rover on mars...");
        textView_max_temp.setText("waiting for data from curiosity rover on mars...");
        textView_min_temp.setText("waiting for data from curiosity rover on mars...");
    }

    @Override
    public void onResume() {
        super.onResume();
        new MaasRequestTask(bus).execute();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Subscribe
    public void updateWeatherData(Report report) {

        Log.i(TAG, "Report Object from MainActivity: " + report.toString());
        textView_atmo_opacity.setText(report.getAtmo_opacity());
        textView_max_temp.setText(report.getMax_temp());
        textView_min_temp.setText(report.getMin_temp());
    }


}
