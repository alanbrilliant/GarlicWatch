package com.harbinger.garlicwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final HttpHandler handler = new HttpHandler("http://api.cryptocoincharts.info/listCoins");
         String resultSTr = handler.callApi();
        final String price = resultSTr;

        final String price2 = resultSTr;




        final TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(price);

        Button changeText = (Button) findViewById(R.id.btnChangeText); //get the id for button
        changeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newResultSTr = handler.callApi();
                String price2 =  newResultSTr;
                textView.setText(price2); //set the text after clicking button
            }
        });

    }



}
