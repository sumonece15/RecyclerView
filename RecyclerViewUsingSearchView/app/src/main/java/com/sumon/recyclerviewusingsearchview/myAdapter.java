package com.sumon.recyclerviewusingsearchview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myViewHolder> implements Filterable {

    ArrayList<Model> data;
    ArrayList<Model> backup;
    Context context;


    public myAdapter(ArrayList<Model> data, Context context) {
        this.data = data;
        this.context = context;
        backup = new ArrayList<>(data);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.single_row, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {


        final Model temp = data.get(position);

        holder.text1.setText(data.get(position).getHeader());
        holder.text2.setText(data.get(position).getDesc());
        holder.img.setImageResource(data.get(position).getImgName());

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("imgName", temp.getImgName());
                intent.putExtra("header", temp.getHeader());
                intent.putExtra("desc", temp.getDesc());
                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }

    @Override
    public Filter getFilter() {

        return filter;
    }

    Filter filter = new Filter() {
        @Override

        //background thread
        protected FilterResults performFiltering(CharSequence keyword) {

            ArrayList<Model> filtereddata = new ArrayList<>();

            if (keyword.toString().isEmpty())
                filtereddata.addAll(backup);

            else
                {
                    for (Model obj : backup)
                    {
                        if (obj.getHeader().toString().toLowerCase().contains(keyword.toString().toLowerCase()))
                            filtereddata.add(obj);
                    }
                }

            FilterResults results = new FilterResults();
            results.values = filtereddata;
            return results;

        }

        @Override
        //main UI thread
        protected void publishResults(CharSequence charSequence, FilterResults results) {

            data.clear();
            data.addAll((ArrayList<Model>)results.values);
            notifyDataSetChanged();


        }
    };
}
