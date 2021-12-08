package com.example.mathapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
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
    int sum2,count = 0,score = 0;
    String[] ans = new String[6];
    int level = 2;


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

        btnText();
        ansRandom();

        que1.setText(String.valueOf(y[0]));
        que2.setText(String.valueOf(y[1]));
        que3.setText(String.valueOf(y[2]));
        que4.setText(String.valueOf(y[3]));
        que5.setText(String.valueOf(y[4]));
        que6.setText(String.valueOf(y[5]));


    }

    public void ansRandom(){
        if(level == 1){
            for(int i=0;i<6;i++){
                y[i] = (int)(Math.random()*20+1);
                for(int j=0; j < i;j++){
                    if(y[j]==y[i]){
                        i--;
                        break;
                    }
                }
            }
        }
        if(level == 2){
            for(int i=0;i<6;i++){
                y[i] = (int)(Math.random()*80+1);
                for(int j=0; j < i;j++){
                    if(y[j]==y[i]){
                        i--;
                        break;
                    }
                }
            }
        }
        if(level == 3){
            for(int i=0;i<6;i++){
                y[i] = (int)(Math.random()*120+1);
                for(int j=0; j < i;j++){
                    if(y[j]==y[i]){
                        i--;
                        break;
                    }
                }
            }
        }
        if(level == 4){
            for(int i=0;i<6;i++){
                y[i] = (int)(Math.random()*160+1);
                for(int j=0; j < i;j++){
                    if(y[j]==y[i]){
                        i--;
                        break;
                    }
                }
            }
        }
        if(level == 5){
            for(int i=0;i<6;i++){
                y[i] = (int)(Math.random()*200+1);
                for(int j=0; j < i;j++){
                    if(y[j]==y[i]){
                        i--;
                        break;
                    }
                }
            }
        }

    }

    public void click(View v){
        countGet();
        x[0] = Integer.parseInt(String.valueOf(btn.getText()));
        btn.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
        sum(x[0]);
    }
    public void click_2(View v){
        countGet();
        x[1] = Integer.parseInt(String.valueOf(btn2.getText()));
        btn2.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
        sum(x[1]);
    }
    public void click_3(View v){
        countGet();
        x[2] = Integer.parseInt(String.valueOf(btn3.getText()));
        btn3.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
        sum(x[2]);
    }
    public void click_4(View v){
        countGet();
        x[3] = Integer.parseInt(String.valueOf(btn4.getText()));
        btn4.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
        sum(x[3]);
    }
    public void click_5(View v){
        countGet();
        x[4] = Integer.parseInt(String.valueOf(btn5.getText()));
        btn5.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
        sum(x[4]);
    }
    public void click_6(View v){
        countGet();
        x[5] = Integer.parseInt(String.valueOf(btn6.getText()));
        btn6.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
        sum(x[5]);
    }
    public void click_7(View v){
        countGet();
        x[6] = Integer.parseInt(String.valueOf(btn7.getText()));
        btn7.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
        sum(x[6]);
    }
    public void click_8(View v){
        countGet();
        x[7] = Integer.parseInt(String.valueOf(btn8.getText()));
        btn8.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
        sum(x[7]);
    }
    public void click_9(View v){
        countGet();
        x[8] = Integer.parseInt(String.valueOf(btn9.getText()));
        btn9.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
        sum(x[8]);
    }
    public void click_10(View v){
        countGet();
        x[9] = Integer.parseInt(String.valueOf(btn10.getText()));
        btn10.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
        sum(x[9]);
    }
    public void click_11(View v){
        countGet();
        x[10] = Integer.parseInt(String.valueOf(btn11.getText()));
        btn11.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
        sum(x[10]);
    }
    public void click_12(View v){
        countGet();
        x[11] = Integer.parseInt(String.valueOf(btn12.getText()));
        btn12.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
        sum(x[11]);
    }

    public void sum(int a){
        sum2 += a;
        System.out.println("總和:" + sum2 + "次數:" + count);
        if(y[0] == sum2 && count == 2){
            que1.setText("完成");
            score += 10;
            sum2 = 0;
            count = 0;
            btnColor();
        }else if(y[1] == sum2 && count == 2){
            que2.setText("完成");
            score += 10;
            sum2 = 0;
            count = 0;
            btnColor();
        }else if(y[2] == sum2 && count == 2){
            que3.setText("完成");
            score += 10;
            sum2 = 0;
            count = 0;
            btnColor();
        }else if(y[3] == sum2 && count == 2){
            que4.setText("完成");
            score += 10;
            sum2 = 0;
            count = 0;
            btnColor();
        }else if(y[4] == sum2 && count == 2){
            que5.setText("完成");
            score += 10;
            sum2 = 0;
            count = 0;
            btnColor();
        }else if(y[5] == sum2 && count == 2){
            que6.setText("完成");
            score += 10;
            sum2 = 0;
            count = 0;
            btnColor();
        }else if(count == 2){
            sum2 = 0;
            count = 0;
            btnColor();
        }
    }

    public void btnColor(){
        btn.setBackgroundTintList(ColorStateList.valueOf(Color.YELLOW));
        btn2.setBackgroundTintList(ColorStateList.valueOf(Color.YELLOW));
        btn3.setBackgroundTintList(ColorStateList.valueOf(Color.YELLOW));
        btn4.setBackgroundTintList(ColorStateList.valueOf(Color.YELLOW));
        btn5.setBackgroundTintList(ColorStateList.valueOf(Color.YELLOW));
        btn6.setBackgroundTintList(ColorStateList.valueOf(Color.YELLOW));
        btn7.setBackgroundTintList(ColorStateList.valueOf(Color.YELLOW));
        btn8.setBackgroundTintList(ColorStateList.valueOf(Color.YELLOW));
        btn9.setBackgroundTintList(ColorStateList.valueOf(Color.YELLOW));
        btn10.setBackgroundTintList(ColorStateList.valueOf(Color.YELLOW));
        btn11.setBackgroundTintList(ColorStateList.valueOf(Color.YELLOW));
        btn12.setBackgroundTintList(ColorStateList.valueOf(Color.YELLOW));
    }

    public void btnText(){
        if(level == 1){
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
        if(level == 2){
            btn.setText(String.valueOf((int)(Math.random()*40+1)));
            btn2.setText(String.valueOf((int)(Math.random()*40+1)));
            btn3.setText(String.valueOf((int)(Math.random()*40+1)));
            btn4.setText(String.valueOf((int)(Math.random()*40+1)));
            btn5.setText(String.valueOf((int)(Math.random()*40+1)));
            btn6.setText(String.valueOf((int)(Math.random()*40+1)));
            btn7.setText(String.valueOf((int)(Math.random()*40+1)));
            btn8.setText(String.valueOf((int)(Math.random()*40+1)));
            btn9.setText(String.valueOf((int)(Math.random()*40+1)));
            btn10.setText(String.valueOf((int)(Math.random()*40+1)));
            btn11.setText(String.valueOf((int)(Math.random()*40+1)));
            btn12.setText(String.valueOf((int)(Math.random()*40+1)));
        }
        if(level == 3){
            btn.setText(String.valueOf((int)(Math.random()*60+1)));
            btn2.setText(String.valueOf((int)(Math.random()*60+1)));
            btn3.setText(String.valueOf((int)(Math.random()*60+1)));
            btn4.setText(String.valueOf((int)(Math.random()*60+1)));
            btn5.setText(String.valueOf((int)(Math.random()*60+1)));
            btn6.setText(String.valueOf((int)(Math.random()*60+1)));
            btn7.setText(String.valueOf((int)(Math.random()*60+1)));
            btn8.setText(String.valueOf((int)(Math.random()*60+1)));
            btn9.setText(String.valueOf((int)(Math.random()*60+1)));
            btn10.setText(String.valueOf((int)(Math.random()*60+1)));
            btn11.setText(String.valueOf((int)(Math.random()*60+1)));
            btn12.setText(String.valueOf((int)(Math.random()*60+1)));
        }
        if(level == 4){
            btn.setText(String.valueOf((int)(Math.random()*80+1)));
            btn2.setText(String.valueOf((int)(Math.random()*80+1)));
            btn3.setText(String.valueOf((int)(Math.random()*80+1)));
            btn4.setText(String.valueOf((int)(Math.random()*80+1)));
            btn5.setText(String.valueOf((int)(Math.random()*80+1)));
            btn6.setText(String.valueOf((int)(Math.random()*80+1)));
            btn7.setText(String.valueOf((int)(Math.random()*80+1)));
            btn8.setText(String.valueOf((int)(Math.random()*80+1)));
            btn9.setText(String.valueOf((int)(Math.random()*80+1)));
            btn10.setText(String.valueOf((int)(Math.random()*80+1)));
            btn11.setText(String.valueOf((int)(Math.random()*80+1)));
            btn12.setText(String.valueOf((int)(Math.random()*80+1)));
        }
        if(level == 5){
            btn.setText(String.valueOf((int)(Math.random()*100+1)));
            btn2.setText(String.valueOf((int)(Math.random()*100+1)));
            btn3.setText(String.valueOf((int)(Math.random()*100+1)));
            btn4.setText(String.valueOf((int)(Math.random()*100+1)));
            btn5.setText(String.valueOf((int)(Math.random()*100+1)));
            btn6.setText(String.valueOf((int)(Math.random()*100+1)));
            btn7.setText(String.valueOf((int)(Math.random()*100+1)));
            btn8.setText(String.valueOf((int)(Math.random()*100+1)));
            btn9.setText(String.valueOf((int)(Math.random()*100+1)));
            btn10.setText(String.valueOf((int)(Math.random()*100+1)));
            btn11.setText(String.valueOf((int)(Math.random()*100+1)));
            btn12.setText(String.valueOf((int)(Math.random()*100+1)));
        }


    }

    public void countGet(){
        count++;
        if(count > 2){
            count = 0;
        }
        System.out.println(count);
    }
}