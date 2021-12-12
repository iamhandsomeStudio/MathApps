package com.example.mathapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NonNull

    private Context mContext;
    private ItemAdapter(Context context)
    {
        this.mContext = context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView name, stage, score, time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
