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



        final HttpHandler handler = new HttpHandler("https://api.coinmarketcap.com/v1/ticker/raiblocks/");
         String resultSTr = handler.callApi();
        final String price = resultSTr;



        final TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(price);

        Button changeText = (Button) findViewById(R.id.btnChangeText); //get the id for button
        changeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newResultSTr = handler.callApi();
                String price2 = "New price of RaiBlocks: " + newResultSTr;
                textView.setText(price2); //set the text after clicking button
            }
        });

    }



}
