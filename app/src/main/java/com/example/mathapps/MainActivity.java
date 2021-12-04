package com.example.mathapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);/*Test*/
        btn = (Button)findViewById(R.id.button);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        btn4 = (Button)findViewById(R.id.button4);
        btn5 = (Button)findViewById(R.id.button5);
        btn6 = (Button)findViewById(R.id.button6);
        btn7 = (Button)findViewById(R.id.button7);
        btn8 = (Button)findViewById(R.id.button8);
        btn9 = (Button)findViewById(R.id.button9);
        btn10 = (Button)findViewById(R.id.button10);
        btn11 = (Button)findViewById(R.id.button11);
        btn12 = (Button)findViewById(R.id.button12);

        btn.setText(String.valueOf((int)(Math.random()*10+1)));
        btn2.setText(String.valueOf((int)(Math.random()*10+1)));
        btn3.setText(String.valueOf((int)(Math.random()*10+1)));
        btn4.setText(String.valueOf((int)(Math.random()*10+1)));
        btn5.setText(String.valueOf((int)(Math.random()*10+1)));
        btn6.setText(String.valueOf((int)(Math.random()*10+1)));
        btn7.setText(String.valueOf((int)(Math.random()*10+1)));
        btn8.setText(String.valueOf((int)(Math.random()*10+1)));
        btn9.setText(String.valueOf((int)(Math.random()*10+1)));
        btn10.setText(String.valueOf((int)(Math.random()*10+1)));
        btn11.setText(String.valueOf((int)(Math.random()*10+1)));
        btn12.setText(String.valueOf((int)(Math.random()*10+1)));
    }

    public void click(View v){
        btn.setText("");
    }
    public void click_2(View v){
        btn2.setText("");
    }
    public void click_3(View v){
        btn3.setText("");
    }
    public void click_4(View v){
        btn4.setText("");
    }
    public void click_5(View v){
        btn5.setText("");
    }
    public void click_6(View v){
        btn6.setText("");
    }
    public void click_7(View v){
        btn7.setText("");
    }
    public void click_8(View v){
        btn8.setText("");
    }
    public void click_9(View v){
        btn9.setText("");
    }
    public void click_10(View v){
        btn10.setText("");
    }
    public void click_11(View v){
        btn11.setText("");
    }
    public void click_12(View v){
        btn12.setText("");
    }

}