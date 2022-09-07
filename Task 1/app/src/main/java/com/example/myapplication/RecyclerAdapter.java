package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    private final String[] mListItems;
    private final String[] mListCalories;

    public RecyclerAdapter(Context context,String[] items, String[] calories) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
        mListItems = items;
        mListCalories = calories;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public final TextView mTextView1;
        public final TextView mTextView2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView1 = (TextView) itemView.findViewById(R.id.textView1);
            mTextView2 = (TextView) itemView.findViewById(R.id.textView2);
        }
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_layout,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        holder.mTextView1.setText(mListItems[position]);
        holder.mTextView2.setText(mListCalories[position]);
    }

    @Override
    public int getItemCount() {
        return mListItems.length;
    }
}
