package com.sumon.recyclerviewwithcardview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myViewHolder> {

    ArrayList<Model> data;

    public myAdapter(ArrayList<Model> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_row, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.text1.setText(data.get(position).getHeader());
        holder.text2.setText(data.get(position).getDesc());
        holder.img.setImageResource(data.get(position).getImgName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
