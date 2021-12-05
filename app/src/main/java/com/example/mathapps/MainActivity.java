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
    int[] y = new int[6];
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
        for(int i = 0; i < 6; i++){
            if(y[i] == x[0] + x[1]){
                if(i == 0){
                    que1.setText("完成!");
                    break;
                }
                if(i == 1){
                    que2.setText("完成!");
                    break;
                }
                if(i == 2){
                    que3.setText("完成!");
                    break;
                }
                if(i == 3){
                    que4.setText("完成!");
                    break;
                }
                if(i == 4){
                    que5.setText("完成!");
                    break;
                }
                if(i == 5){
                    que6.setText("完成!");
                    break;
                }
            }
            if(y[i] == x[0] + x[2]){
                if(i == 0){
                    que1.setText("完成!");
                    break;
                }
                if(i == 1){
                    que2.setText("完成!");
                    break;
                }
                if(i == 2){
                    que3.setText("完成!");
                    break;
                }
                if(i == 3){
                    que4.setText("完成!");
                    break;
                }
                if(i == 4){
                    que5.setText("完成!");
                    break;
                }
                if(i == 5){
                    que6.setText("完成!");
                    break;
                }
            }
            if(y[i] == x[0] + x[3]){
                if(i == 0){
                    que1.setText("完成!");
                    break;
                }
                if(i == 1){
                    que2.setText("完成!");
                    break;
                }
                if(i == 2){
                    que3.setText("完成!");
                    break;
                }
                if(i == 3){
                    que4.setText("完成!");
                    break;
                }
                if(i == 4){
                    que5.setText("完成!");
                    break;
                }
                if(i == 5){
                    que6.setText("完成!");
                    break;
                }
            }
            if(y[i] == x[0] + x[4]){
                if(i == 0){
                    que1.setText("完成!");
                    break;
                }
                if(i == 1){
                    que2.setText("完成!");
                    break;
                }
                if(i == 2){
                    que3.setText("完成!");
                    break;
                }
                if(i == 3){
                    que4.setText("完成!");
                    break;
                }
                if(i == 4){
                    que5.setText("完成!");
                    break;
                }
                if(i == 5){
                    que6.setText("完成!");
                    break;
                }
            }
            if(y[i] == x[0] + x[5]){
                if(i == 0){
                    que1.setText("完成!");
                    break;
                }
                if(i == 1){
                    que2.setText("完成!");
                    break;
                }
                if(i == 2){
                    que3.setText("完成!");
                    break;
                }
                if(i == 3){
                    que4.setText("完成!");
                    break;
                }
                if(i == 4){
                    que5.setText("完成!");
                    break;
                }
                if(i == 5){
                    que6.setText("完成!");
                    break;
                }
            }
            if(y[i] == x[0] + x[6]){
                if(i == 0){
                    que1.setText("完成!");
                    break;
                }
                if(i == 1){
                    que2.setText("完成!");
                    break;
                }
                if(i == 2){
                    que3.setText("完成!");
                    break;
                }
                if(i == 3){
                    que4.setText("完成!");
                    break;
                }
                if(i == 4){
                    que5.setText("完成!");
                    break;
                }
                if(i == 5){
                    que6.setText("完成!");
                    break;
                }
            }
            if(y[i] == x[0] + x[7]){
                if(i == 0){
                    que1.setText("完成!");
                    break;
                }
                if(i == 1){
                    que2.setText("完成!");
                    break;
                }
                if(i == 2){
                    que3.setText("完成!");
                    break;
                }
                if(i == 3){
                    que4.setText("完成!");
                    break;
                }
                if(i == 4){
                    que5.setText("完成!");
                    break;
                }
                if(i == 5){
                    que6.setText("完成!");
                    break;
                }
            }
            if(y[i] == x[0] + x[8]){
                if(i == 0){
                    que1.setText("完成!");
                    break;
                }
                if(i == 1){
                    que2.setText("完成!");
                    break;
                }
                if(i == 2){
                    que3.setText("完成!");
                    break;
                }
                if(i == 3){
                    que4.setText("完成!");
                    break;
                }
                if(i == 4){
                    que5.setText("完成!");
                    break;
                }
                if(i == 5){
                    que6.setText("完成!");
                    break;
                }
            }
            if(y[i] == x[0] + x[9]){
                if(i == 0){
                    que1.setText("完成!");
                    break;
                }
                if(i == 1){
                    que2.setText("完成!");
                    break;
                }
                if(i == 2){
                    que3.setText("完成!");
                    break;
                }
                if(i == 3){
                    que4.setText("完成!");
                    break;
                }
                if(i == 4){
                    que5.setText("完成!");
                    break;
                }
                if(i == 5){
                    que6.setText("完成!");
                    break;
                }
            }
            if(y[i] == x[0] + x[10]){
                if(i == 0){
                    que1.setText("完成!");
                    break;
                }
                if(i == 1){
                    que2.setText("完成!");
                    break;
                }
                if(i == 2){
                    que3.setText("完成!");
                    break;
                }
                if(i == 3){
                    que4.setText("完成!");
                    break;
                }
                if(i == 4){
                    que5.setText("完成!");
                    break;
                }
                if(i == 5){
                    que6.setText("完成!");
                    break;
                }
            }
            if(y[i] == x[0] + x[11]){
                if(i == 0){
                    que1.setText("完成!");
                    break;
                }
                if(i == 1){
                    que2.setText("完成!");
                    break;
                }
                if(i == 2){
                    que3.setText("完成!");
                    break;
                }
                if(i == 3){
                    que4.setText("完成!");
                    break;
                }
                if(i == 4){
                    que5.setText("完成!");
                    break;
                }
                if(i == 5){
                    que6.setText("完成!");
                    break;
                }
            }
        }
    }
    public void click_2(View v){
        x[1] = Integer.parseInt(String.valueOf(btn2.getText()));
    }
    public void click_3(View v){
        x[2] = Integer.parseInt(String.valueOf(btn3.getText()));
    }
    public void click_4(View v){
        x[3] = Integer.parseInt(String.valueOf(btn4.getText()));
    }
    public void click_5(View v){
        x[4] = Integer.parseInt(String.valueOf(btn5.getText()));
    }
    public void click_6(View v){
        x[5] = Integer.parseInt(String.valueOf(btn6.getText()));
    }
    public void click_7(View v){
        x[6] = Integer.parseInt(String.valueOf(btn7.getText()));
    }
    public void click_8(View v){
        x[7] = Integer.parseInt(String.valueOf(btn8.getText()));
    }
    public void click_9(View v){
        x[8] = Integer.parseInt(String.valueOf(btn9.getText()));
    }
    public void click_10(View v){
        x[9] = Integer.parseInt(String.valueOf(btn10.getText()));
    }
    public void click_11(View v){
        x[10] = Integer.parseInt(String.valueOf(btn11.getText()));
    }
    public void click_12(View v){
        x[11] = Integer.parseInt(String.valueOf(btn12.getText()));
    }
}