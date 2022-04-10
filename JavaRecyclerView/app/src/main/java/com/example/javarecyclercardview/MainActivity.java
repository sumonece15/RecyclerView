package com.example.javarecyclercardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int flags[] = {R.drawable.bangladesh_icon,R.drawable.india_icon,R.drawable.pakistan_icon,
            R.drawable.china_icon,R.drawable.afghanistan_icon,R.drawable.iraq_icon,
            R.drawable.italy_icon,R.drawable.canada_icon,R.drawable.mexico_icon,
            R.drawable.nepal_icon,R.drawable.norway_icon,R.drawable.oman_icon,
            R.drawable.peru_icon,R.drawable.poland_icon,R.drawable.spain_icon,
            R.drawable.sudan_icon

    };

    String [] title, desc;
    RecyclerView recyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewId);

        title = getResources().getStringArray(R.array.country_names);
        desc = getResources().getStringArray(R.array.country_desc);

        myAdapter = new MyAdapter(this, title, desc, flags);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter.setOnItemClickListener(new MyAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {

                Toast.makeText(getApplicationContext(),"onItem clicked"+position, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onLongItemClick(int position, View v) {
                Toast.makeText(getApplicationContext(),"onItemLong clicked"+position, Toast.LENGTH_SHORT).show();

            }
        });
    }
}