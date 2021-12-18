package com.example.mathapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.DialogTitle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class RankActivity extends AppCompatActivity {

    private RecyclerView rankReccycleView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ItemAdapter itemAdapter;
    List<String[]> csvList = new ArrayList<String[]>();
    private String fileName = "MathApp.csv";
    private File completeExternalPath = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);


        rankReccycleView = findViewById(R.id.recyclerView);
        rankReccycleView.setHasFixedSize(true);

        //use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        rankReccycleView.setLayoutManager(mLayoutManager);


        //specify an adapter (see also next example)
        /*itemAdapter = new ItemAdapter(this);
        rankReccycleView.setAdapter(itemAdapter);*/

        //csvList = new LinkedList<>();
        readCsv();
        itemAdapter = new ItemAdapter(csvList);
        rankReccycleView.setAdapter(itemAdapter);
    }

    public void readCsv()
    {
        FileInputStream fos = null;

        BufferedInputStream buffered = null;
        completeExternalPath = new File(String.valueOf(getExternalFilesDir(fileName)));

        try{
            fos = new FileInputStream(completeExternalPath);
            InputStreamReader inputStreamReader = new InputStreamReader(fos);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String[] str ;
            String text = null;

            while ((text = bufferedReader.readLine()) != null) {
                str = text.split(",");
                csvList.add(str);
            }
            fos.close();


            /*(int i=0;i<csvList.size();i++){
                for (int j=0;j < csvList.get(i).length;j++){

                }
            }*/
            //System.out.println(csvList.get(0).length);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}