package com.example.farshad.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class HomeWrokoutActivity extends AppCompatActivity {

    int timer;

    Button startButton3;

    ImageButton homeWorkout_Image1,
                homeWorkout_Image2,
                homeWorkout_Image3,
                homeWorkout_Image4,
                homeWorkout_Image5,
                homeWorkout_Image6,
                homeWorkout_Image7,
                homeWorkout_Image8,
                homeWorkout_Image9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_wrokout);

        Intent intent = getIntent();
        timer = intent.getIntExtra("timer_timer2", 30); //default 30

        Update();



    }

    public void StartExercise3Activity(View view){
        Intent intent = new Intent(this, StartExercise3Activity.class);
        intent.putExtra("send_timer3", timer);
        startActivity(intent);
    }


    public void homeWorkout_Image_1_view(View view){


        int getId = view.getId();

        String str = "";
        String str1 = "homeWorkout_image_";
        String homeWorkout_image_1 = "";

        //array to get button id
        int ID_1[] = new int[10];
        ID_1[1] = R.id.homeWorkout_Image_1;
        ID_1[2] = R.id.homeWorkout_Image_2;
        ID_1[3] = R.id.homeWorkout_Image_3;
        ID_1[4] = R.id.homeWorkout_Image_4;
        ID_1[5] = R.id.homeWorkout_Image_5;
        ID_1[6] = R.id.homeWorkout_Image_6;
        ID_1[7] = R.id.homeWorkout_Image_7;
        ID_1[8] = R.id.homeWorkout_Image_8;
        ID_1[9] = R.id.homeWorkout_Image_9;

        //array of image discriptions
        String discription[] = new String[10];
        discription[1] = getResources().getString(R.string.homeWorkoutString_1);
        discription[2] = getResources().getString(R.string.homeWorkoutString_2);
        discription[3] = getResources().getString(R.string.homeWorkoutString_3);
        discription[4] = getResources().getString(R.string.homeWorkoutString_4);
        discription[5] = getResources().getString(R.string.homeWorkoutString_5);
        discription[6] = getResources().getString(R.string.homeWorkoutString_6);
        discription[7] = getResources().getString(R.string.homeWorkoutString_7);
        discription[8] = getResources().getString(R.string.homeWorkoutString_8);
        discription[9] = getResources().getString(R.string.homeWorkoutString_9);
        
        for (int i = 1; i <= 9; i++) {
            if (getId == ID_1[i]) {
                str = String.valueOf(i);
                str1 = str1 + str;
                homeWorkout_image_1 = discription[i];
            }
        }

        Intent intent = new Intent(this, ImageViewActivity.class);
        intent.putExtra(str1, homeWorkout_image_1);
        startActivity(intent);
    }


    public void Update(){

        startButton3 = (Button)findViewById(R.id.homeWorkoutStartButton);

        homeWorkout_Image1 = (ImageButton)findViewById(R.id.homeWorkout_Image_1);
        homeWorkout_Image2 = (ImageButton)findViewById(R.id.homeWorkout_Image_2);
        homeWorkout_Image3 = (ImageButton)findViewById(R.id.homeWorkout_Image_3);
        homeWorkout_Image4 = (ImageButton)findViewById(R.id.homeWorkout_Image_4);
        homeWorkout_Image5 = (ImageButton)findViewById(R.id.homeWorkout_Image_5);
        homeWorkout_Image6 = (ImageButton)findViewById(R.id.homeWorkout_Image_6);
        homeWorkout_Image7 = (ImageButton)findViewById(R.id.homeWorkout_Image_7);
        homeWorkout_Image8 = (ImageButton)findViewById(R.id.homeWorkout_Image_8);
        homeWorkout_Image9 = (ImageButton)findViewById(R.id.homeWorkout_Image_9);

        homeWorkout_Image1.setImageResource(R.drawable.w1);
        homeWorkout_Image2.setImageResource(R.drawable.w2);
        homeWorkout_Image3.setImageResource(R.drawable.w3);
        homeWorkout_Image4.setImageResource(R.drawable.w4);
        homeWorkout_Image5.setImageResource(R.drawable.w5);
        homeWorkout_Image6.setImageResource(R.drawable.w6);
        homeWorkout_Image7.setImageResource(R.drawable.w7);
        homeWorkout_Image8.setImageResource(R.drawable.w8);
        homeWorkout_Image9.setImageResource(R.drawable.w9);

    }
}
