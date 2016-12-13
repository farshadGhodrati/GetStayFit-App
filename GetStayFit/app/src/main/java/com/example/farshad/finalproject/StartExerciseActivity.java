//farshad ghodrati
//this activity will start the exercises for inflexibility stretching

package com.example.farshad.finalproject;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class StartExerciseActivity extends AppCompatActivity {

    ImageView   exerciseImageView;

    TextView    exerciseTextView,
                getSetTextView,
                countDownTextView,
                goTextview;

    int STOP = 9; // stops process after all exercise are done

    int timer;
    int tempTimer;
    int countDown = 5;
    int tempcounDown;
    int repeat = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_exercise);

        exerciseImageView = (ImageView) findViewById(R.id.startExerciseActivityImageView);
        exerciseTextView = (TextView) findViewById(R.id.startExerciseActivityTextView);
        getSetTextView = (TextView) findViewById(R.id.getSetTextView);
        countDownTextView = (TextView) findViewById(R.id.countDownTextView);
        goTextview = (TextView)findViewById(R.id.goLabelTextView);

        Intent intent = getIntent();
        timer = intent.getIntExtra("send_timer", 30); //default timer = 30

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
                    countDownTextView.setText(String.valueOf(countDown));
                    countDown--;
                    if (countDown == -1) {
                        cancel();

                        countDownTextView.setText("");
                        getSetTextView.setText("");
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
                exerciseTextView.setText(String.valueOf(timer));
                goTextview.setText("BEGIN");
                timer--;
                if (timer == -1) {
                    cancel();
                    exerciseTextView.setText("");
                    countDownTextView.setText("");

                    timer = tempTimer; //reset timer back to default
                    repeat++;
                    if(repeat <= STOP) {
                        getSetTextView.setText("GET READY");
                        goTextview.setText("");
                        GetSetFunc();

                    }
                    else{
                        goTextview.setText("GOOD JOB ALL DONE!");
                        exerciseTextView.setText("");
                        countDownTextView.setText("");
                        getSetTextView.setText("");
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

        id[1] = R.drawable.stretch1;
        id[2] = R.drawable.stretch2;
        id[3] = R.drawable.stretch3;
        id[4] = R.drawable.stretch4;
        id[5] = R.drawable.stretch5;
        id[6] = R.drawable.stretch6;
        id[7] = R.drawable.stretch7;
        id[8] = R.drawable.stretch8;
        id[9] = R.drawable.stretch9;

        for (int i = 0; i <= 8; i++){
            if (repeat == i){
                picID = id[i+1];
                exerciseImageView.setImageResource(picID);
            }
        }

    }
}
