package com.example.mathapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.Sampler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12;
    TextView que1,que2,que3,que4,que5,que6;
    int[] x = new int[12];
    int[] y = new int[6];
    int sum2,count = 0;
    String[] ans = new String[6];


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



        y[0] = Integer.parseInt(String.valueOf(que1.getText()));
        y[1] = Integer.parseInt(String.valueOf(que2.getText()));
        y[2] = Integer.parseInt(String.valueOf(que3.getText()));
        y[3] = Integer.parseInt(String.valueOf(que4.getText()));
        y[4] = Integer.parseInt(String.valueOf(que5.getText()));
        y[5] = Integer.parseInt(String.valueOf(que6.getText()));


    }

    public void click(View v){
        x[0] = Integer.parseInt(String.valueOf(btn.getText()));
        sum(x[0]);

    }
    public void click_2(View v){
        x[1] = Integer.parseInt(String.valueOf(btn2.getText()));
        sum(x[1]);
    }
    public void click_3(View v){
        x[2] = Integer.parseInt(String.valueOf(btn3.getText()));
        sum(x[2]);
    }
    public void click_4(View v){
        x[3] = Integer.parseInt(String.valueOf(btn4.getText()));
        sum(x[3]);
    }
    public void click_5(View v){
        x[4] = Integer.parseInt(String.valueOf(btn5.getText()));
        sum(x[4]);
    }
    public void click_6(View v){
        x[5] = Integer.parseInt(String.valueOf(btn6.getText()));
        sum(x[5]);
    }
    public void click_7(View v){
        x[6] = Integer.parseInt(String.valueOf(btn7.getText()));
        sum(x[6]);
    }
    public void click_8(View v){
        x[7] = Integer.parseInt(String.valueOf(btn8.getText()));
        sum(x[7]);
    }
    public void click_9(View v){
        x[8] = Integer.parseInt(String.valueOf(btn9.getText()));
        sum(x[8]);
    }
    public void click_10(View v){
        x[9] = Integer.parseInt(String.valueOf(btn10.getText()));
        sum(x[9]);
    }
    public void click_11(View v){
        x[10] = Integer.parseInt(String.valueOf(btn11.getText()));
        sum(x[10]);
    }
    public void click_12(View v){
        x[11] = Integer.parseInt(String.valueOf(btn12.getText()));
        sum(x[11]);
    }

    public void sum(int a){
        count++;
        sum2 += a;
        System.out.println(y[0]);
        System.out.println(y[1]);
        System.out.println(y[2]);
        System.out.println(y[3]);
        System.out.println(y[4]);
        System.out.println(y[5]);
        if(y[0] == sum2 && count == 2){
            System.out.println(sum2);
            que1.setText("1:完成");
            sum2 = 0;
            count = 0;
        }else if(y[1] == sum2 && count == 2){
            System.out.println(sum2);
            que2.setText("2:完成");
            sum2 = 0;
            count = 0;
        }else if(y[2] == sum2 && count == 2){
            System.out.println(sum2);
            que3.setText("3:完成");
            sum2 = 0;
            count = 0;
        }else if(y[3] == sum2 && count == 2){
            System.out.println(sum2);
            que4.setText("4:完成");
            sum2 = 0;
            count = 0;
        }else if(y[4] == sum2 && count == 2){
            System.out.println(sum2);
            que5.setText("5:完成");
            sum2 = 0;
            count = 0;
        }else if(y[5] == sum2 && count == 2){
            System.out.println(sum2);
            que6.setText("6:完成");
            sum2 = 0;
            count = 0;
        }else if(count == 2){
            count = 0;
        }
    }
}