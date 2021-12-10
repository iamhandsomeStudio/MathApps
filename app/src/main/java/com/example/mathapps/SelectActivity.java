package com.example.mathapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SelectActivity extends AppCompatActivity {

    Button start;
    Spinner dif_spinner,ex_spinner;
    ArrayAdapter<CharSequence> dif_adapter,ex_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        start = (Button)findViewById(R.id.start);
        dif_spinner = (Spinner)findViewById(R.id.difficultSpinner);
        ex_spinner = (Spinner)findViewById(R.id.expressionSpinner);

        dif_adapter = ArrayAdapter.createFromResource(this, R.array.difficult_array,android.R.layout.simple_spinner_item);
        ex_adapter = ArrayAdapter.createFromResource(this,R.array.expression_array, android.R.layout.simple_spinner_item);

        dif_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dif_spinner.setAdapter(dif_adapter);

        ex_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ex_spinner.setAdapter(ex_adapter);

    }

    public void start(View v){
        Intent intent = new Intent(SelectActivity.this,MainActivity.class);
        intent.putExtra("dif",dif_spinner.getSelectedItem().toString());
        intent.putExtra("ex",ex_spinner.getSelectedItem().toString());
        startActivity(intent);

    }
}