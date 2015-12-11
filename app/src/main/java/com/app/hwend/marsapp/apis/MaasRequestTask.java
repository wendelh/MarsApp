package com.app.hwend.marsapp.apis;

import android.os.AsyncTask;
import android.util.Log;

import com.app.hwend.marsapp.model.Report;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.otto.Bus;

import org.json.JSONObject;

import utils.Constants;

public class MaasRequestTask extends AsyncTask <Void, String, String>{

    private final static String TAG = "MaasRequestTask";
    private final Bus eventBus;

    public MaasRequestTask(Bus eventBus){
        this.eventBus = eventBus;
    }

    @Override
    protected String doInBackground(Void... params) {

        Log.i(TAG,"doInBackground reached");
        OkHttpClient httpClient = new OkHttpClient();

        try {
            Request request = new Request.Builder()
                    .url(Constants.URL_MARS_WEATHER)
                    .build();
            Response response = httpClient.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            Log.e(TAG, "Request from Maas API failed with exception: " + e.toString());
        }
        return null;
    }

    @Override
    protected void onPostExecute(String rawData) {

        if (rawData != null) {
            try {
                JSONObject JObject = new JSONObject(rawData);
                String JsonString = JObject.get("report").toString();
                Gson gson = new Gson();
                Report report = gson.fromJson(JsonString, Report.class);

                eventBus.post(report);
                Log.i(TAG, "Report Object from Ma: " + report.toString());

            } catch (Exception e) {
                Log.e(TAG, "onPostExecute failed by request from MAAS API with exception: " + e.toString());
            }
        }
    }
}
