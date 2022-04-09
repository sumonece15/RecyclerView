package com.sumon.glidedemonstration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.pimg);
        text1 = (TextView) findViewById(R.id.text1);


        Glide.with(this).load("https://rukminim2.flixcart.com/image/800/960/kzhbfrk0/shoe/z/w/z/8-ga1553-9-reebok-all-black-original-imagbhfxe7hgwsaj.jpeg?q=50").into(img);
        text1.setText("Running shoes for men (Black)");

    }
}