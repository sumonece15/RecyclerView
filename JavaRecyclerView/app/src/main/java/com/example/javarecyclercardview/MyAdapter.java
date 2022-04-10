package com.example.javarecyclercardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private static ClickListener clickListener;
    Context context;
    String [] title,desc;
    int [] flags;

    public MyAdapter(Context context, String[] title, String[] desc, int[] flags) {
        this.context = context;
        this.title = title;
        this.desc = desc;
        this.flags = flags;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.sample_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.flagsImageView.setImageResource(flags[position]);
        holder.titleTextView.setText(title[position]);
        holder.descTextView.setText(desc[position]);

    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        ImageView flagsImageView;
        TextView titleTextView, descTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            flagsImageView = itemView.findViewById(R.id.imageViewId);
            titleTextView = itemView.findViewById(R.id.titleTextViewId);
            descTextView = itemView.findViewById(R.id.descriptionTextViewId);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);


        }

        @Override
        public void onClick(View v) {

            clickListener.onItemClick(getAdapterPosition(), v);

        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onLongItemClick(getAdapterPosition(), v);
            return false;
        }
    }

    public interface ClickListener{

        void onItemClick(int position, View v);
        void onLongItemClick(int position, View v);
    }

    public void setOnItemClickListener(ClickListener clickListener)
    {
        MyAdapter.clickListener = clickListener;
    }
}
