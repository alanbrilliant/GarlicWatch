package com.harbinger.raiwatch;

import android.os.StrictMode;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;


import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;

public class HttpHandler  {
    private static final String TAG = HttpHandler.class.getSimpleName();
    private String newURL;

    public HttpHandler (String s) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        newURL =s;
    }

    public String callApi(){
        HttpURLConnection urlConnection = null;

        StringBuilder result = new StringBuilder();

        System.out.println("test");
        try {
            URL url = new URL(newURL);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            System.out.println("test2r");

            urlConnection.connect();
            System.out.println("test3");

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            System.out.println("test4");

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            System.out.println("test5");

            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
                System.out.println(line + "retrt");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }


        String resultSTr = result.toString();

        List<String> data = Arrays.asList(resultSTr.split(" "));
        int t=0;
       while(data.get(t).equals("\"price_usd\":") == false){
           System.out.println(data.get(t));
            t++;
        }

      B  t++;
       resultSTr =data.get(t);
        return resultSTr;
    }
}


