//farshad ghodrati
//this activity will start maintaining flexibility for already flexible poeple

package com.example.farshad.finalproject;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class StartExercise2Activity extends AppCompatActivity {



    ImageView exerciseImageView2;

    TextView exerciseTextView2,
            getSetTextView2,
            countDownTextView2,
            goTextview2;

    int STOP = 9; // stops process after all exercise are done

    int timer;
    int tempTimer;
    int countDown = 5;
    int tempcounDown;
    int repeat = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_exercise2);



        exerciseImageView2 = (ImageView) findViewById(R.id.startExerciseActivityImageView2);
        exerciseTextView2 = (TextView) findViewById(R.id.startExerciseActivityTextView2);
        getSetTextView2 = (TextView) findViewById(R.id.getSetTextView2);
        countDownTextView2 = (TextView) findViewById(R.id.countDownTextView2);
        goTextview2 = (TextView)findViewById(R.id.goLabelTextView2);

        Intent intent = getIntent();
        timer = intent.getIntExtra("send_timer2", 30); //default timer = 30

        tempTimer = timer;
        tempcounDown = countDown;

        GetSetFunc();

    }



    //starts countdown for rest time
    public void GetSetFunc(){

        changeImage();

        new CountDownTimer(1000000000, 1000) {
            @Override
            public void onTick(long l) {
                countDownTextView2.setText(String.valueOf(countDown));
                countDown--;
                if (countDown == -1) {
                    cancel();

                    countDownTextView2.setText("");
                    getSetTextView2.setText("");
                    countDown = tempcounDown; //reset countdown back to default 5
                    TimerStart();

                }
            }

            @Override
            public void onFinish() {

            }
        }.start();

    }

    //starts coundown during exercise
    public void TimerStart(){
        new CountDownTimer(100000, 1000) {


            @Override
            public void onTick(long l) {
                exerciseTextView2.setText(String.valueOf(timer));
                goTextview2.setText("BEGIN");
                timer--;
                if (timer == -1) {
                    cancel();
                    exerciseTextView2.setText("");
                    countDownTextView2.setText("");

                    timer = tempTimer; //reset timer back to default
                    repeat++;
                    if(repeat <= STOP) {
                        getSetTextView2.setText("GET READY");
                        goTextview2.setText("");
                        GetSetFunc();

                    }
                    else{
                        goTextview2.setText("GOOD JOB ALL DONE!");
                        exerciseTextView2.setText("");
                        countDownTextView2.setText("");
                        getSetTextView2.setText("");
                    }
                }
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    //change image of exercise
    public void changeImage(){

        int picID;

        int id[] = new int[10];
        id[1] = R.drawable.maintain1;
        id[2] = R.drawable.maintain2;
        id[3] = R.drawable.maintain3;
        id[4] = R.drawable.maintain4;
        id[5] = R.drawable.maintain5;
        id[6] = R.drawable.maintain6;
        id[7] = R.drawable.maintain7;
        id[8] = R.drawable.maintain8;
        id[9] = R.drawable.maintain9;

        for (int i = 0; i <=8; i++){
            if (repeat == i){
                picID = id[i+1];
                exerciseImageView2.setImageResource(picID);
            }
        }

    }
}


