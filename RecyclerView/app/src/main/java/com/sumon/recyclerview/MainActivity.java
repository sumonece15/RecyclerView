package com.sumon.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcv;

    ArrayList<User> dataList = new ArrayList<>();
    private UserAdapter mAdapter;
    private ProgressBar pbLoader;
    private Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow = findViewById(R.id.btnShow);
        rcv = findViewById(R.id.rclview);
        pbLoader = findViewById(R.id.pbLoader);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new UserAdapter(dataList);

        rcv.setAdapter(mAdapter);

        loadData();


        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("SavedData", new Gson().toJson(dataList));
            }
        });

    }

    public void loadData(){
        pbLoader.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dataList.add(new User("Rezaul",""));
                dataList.add(new User("Ananna",""));
                dataList.add(new User("Sumon",""));
                dataList.add(new User("Tithi",""));

                //pbLoader.setVisibility(View.GONE);
                mAdapter.notifyDataSetChanged();

                loadDataMore();
            }
        },3000);

    }

    public void loadDataMore(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dataList.add(new User("werwe",""));
                dataList.add(new User("werew",""));
                dataList.add(new User("ssadasdsa",""));
                dataList.add(new User("utyujtty",""));
                mAdapter.notifyDataSetChanged();

                pbLoader.setVisibility(View.GONE);
            }
        },5000);
    }
}