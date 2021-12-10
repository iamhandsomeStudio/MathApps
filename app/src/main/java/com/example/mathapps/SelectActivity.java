package com.example.mathapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectActivity extends AppCompatActivity {

    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        start = (Button)findViewById(R.id.start);
    }

    public void start(View v){
        Intent intent = new Intent(SelectActivity.this,MainActivity.class);
        startActivity(intent);

    }
}