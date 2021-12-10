package com.example.mathapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new Handler().postDelayed(() -> {
            Intent startLandingPageActivity = new Intent(WelcomeActivity.this, ExplanationActivity.class);
            startActivity(startLandingPageActivity);
            },5000);

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}