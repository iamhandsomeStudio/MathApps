package com.example.mathapps;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private Context mContext;
    private List<String[]>stages;
    private List<List<String[]>> data ;
    //private LinkedList<HashMap<String, String>> data;

    public ItemAdapter(Context context)
    {
        this.mContext = context;
        doData();
    }

    public ItemAdapter(List<String[]> strings)
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {

        //holder.stage.setText(stages.get(0));
        //以成績作為陣列排序的方式
        stages.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] strings, String[] t1) {
                System.out.println("Return "+Integer.compare(Integer.parseInt(strings[1]),Integer.parseInt(t1[1])));
                return -Integer.compare(Integer.parseInt(strings[1]),Integer.parseInt(t1[1]));
            }
        });
        //排名計算
        int stage = 0; //排名
        int preScore = -1; //前一次的分數
        for(int i = 0;i < stages.size(); i++) {
            int score = Integer.parseInt(stages.get(i)[1]);
            if(Integer.compare(preScore, score) != 0){
                preScore = score;
                stage++;
            }
            holder.stage.setText(String.valueOf(stage));
            holder.name.setText(stages.get(position)[0]);
            //System.out.println(stages.get(position));
            holder.score.setText(stages.get(position)[1]);
            holder.totalTime.setText(stages.get(position)[2]);
        }
        System.out.println("length " +stages.size());
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
            //data.add(row);
        }

    }
}
