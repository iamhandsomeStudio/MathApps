package com.example.mathapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExplanationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explanation);
        Button nextButton = findViewById(R.id.button);
        nextButton.setOnClickListener(this::next_onClick);

    }

    public void next_onClick(View v)
    {
        Intent nextIntnet = new Intent(ExplanationActivity.this, SelectActivity.class);
        startActivity(nextIntnet);
    }
}