package com.example.mathapps;

import static java.lang.String.*;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.renderscript.Sampler;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btn,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,next_stage;
    TextView que1,que2,que3,que4,que5,que6,time, stage, scoreText;
    int[] x = new int[6];
    int[] y = new int[6];
    int[] z = new int[6];
    int sum2,sub,count = 0,score = 0,page = 0,min = 0,sec = 0,dif = 0;
    Bundle extra;  //頁面傳值
    CountDownTimer cdt;
    ActionBar mainActionBar;
    Intent rankInt;
    File file;
    MediaPlayer mp;
    private Switch musicSwitch;
    private AssetManager assetManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);/*Test*/

        extra = getIntent().getExtras();
        mp = new MediaPlayer();


        que1 = (TextView)findViewById(R.id.quesOne);
        que2 = (TextView)findViewById(R.id.quesTwo);
        que3 = (TextView)findViewById(R.id.quesThree);
        que4 = (TextView)findViewById(R.id.quesFour);
        que5 = (TextView)findViewById(R.id.quesFive);
        que6 = (TextView)findViewById(R.id.quesSix);
        time = (TextView)findViewById(R.id.time);
        stage = (TextView)findViewById(R.id.stage);
        scoreText = (TextView)findViewById(R.id.score);

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

        next_stage = (Button)findViewById(R.id.next_stage);

        ansRandom();
        btnText();
        btn_SW();

        que1.setText(valueOf(y[0]));
        que2.setText(valueOf(y[1]));
        que3.setText(valueOf(y[2]));
        que4.setText(valueOf(y[3]));
        que5.setText(valueOf(y[4]));
        que6.setText(valueOf(y[5]));

        file = new File(getExternalFilesDir(null),"MathApp.csv");

        musicSwitch = findViewById(R.id.switchMusic);
        musicSwitch.setOnCheckedChangeListener(this::onCheckedChanged);
        musicSwitch.performClick();
        /*if(mp != null){
            //mp.reset();
            try {
                AssetFileDescriptor afd = getResources().openRawResourceFd(R.raw.robot);
                mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
                afd.close();
                mp.prepare();
            } catch (Exception e) {
                e.printStackTrace();
            }
            mp.start();
        }else if(!mp.isPlaying()){
            mp.start();
        }*/
        /*if(!file.exists()){
            try{
                BufferedWriter w_title = new BufferedWriter(new FileWriter(file,true));
                w_title.write("名次," + "名字," + "分數," + "時間,");
                w_title.newLine();
                w_title.flush();
                w_title.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/


        cdt = new CountDownTimer(300000000,1000) {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long millisUntilFinished) {
                sec++;
                if(sec < 60){
                    if(min < 10){
                        if(sec < 10){
                            time.setText("0" + valueOf(min) + ":0" + valueOf(sec));
                        }else{
                            time.setText("0" + valueOf(min) + ":" + valueOf(sec));
                        }
                    }else{
                        if(sec < 10){
                            time.setText(valueOf(min) + ":0" + valueOf(sec));
                        }else{
                            time.setText(valueOf(min) + ":" + valueOf(sec));
                        }

                    }
                }
                if(sec == 60){
                    sec = 0;
                    min++;
                    if(min < 10){
                        time.setText("0" + valueOf(min) + ":0" + valueOf(sec));
                    }else{
                        time.setText(valueOf(min) + ":0" + valueOf(sec));
                    }
                }

            }

            @Override
            public void onFinish() {
                System.out.println("遊戲結束!!");
            }

        };

        mainActionBar = getSupportActionBar();

    }

    public void ansRandom(){
        if(extra.getString("dif").equals("一")){
            if(extra.getString("ex").equals("加法")){
                for(int i=0;i<6;i++){
                    y[i] = (int)(Math.random()*20+1);
                    if(y[i] < 2 ){
                        y[i]++;
                    }
                    for(int j=0; j < i;j++){
                        if(y[j]==y[i]){
                            i--;
                            break;
                        }
                    }
                }
            }else if(extra.getString("ex").equals("減法")){
                for(int i=0;i<6;i++){
                    y[i] = (int)(Math.random()*9+1);
                    if(y[i] < 2 ){
                        y[i]++;
                    }
                    for(int j=0; j < i;j++){
                        if(y[j]==y[i]){
                            i--;
                            break;
                        }
                    }
                }
            }

        }
        if(extra.getString("dif").equals("二")){
            if(extra.getString("ex").equals("加法")){
                for(int i=0;i<6;i++){
                    y[i] = (int)(Math.random()*40+1);
                    if(y[i] < 2 ){
                        y[i]++;
                    }
                    for(int j=0; j < i;j++){
                        if(y[j]==y[i] || y[i] <= 1){
                            i--;
                            break;
                        }
                    }
                }
            }else if(extra.getString("ex").equals("減法")){
                for(int i=0;i<6;i++){
                    y[i] = (int)(Math.random()*39+1);
                    if(y[i] < 2 ){
                        y[i]++;
                    }
                    for(int j=0; j < i;j++){
                        if(y[j]==y[i] || y[i] <= 1){
                            i--;
                            break;
                        }
                    }
                }
            }

        }
        if(extra.getString("dif").equals("三")){
            if(extra.getString("ex").equals("加法")){
                for(int i=0;i<6;i++){
                    y[i] = (int)(Math.random()*60+1);
                    if(y[i] < 2 ){
                        y[i]++;
                    }
                    for(int j=0; j < i;j++){
                        if(y[j]==y[i] || y[i] <= 1){
                            i--;
                            break;
                        }
                    }
                }
            }else if(extra.getString("ex").equals("減法")){
                for(int i=0;i<6;i++){
                    y[i] = (int)(Math.random()*59+1);
                    if(y[i] < 2 ){
                        y[i]++;
                    }

                    for(int j=0; j < i;j++){
                        if(y[j]==y[i] || y[i] <= 1){
                            i--;
                            break;
                        }
                    }
                }
            }

        }
        if(extra.getString("dif").equals("四")){
            if(extra.getString("ex").equals("加法")){
                for(int i=0;i<6;i++){
                    y[i] = (int)(Math.random()*80+1);
                    if(y[i] < 2 ){
                        y[i]++;
                    }
                    for(int j=0; j < i;j++){
                        if(y[j]==y[i] || y[i] <= 1){
                            i--;
                            break;
                        }
                    }
                }
            }else if(extra.getString("ex").equals("減法")){
                for(int i=0;i<6;i++){
                    y[i] = (int)(Math.random()*79+1);
                    if(y[i] < 2 ){
                        y[i]++;
                    }
                    for(int j=0; j < i;j++){
                        if(y[j]==y[i] || y[i] <= 1){
                            i--;
                            break;
                        }
                    }
                }
            }

        }
        if(extra.getString("dif").equals("五")){
            if(extra.getString("ex").equals("加法")){
                for(int i=0;i<6;i++){
                    y[i] = (int)(Math.random()*100+1);
                    if(y[i] < 2 ){
                        y[i]++;
                    }
                    for(int j=0; j < i;j++){
                        if(y[j]==y[i] || y[i] <= 1){
                            i--;
                            break;
                        }
                    }
                }
            }else if(extra.getString("ex").equals("減法")){
                for(int i=0;i<6;i++){
                    y[i] = (int)(Math.random()*99+1);
                    if(y[i] < 2 ){
                        y[i]++;
                    }
                    for(int j=0; j < i;j++){
                        if(y[j]==y[i] || y[i] <= 1){
                            i--;
                            break;
                        }
                    }
                }
            }

        }

    }

    public void click(View v){
        countGet();
        //x[0] = Integer.parseInt(valueOf(btn.getText()));
        btn.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
        btn.setEnabled(false);
        sum(x[0]);

    }
    public void click_2(View v){
        countGet();
        //x[1] = Integer.parseInt(valueOf(btn2.getText()));
        btn2.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
        btn2.setEnabled(false);
        sum(x[1]);
    }
    public void click_3(View v){
        countGet();
        //x[2] = Integer.parseInt(valueOf(btn3.getText()));
        btn3.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
        btn3.setEnabled(false);
        sum(x[2]);
    }
    public void click_4(View v){
        countGet();
        //x[3] = Integer.parseInt(valueOf(btn4.getText()));
        btn4.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
        btn4.setEnabled(false);
        sum(x[3]);
    }
    public void click_5(View v){
        countGet();
        //x[4] = Integer.parseInt(valueOf(btn5.getText()));
        btn5.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
        btn5.setEnabled(false);
        sum(x[4]);
    }
    public void click_6(View v){
        countGet();
        //x[5] = Integer.parseInt(valueOf(btn6.getText()));
        btn6.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
        btn6.setEnabled(false);
        sum(x[5]);
    }
    public void click_7(View v){
        countGet();
        //x[6] = Integer.parseInt(valueOf(btn7.getText()));
        btn7.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
        btn7.setEnabled(false);
        sum(z[0]);
    }
    public void click_8(View v){
        countGet();
        //x[7] = Integer.parseInt(valueOf(btn8.getText()));
        btn8.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
        btn8.setEnabled(false);
        sum(z[1]);
    }
    public void click_9(View v){
        countGet();
        //x[8] = Integer.parseInt(valueOf(btn9.getText()));
        btn9.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
        btn9.setEnabled(false);
        sum(z[2]);
    }
    public void click_10(View v){
        countGet();
        //x[9] = Integer.parseInt(valueOf(btn10.getText()));
        btn10.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
        btn10.setEnabled(false);
        sum(z[3]);
    }
    public void click_11(View v){
        countGet();
        //x[10] = Integer.parseInt(valueOf(btn11.getText()));
        btn11.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
        btn11.setEnabled(false);
        sum(z[4]);
    }
    public void click_12(View v){
        countGet();
        //x[11] = Integer.parseInt(valueOf(btn12.getText()));
        btn12.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
        btn12.setEnabled(false);
        sum(z[5]);
    }
    public void next(View v){    //下一關
        if(page == 0){
            next_stage.setText("下一關");
            page++;
            stage.setText(format("第%d關"+"\n"+"  答案", page));
            //mainActionBar.setTitle("第"+String.valueOf(page)+"關");
            btn_SW();
            cdt.start();
        }else{
            if(page < 10){
                ansRandom();
                btnText();
                que1.setText(valueOf(y[0]));
                que2.setText(valueOf(y[1]));
                que3.setText(valueOf(y[2]));
                que4.setText(valueOf(y[3]));
                que5.setText(valueOf(y[4]));
                que6.setText(valueOf(y[5]));
                page++;
                stage.setText(format("第%d關"+"\n"+" 答案", page));
                if(page == 10){
                    next_stage.setText("結束");
                }
            }else{
                page = 0;
                cdt.cancel();
                try{
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
                    writer.write(extra.getString("name") + "," + scoreText.getText() + "," + time.getText() + "," + dif + ",");
                    writer.newLine();
                    writer.flush();
                    writer.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                rankInt = new Intent(MainActivity.this,RankActivity.class);
                rankInt.putExtra("dif",dif);
                startActivity(rankInt);

                next_stage.setEnabled(false);
            }

        }

    }


    public void sum(int a){
        if(extra.getString("ex").equals("加法")){
            sum2 += a;
            if(y[0] == sum2 && count == 2 && !que1.getText().equals("完成")){
                que1.setText("完成");
                score += 10;
                sum2 = 0;
                count = 0;
                btnColor();
                btn_SW();
            }else if(y[1] == sum2 && count == 2 && !que2.getText().equals("完成")){
                que2.setText("完成");
                score += 10;
                sum2 = 0;
                count = 0;
                btnColor();
                btn_SW();
            }else if(y[2] == sum2 && count == 2 && !que3.getText().equals("完成")){
                que3.setText("完成");
                score += 10;
                sum2 = 0;
                count = 0;
                btnColor();
                btn_SW();
            }else if(y[3] == sum2 && count == 2 && !que4.getText().equals("完成")){
                que4.setText("完成");
                score += 10;
                sum2 = 0;
                count = 0;
                btnColor();
                btn_SW();
            }else if(y[4] == sum2 && count == 2 && !que5.getText().equals("完成")){
                que5.setText("完成");
                score += 10;
                sum2 = 0;
                count = 0;
                btnColor();
                btn_SW();
            }else if(y[5] == sum2 && count == 2 && !que6.getText().equals("完成")){
                que6.setText("完成");
                score += 10;
                sum2 = 0;
                count = 0;
                btnColor();
                btn_SW();
            }else if(count == 2){
                sum2 = 0;
                count = 0;
                btnColor();
                btn_SW();
            }
            scoreText.setText(String.valueOf(score));
        }else if(extra.getString("ex").equals("減法")){
            sub = Math.abs(sub) - a;
            if(y[0] == Math.abs(sub) && count == 2 && !que1.getText().equals("完成")){
                que1.setText("完成");
                score += 10;
                sub = 0;
                count = 0;
                btnColor();
                btn_SW();
            }else if(y[1] == Math.abs(sub) && count == 2 && !que2.getText().equals("完成")){
                que2.setText("完成");
                score += 10;
                sub = 0;
                count = 0;
                btnColor();
                btn_SW();
            }else if(y[2] == Math.abs(sub) && count == 2 && !que3.getText().equals("完成")){
                que3.setText("完成");
                score += 10;
                sub = 0;
                count = 0;
                btnColor();
                btn_SW();
            }else if(y[3] == Math.abs(sub) && count == 2 && !que4.getText().equals("完成")){
                que4.setText("完成");
                score += 10;
                sub = 0;
                count = 0;
                btnColor();
                btn_SW();
            }else if(y[4] == Math.abs(sub) && count == 2 && !que5.getText().equals("完成")){
                que5.setText("完成");
                score += 10;
                sub = 0;
                count = 0;
                btnColor();
                btn_SW();
            }else if(y[5] == Math.abs(sub) && count == 2 && !que6.getText().equals("完成")){
                que6.setText("完成");
                score += 10;
                sub = 0;
                count = 0;
                btnColor();
                btn_SW();
            }else if(count == 2){
                sub = 0;
                count = 0;
                btnColor();
                btn_SW();
            }
            scoreText.setText(String.valueOf(score));
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
        if(extra.getString("ex").equals("加法")){
            if(extra.getString("dif").equals("一")){
                for(int i = 0; i < y.length; i++){
                    x[i] = y[i] - (int) (Math.random() * 10 + 1);

                    if (x[i] <= 0 || x[i] > 10) {
                        i--;
                    }else{
                        z[i] = y[i] - x[i];
                        if(z[i] > 10){
                            i--;
                        }
                    }
                }
                dif = 1;
                btn.setText(valueOf(x[0]));
                btn2.setText(valueOf(x[1]));
                btn3.setText(valueOf(x[2]));
                btn4.setText(valueOf(x[3]));
                btn5.setText(valueOf(x[4]));
                btn6.setText(valueOf(x[5]));
                btn7.setText(valueOf(z[0]));
                btn8.setText(valueOf(z[1]));
                btn9.setText(valueOf(z[2]));
                btn10.setText(valueOf(z[3]));
                btn11.setText(valueOf(z[4]));
                btn12.setText(valueOf(z[5]));
            }
            if(extra.getString("dif").equals("二")){
                for(int i = 0; i < y.length; i++){
                    x[i] = y[i] - (int) (Math.random() * 20 + 1);
                    if (x[i] <= 0) {
                        i--;
                    }else{
                        z[i] = y[i] - x[i];
                    }
                }
                dif = 2;
                btn.setText(valueOf(x[0]));
                btn2.setText(valueOf(x[1]));
                btn3.setText(valueOf(x[2]));
                btn4.setText(valueOf(x[3]));
                btn5.setText(valueOf(x[4]));
                btn6.setText(valueOf(x[5]));
                btn7.setText(valueOf(z[0]));
                btn8.setText(valueOf(z[1]));
                btn9.setText(valueOf(z[2]));
                btn10.setText(valueOf(z[3]));
                btn11.setText(valueOf(z[4]));
                btn12.setText(valueOf(z[5]));
            }
            if(extra.getString("dif").equals("三")){
                for(int i = 0; i < y.length; i++){
                    x[i] = y[i] - (int) (Math.random() * 30 + 1);
                    if (x[i] <= 0) {
                        i--;
                    }else{
                        z[i] = y[i] - x[i];
                    }
                }
                dif = 3;
                btn.setText(valueOf(x[0]));
                btn2.setText(valueOf(x[1]));
                btn3.setText(valueOf(x[2]));
                btn4.setText(valueOf(x[3]));
                btn5.setText(valueOf(x[4]));
                btn6.setText(valueOf(x[5]));
                btn7.setText(valueOf(z[0]));
                btn8.setText(valueOf(z[1]));
                btn9.setText(valueOf(z[2]));
                btn10.setText(valueOf(z[3]));
                btn11.setText(valueOf(z[4]));
                btn12.setText(valueOf(z[5]));
            }
            if(extra.getString("dif").equals("四")){
                for(int i = 0; i < y.length; i++){
                    x[i] = y[i] - (int) (Math.random() * 40 + 1);
                    if (x[i] <= 0) {
                        i--;
                    }else{
                        z[i] = y[i] - x[i];
                    }
                }
                dif = 4;
                btn.setText(valueOf(x[0]));
                btn2.setText(valueOf(x[1]));
                btn3.setText(valueOf(x[2]));
                btn4.setText(valueOf(x[3]));
                btn5.setText(valueOf(x[4]));
                btn6.setText(valueOf(x[5]));
                btn7.setText(valueOf(z[0]));
                btn8.setText(valueOf(z[1]));
                btn9.setText(valueOf(z[2]));
                btn10.setText(valueOf(z[3]));
                btn11.setText(valueOf(z[4]));
                btn12.setText(valueOf(z[5]));
            }
            if(extra.getString("dif").equals("五")){
                for(int i = 0; i < y.length; i++){
                    x[i] = y[i] - (int) (Math.random() * 50 + 1);
                    if (x[i] <= 0) {
                        i--;
                    }else{
                        z[i] = y[i] - x[i];
                    }
                }
                dif = 5;
                btn.setText(valueOf(x[0]));
                btn2.setText(valueOf(x[1]));
                btn3.setText(valueOf(x[2]));
                btn4.setText(valueOf(x[3]));
                btn5.setText(valueOf(x[4]));
                btn6.setText(valueOf(x[5]));
                btn7.setText(valueOf(z[0]));
                btn8.setText(valueOf(z[1]));
                btn9.setText(valueOf(z[2]));
                btn10.setText(valueOf(z[3]));
                btn11.setText(valueOf(z[4]));
                btn12.setText(valueOf(z[5]));
            }
        }else if(extra.getString("ex").equals("減法")){
            if(extra.getString("dif").equals("一")){
                for(int i = 0; i < y.length; i++){
                    x[i] = (int) (Math.random() * 10 + 1) - y[i];
                    if (x[i] <= 0) {
                        i--;
                    }else{
                        z[i] = Math.abs(x[i]) + y[i];
                    }
                }
                dif = 1;
                btn.setText(valueOf(Math.abs(x[0])));
                btn2.setText(valueOf(Math.abs(x[1])));
                btn3.setText(valueOf(Math.abs(x[2])));
                btn4.setText(valueOf(Math.abs(x[3])));
                btn5.setText(valueOf(Math.abs(x[4])));
                btn6.setText(valueOf(Math.abs(x[5])));
                btn7.setText(valueOf(z[0]));
                btn8.setText(valueOf(z[1]));
                btn9.setText(valueOf(z[2]));
                btn10.setText(valueOf(z[3]));
                btn11.setText(valueOf(z[4]));
                btn12.setText(valueOf(z[5]));
            }
            if(extra.getString("dif").equals("二")){
                for(int i = 0; i < y.length; i++){
                    x[i] = (int) (Math.random() * 40 + 1) - y[i];
                    if (x[i] <= 0) {
                        i--;
                    }else{
                        z[i] = x[i] + y[i];
                    }
                }
                dif = 2;
                btn.setText(valueOf(x[0]));
                btn2.setText(valueOf(x[1]));
                btn3.setText(valueOf(x[2]));
                btn4.setText(valueOf(x[3]));
                btn5.setText(valueOf(x[4]));
                btn6.setText(valueOf(x[5]));
                btn7.setText(valueOf(z[0]));
                btn8.setText(valueOf(z[1]));
                btn9.setText(valueOf(z[2]));
                btn10.setText(valueOf(z[3]));
                btn11.setText(valueOf(z[4]));
                btn12.setText(valueOf(z[5]));
            }
            if(extra.getString("dif").equals("三")){
                for(int i = 0; i < y.length; i++){
                    x[i] = (int) (Math.random() * 60 + 1) - y[i];
                    if (x[i] <= 0) {
                        i--;
                    }else{
                        z[i] = x[i] + y[i];
                    }
                }
                dif = 3;
                btn.setText(valueOf(x[0]));
                btn2.setText(valueOf(x[1]));
                btn3.setText(valueOf(x[2]));
                btn4.setText(valueOf(x[3]));
                btn5.setText(valueOf(x[4]));
                btn6.setText(valueOf(x[5]));
                btn7.setText(valueOf(z[0]));
                btn8.setText(valueOf(z[1]));
                btn9.setText(valueOf(z[2]));
                btn10.setText(valueOf(z[3]));
                btn11.setText(valueOf(z[4]));
                btn12.setText(valueOf(z[5]));
            }
            if(extra.getString("dif").equals("四")){
                for(int i = 0; i < y.length; i++){
                    x[i] = (int) (Math.random() * 80 + 1) - y[i];
                    if (x[i] <= 0) {
                        i--;
                    }else{
                        z[i] = x[i] + y[i];
                    }
                }
                dif = 4;
                btn.setText(valueOf(x[0]));
                btn2.setText(valueOf(x[1]));
                btn3.setText(valueOf(x[2]));
                btn4.setText(valueOf(x[3]));
                btn5.setText(valueOf(x[4]));
                btn6.setText(valueOf(x[5]));
                btn7.setText(valueOf(z[0]));
                btn8.setText(valueOf(z[1]));
                btn9.setText(valueOf(z[2]));
                btn10.setText(valueOf(z[3]));
                btn11.setText(valueOf(z[4]));
                btn12.setText(valueOf(z[5]));
            }
            if(extra.getString("dif").equals("五")){
                for(int i = 0; i < y.length; i++){
                    x[i] = (int) (Math.random() * 100 + 1) - y[i];
                    if (x[i] <= 0) {
                        i--;
                    }else{
                        z[i] = x[i] + y[i];
                    }
                }
                dif = 5;
                btn.setText(valueOf(x[0]));
                btn2.setText(valueOf(x[1]));
                btn3.setText(valueOf(x[2]));
                btn4.setText(valueOf(x[3]));
                btn5.setText(valueOf(x[4]));
                btn6.setText(valueOf(x[5]));
                btn7.setText(valueOf(z[0]));
                btn8.setText(valueOf(z[1]));
                btn9.setText(valueOf(z[2]));
                btn10.setText(valueOf(z[3]));
                btn11.setText(valueOf(z[4]));
                btn12.setText(valueOf(z[5]));
            }
        }



    }

    public void btn_SW(){
        if(next_stage.getText().equals("開始")){
            btn.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
            btn10.setEnabled(false);
            btn11.setEnabled(false);
            btn12.setEnabled(false);
        }else{
            btn.setEnabled(true);
            btn2.setEnabled(true);
            btn3.setEnabled(true);
            btn4.setEnabled(true);
            btn5.setEnabled(true);
            btn6.setEnabled(true);
            btn7.setEnabled(true);
            btn8.setEnabled(true);
            btn9.setEnabled(true);
            btn10.setEnabled(true);
            btn11.setEnabled(true);
            btn12.setEnabled(true);

        }

    }

    public void countGet(){
        count++;
        if(count > 2){
            count = 0;
        }
    }
    public void DialogSet(){
        final AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        View view = getLayoutInflater().inflate(R.layout.activity_rank,null);
        dialog.setView(view);

        final  AlertDialog dialog1 = dialog.create();
        dialog1.show();
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean b){/*這一行*/
        String state = null;
        if(!b){
            if(mp != null && mp.isPlaying()){
                try {
                    mp.pause();
                    //mp.release();
                    state = "關閉音樂";
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }else{
            if(mp != null){
                //mp.reset();
                try {
                    AssetFileDescriptor afd = getResources().openRawResourceFd(R.raw.robot);
                    mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
                    afd.close();
                    mp.prepare();
                    state = "開啟音樂";
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mp.start();
            }else if(!mp.isPlaying()){
                mp.start();
            }

        }
        //Toast.makeText(this, state, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mp != null && mp.isPlaying()) {
            mp.stop();
            mp.release();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mp != null && mp.isPlaying()) {
            mp.stop();
            mp.release();
        }
    }
}