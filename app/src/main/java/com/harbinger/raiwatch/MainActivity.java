package com.harbinger.raiwatch;

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

import org.json.JSONObject;


import java.net.*;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HttpURLConnection urlConnection = null;

        StringBuilder result = new StringBuilder();


        try {
            URL url = new URL("https://api.coinmarketcap.com/v1/ticker/raiblocks/");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
                System.out.println(line);
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }


        String resultSTr = result.toString();




        final String price = resultSTr;
        final String price2 = "New price of RaiBlocks: " + resultSTr;


        final TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(price);

        Button changeText = (Button) findViewById(R.id.btnChangeText); //get the id for button
        changeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textView.setText(price2); //set the text after clicking button
            }
        });

    }



}
