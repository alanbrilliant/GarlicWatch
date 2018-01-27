package com.harbinger.garlicwatch;

import android.os.StrictMode;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import java.util.Arrays;
import java.util.List;

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

        t++;
       resultSTr =data.get(t);

       resultSTr = "$"+resultSTr.substring(1,resultSTr.length()-2);
        return resultSTr;
    }
}


