package com.example.mathapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private Context mContext;
    private List<List<String>>stages;
    private LinkedList<HashMap<String, String>> data;
    public ItemAdapter(Context context)
    {
        this.mContext = context;
        doData();
    }

    public ItemAdapter(List<List<String>> strings)
    {
        this.stages = strings;
        //doData();
    }

    public ItemAdapter(LinkedList<HashMap<String, String>> context)
    {
        //doData();
    }
    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        ViewHolder vh = new ViewHolder(itemView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {

        //holder.stage.setText(stages.get(0));
        //holder.name.setText(stages.get(0)[1]);

        //holder.score.setText(stages.get(2).toString());
        //holder.totalTime.setText(stages.get(3).toString());

        System.out.println(stages.get(0));
        //System.out.println(stages.get(1)[0]);
        //System.out.println(stages.get(2).toString());
        //System.out.println(stages.get(3).toString());
    }

    @Override
    public int getItemCount() {
        return stages.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView name, stage, score, totalTime;
        private  View itemView;
        public ViewHolder(@NonNull View v) {
            super(v);
            itemView = v;
            stage = itemView.findViewById(R.id.item_stage);
            name = itemView.findViewById(R.id.item_name);
            score = itemView.findViewById(R.id.item_score);
            totalTime = itemView.findViewById(R.id.item_totalTime);
        }
    }

    private void doData()
    {
        data = new LinkedList<>();
        for(int i=0;i<100;i++)
        {
            HashMap<String, String> row = new HashMap<>();
            int random = (int)(Math.random()*100);
            row.put("stage","Stage "+random);
            row.put("name","Name "+random);
            data.add(row);
        }

    }
}
