//farshad ghodrati
//this activity will start the home workout routines

package com.example.farshad.finalproject;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class StartExercise3Activity extends AppCompatActivity {

    ImageView exerciseImageView3;

    TextView exerciseTextView3,
            getSetTextView3,
            countDownTextView3,
            goTextview3;

    int STOP = 9; // stops process after all exercise are done

    int timer;
    int tempTimer;
    int countDown = 10;
    int tempcounDown;
    int repeat = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_exercise3);

        exerciseImageView3 = (ImageView) findViewById(R.id.startExerciseActivityImageView3);
        exerciseTextView3 = (TextView) findViewById(R.id.startExerciseActivityTextView3);
        getSetTextView3 = (TextView) findViewById(R.id.getSetTextView3);
        countDownTextView3 = (TextView) findViewById(R.id.countDownTextView3);
        goTextview3 = (TextView)findViewById(R.id.goLabelTextView3);

        Intent intent = getIntent();
        timer = intent.getIntExtra("send_timer3", 30); //default timer = 30

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
                countDownTextView3.setText(String.valueOf(countDown));
                countDown--;
                if (countDown == -1) {
                    cancel();

                    countDownTextView3.setText("");
                    getSetTextView3.setText("");
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
                exerciseTextView3.setText(String.valueOf(timer));
                goTextview3.setText("BEGIN");
                timer--;
                if (timer == -1) {
                    cancel();
                    exerciseTextView3.setText("");
                    countDownTextView3.setText("");

                    timer = tempTimer; //reset timer back to default
                    repeat++;
                    if(repeat <= STOP) {
                        getSetTextView3.setText("GET READY");
                        goTextview3.setText("");
                        GetSetFunc();

                    }
                    else{
                        goTextview3.setText("GOOD JOB ALL DONE!");
                        exerciseTextView3.setText("");
                        countDownTextView3.setText("");
                        getSetTextView3.setText("");
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

        id[1] = R.drawable.workout1;
        id[2] = R.drawable.workout2;
        id[3] = R.drawable.workout3;
        id[4] = R.drawable.workout4;
        id[5] = R.drawable.workout5;
        id[6] = R.drawable.workout6;
        id[7] = R.drawable.workout7;
        id[8] = R.drawable.workout8;
        id[9] = R.drawable.workout9;

        for ( int i = 0; i <= 8; i++){
            if( repeat == i){
                picID = id[i+1];
                exerciseImageView3.setImageResource(picID);
            }
        }
    }

}
