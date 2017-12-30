package com.harbinger.raiwatch;

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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String price = "Current price of RaiBlocks";
        final String price2 = "New price of RaiBlocks";


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
