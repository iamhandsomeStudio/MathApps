package com.example.mathapps;

import static android.Manifest.permission.MANAGE_EXTERNAL_STORAGE;
import static android.Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ExplanationActivity extends AppCompatActivity {
    Button nextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explanation);
        int writePermission = ActivityCompat.checkSelfPermission(this, WRITE_EXTERNAL_STORAGE);

        nextButton = findViewById(R.id.button);
        if(writePermission != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(
                    this, new String[]{WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE, MANAGE_EXTERNAL_STORAGE, MOUNT_UNMOUNT_FILESYSTEMS},
                    0);
        }else{
            nextButton.setOnClickListener(this::next_onClick);
        }

    }

    public void next_onClick(View v)
    {
        Intent nextIntnet = new Intent(ExplanationActivity.this, SelectActivity.class);
        startActivity(nextIntnet);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == 0){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
               nextButton.setOnClickListener(this::next_onClick);
            }else{
                Toast.makeText(this, "需要存取權限", Toast.LENGTH_SHORT).show();
            }
        }
    }
}