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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Random;

public class SelectActivity extends AppCompatActivity {

    Button start;
    Spinner dif_spinner,ex_spinner;
    ArrayAdapter<CharSequence> dif_adapter,ex_adapter;
    EditText nameEditText;
    String[] names;
    Random nameNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        start = (Button)findViewById(R.id.start);
        dif_spinner = (Spinner)findViewById(R.id.difficultSpinner);
        ex_spinner = (Spinner)findViewById(R.id.expressionSpinner);

        dif_adapter = ArrayAdapter.createFromResource(this, R.array.difficult_array,R.layout.spinner_item);
        ex_adapter = ArrayAdapter.createFromResource(this,R.array.expression_array, R.layout.spinner_item);

        dif_adapter.setDropDownViewResource(R.layout.spinner_item);
        dif_spinner.setAdapter(dif_adapter);

        ex_adapter.setDropDownViewResource(R.layout.spinner_item);
        ex_spinner.setAdapter(ex_adapter);

        nameEditText = (EditText)findViewById(R.id.editTextTextPersonName);
        names = new String[]{
                "Aaron", "Abel", "Abraham", "Adam",
                "Adrian", "Aidan", "Alva", "Alex",
                "Alan", "Albert", "Ben", "Benjamin",
                "Bert", "Benson", "Bill", "Billy",
                "Blake", "Bob", "Bobby", "Brad",
                "Brandon", "Brant", "Brent", "Brian",
                "Caleb", "Cameron", "Carl", "Carlos",
                "Cary", "Caspar", "Cecil", "Charles",
                "Chris", "Christian", "Clark", "Cliff",
                "Daniel", "Denny", "Darwin", "David",
                "Eddie", "Edwin", "Eric", "Evan",
                "Fred","Frank", "Gino", "Jack",
                "Jackson", "Jacob", "James", "Jason",
                "Jimmy", "Joe", "John", "Lee", "Leo",
                "Max", "Michael", "Mickey", "Mike",
                "Sonia", "Sophia"};

        nameNumber = new Random();
        System.out.println(names[nameNumber.nextInt(62)]);
        nameEditText.setText(names[nameNumber.nextInt(62)]);
        System.out.println(dif_spinner.getSelectedItem().toString());
        System.out.println(ex_spinner.getSelectedItem().toString());
    }

    public void start(View v){

        Intent intent = new Intent(SelectActivity.this,MainActivity.class);
        intent.putExtra("name", nameEditText.getText().toString());
        intent.putExtra("dif",dif_spinner.getSelectedItem().toString());
        intent.putExtra("ex",ex_spinner.getSelectedItem().toString());
        startActivity(intent);
    }



}