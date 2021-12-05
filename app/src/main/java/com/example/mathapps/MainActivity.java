package com.example.mathapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12;
    TextView que1,que2,que3,que4,que5,que6;
    int[] x = new int[12];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);/*Test*/

        que1 = (TextView)findViewById(R.id.quesOne);
        que2 = (TextView)findViewById(R.id.quesTwo);
        que3 = (TextView)findViewById(R.id.quesThree);
        que4 = (TextView)findViewById(R.id.quesFour);
        que5 = (TextView)findViewById(R.id.quesFive);
        que6 = (TextView)findViewById(R.id.quesSix);

        btn = (Button)findViewById(R.id.oneButton);
        btn2 = (Button)findViewById(R.id.twoButton);
        btn3 = (Button)findViewById(R.id.threeButton);
        btn4 = (Button)findViewById(R.id.fourButton);
        btn5 = (Button)findViewById(R.id.fiveButton);
        btn6 = (Button)findViewById(R.id.sixButton);
        btn7 = (Button)findViewById(R.id.sevenButton);
        btn8 = (Button)findViewById(R.id.eightButton);
        btn9 = (Button)findViewById(R.id.nineButton);
        btn10 = (Button)findViewById(R.id.tenButton);
        btn11 = (Button)findViewById(R.id.elevenButton);
        btn12 = (Button)findViewById(R.id.twelveButton);



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


        que1.setText(String.valueOf((int)(Math.random()*20+1)));
        que2.setText(String.valueOf((int)(Math.random()*20+1)));
        que3.setText(String.valueOf((int)(Math.random()*20+1)));
        que4.setText(String.valueOf((int)(Math.random()*20+1)));
        que5.setText(String.valueOf((int)(Math.random()*20+1)));
        que6.setText(String.valueOf((int)(Math.random()*20+1)));




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