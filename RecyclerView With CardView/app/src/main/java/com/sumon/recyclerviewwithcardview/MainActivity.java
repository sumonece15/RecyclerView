package com.sumon.recyclerviewwithcardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rev;
    myAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Recycler and Card View");

        rev = (RecyclerView) findViewById(R.id.recview);
        rev.setLayoutManager(new LinearLayoutManager(this));


        adapter = new myAdapter(dataQueue());
        rev.setAdapter(adapter);
    }


    public ArrayList<Model> dataQueue(){

        ArrayList<Model> holder = new ArrayList<>();

        Model object1 = new Model();
        object1.setHeader("C Programming");
        object1.setDesc("Desktop Programming language");
        object1.setImgName(R.drawable.cp);
        holder.add(object1);

        Model object2 = new Model();
        object2.setHeader("C++ Programming");
        object2.setDesc("Desktop Programming language");
        object2.setImgName(R.drawable.cpp);
        holder.add(object2);

        Model object3 = new Model();
        object3.setHeader("Dart Programming");
        object3.setDesc("Desktop Programming language");
        object3.setImgName(R.drawable.dart);
        holder.add(object3);

        Model object4 = new Model();
        object4.setHeader("Java Programming");
        object4.setDesc("Desktop Programming language");
        object4.setImgName(R.drawable.java);
        holder.add(object4);

        Model object5 = new Model();
        object5.setHeader("JavaScript Programming");
        object5.setDesc("Desktop Programming language");
        object5.setImgName(R.drawable.javasript);
        holder.add(object5);

        Model object6 = new Model();
        object6.setHeader("PHP Programming");
        object6.setDesc("Desktop Programming language");
        object6.setImgName(R.drawable.php);
        holder.add(object6);

        Model object7 = new Model();
        object7.setHeader("Python Programming");
        object7.setDesc("Desktop Programming language");
        object7.setImgName(R.drawable.python);
        holder.add(object7);

        Model object8 = new Model();
        object8.setHeader("Web Development");
        object8.setDesc("Desktop Programming language");
        object8.setImgName(R.drawable.web);
        holder.add(object8);




        return holder;

    }
}