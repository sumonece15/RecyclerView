package com.sumon.recyclerviewusingsearchview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    ImageView desc_img;
    TextView desc_text1, desc_text2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        desc_img = (ImageView) findViewById(R.id.desc_img);
        desc_text1 = (TextView) findViewById(R.id.desc_Header);
        desc_text2 = (TextView) findViewById(R.id.desc_Desc);

        desc_img.setImageResource(getIntent().getIntExtra("imgName", 0));
        desc_text1.setText(getIntent().getStringExtra("header"));
        desc_text2.setText(getIntent().getStringExtra("desc"));
    }
}