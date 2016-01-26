package com.example.espenaj.ifi_rating.util;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by espenaj on 1/14/16.
 */
public class JSONParser {
    static InputStream is = null;
    static JSONObject json = null;
    static  String json_string = "";

    public JSONParser() {

    }

    public JSONArray getJson(String url_in) {
        HttpURLConnection connection = null;
        int status = 0;
        try {
            URL url = new URL(url_in);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            status = connection.getResponseCode();

            Log.d("getJson", "" + connection.getResponseCode());
            Log.d("getJson", "" + connection.getResponseMessage());

            switch (status) {
                case 202:
                    Log.d("getJson", "case 200!");
                    return null;
                case 200:
                    BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder builder = new StringBuilder();
                    String lineIn;

                    while((lineIn = buffer.readLine()) != null) {
                        builder.append(lineIn+"\n");
                    }

                    buffer.close();
                    JSONArray jsonObject = new JSONArray(builder.toString());
                    return  jsonObject;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

}
