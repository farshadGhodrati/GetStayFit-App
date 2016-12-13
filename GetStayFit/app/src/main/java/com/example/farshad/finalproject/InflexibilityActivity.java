package com.example.farshad.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class InflexibilityActivity extends AppCompatActivity {

    TextView textview;
    Button startButton;
    int timer;

    ImageButton inflexImage_1,
                inflexImage_2,
                inflexImage_3,
                inflexImage_4,
                inflexImage_5,
                inflexImage_6,
                inflexImage_7,
                inflexImage_8,
                inflexImage_9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inflexibility);


        Intent intent = getIntent();
        timer = intent.getIntExtra("timer_timer", 30); //default 30

        Update();

    }

    public void startInflexActivity(View view){
        Intent intent = new Intent(this, StartExerciseActivity.class);
        intent.putExtra("send_timer", timer);
        startActivity(intent);

    }

    public void inflex_Image_1_View(View view){

        int getId = view.getId();

        String str = "";
        String str1 = "inflex_image_";
        String inflex_image_1 = "";

        //array to get button id
        int ID_1[] = new int[10];
        ID_1[1] = R.id.Inflex_Image_1;
        ID_1[2] = R.id.Inflex_Image_2;
        ID_1[3] = R.id.Inflex_Image_3;
        ID_1[4] = R.id.Inflex_Image_4;
        ID_1[5] = R.id.Inflex_Image_5;
        ID_1[6] = R.id.Inflex_Image_6;
        ID_1[7] = R.id.Inflex_Image_7;
        ID_1[8] = R.id.Inflex_Image_8;
        ID_1[9] = R.id.Inflex_Image_9;

        //array of image discriptions
        String discription[] = new String[10];
        discription[1] = getResources().getString(R.string.inflexString_1);
        discription[2] = getResources().getString(R.string.inflexString_2);
        discription[3] = getResources().getString(R.string.inflexString_3);
        discription[4] = getResources().getString(R.string.inflexString_4);
        discription[5] = getResources().getString(R.string.inflexString_5);
        discription[6] = getResources().getString(R.string.inflexString_6);
        discription[7] = getResources().getString(R.string.inflexString_7);
        discription[8] = getResources().getString(R.string.inflexString_8);
        discription[9] = getResources().getString(R.string.inflexString_9);


        for (int i = 1; i <= 9; i++) {
            if (getId == ID_1[i]) {
                str = String.valueOf(i);
                str1 = str1 + str;
                inflex_image_1 = discription[i];
            }
        }

        Intent intent = new Intent(this, ImageViewActivity.class);
        intent.putExtra(str1, inflex_image_1);
        startActivity(intent);

    }

    public void Update(){

        startButton = (Button)findViewById(R.id.inflexibileStartButton);

        inflexImage_1  = (ImageButton) findViewById(R.id.Inflex_Image_1);
        inflexImage_2  = (ImageButton) findViewById(R.id.Inflex_Image_2);
        inflexImage_3  = (ImageButton) findViewById(R.id.Inflex_Image_3);
        inflexImage_4  = (ImageButton) findViewById(R.id.Inflex_Image_4);
        inflexImage_5  = (ImageButton) findViewById(R.id.Inflex_Image_5);
        inflexImage_6  = (ImageButton) findViewById(R.id.Inflex_Image_6);
        inflexImage_7  = (ImageButton) findViewById(R.id.Inflex_Image_7);
        inflexImage_8  = (ImageButton) findViewById(R.id.Inflex_Image_8);
        inflexImage_9  = (ImageButton) findViewById(R.id.Inflex_Image_9);


        inflexImage_1.setImageResource(R.drawable.s1);
        inflexImage_2.setImageResource(R.drawable.s2);
        inflexImage_3.setImageResource(R.drawable.s3);
        inflexImage_4.setImageResource(R.drawable.s4);
        inflexImage_5.setImageResource(R.drawable.s5);
        inflexImage_6.setImageResource(R.drawable.s6);
        inflexImage_7.setImageResource(R.drawable.s7);
        inflexImage_8.setImageResource(R.drawable.s8);
        inflexImage_9.setImageResource(R.drawable.s9);


    }
}
