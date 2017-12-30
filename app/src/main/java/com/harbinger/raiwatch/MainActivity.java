package com.harbinger.raiwatch;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.*;

import org.json.JSONObject;


import java.net.*;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HttpURLConnection urlConnection;

        StringBuilder result = new StringBuilder();


        try {
            URL url = new URL("https://api.coinmarketcap.com/v1/ticker/raiblocks/");
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            urlConnection.disconnect();

        } catch (Exception e){
            e.printStackTrace();
        }

        String resultSTr = result.toString();



    }



}
