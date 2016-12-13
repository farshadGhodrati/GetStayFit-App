//farshad ghodrati
//maintain activity

package com.example.farshad.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MaintainActivity extends AppCompatActivity {

    int timer;
    ImageButton maintain_image1,
                maintain_image2,
                maintain_image3,
                maintain_image4,
                maintain_image5,
                maintain_image6,
                maintain_image7,
                maintain_image8,
                maintain_image9;

    Button startButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintain);

        Intent intent = getIntent();
        timer =  intent.getIntExtra("timer_timer1", 30); //default timer

        Update();

    }

    public void StartExercise2Activity(View view){

        Intent intent = new Intent(this, StartExercise2Activity.class);
        intent.putExtra("send_timer2", timer);
        startActivity(intent);
    }


    public void maintain_image_1_view(View view){


        int getId = view.getId();

        String str = "";
        String str1 = "maintain_image_";
        String maintain_Image_1 = "";

        //array to get button id
        int ID_1[] = new int[10];
        ID_1[1] = R.id.maintain_Image_1;
        ID_1[2] = R.id.maintain_Image_2;
        ID_1[3] = R.id.maintain_Image_3;
        ID_1[4] = R.id.maintain_Image_4;
        ID_1[5] = R.id.maintain_Image_5;
        ID_1[6] = R.id.maintain_Image_6;
        ID_1[7] = R.id.maintain_Image_7;
        ID_1[8] = R.id.maintain_Image_8;
        ID_1[9] = R.id.maintain_Image_9;

        //array of image discriptions
        String discription[] = new String[10];
        discription[1] = getResources().getString(R.string.maintainString_1);
        discription[2] = getResources().getString(R.string.maintainString_2);
        discription[3] = getResources().getString(R.string.maintainString_3);
        discription[4] = getResources().getString(R.string.maintainString_4);
        discription[5] = getResources().getString(R.string.maintainString_5);
        discription[6] = getResources().getString(R.string.maintainString_6);
        discription[7] = getResources().getString(R.string.maintainString_7);
        discription[8] = getResources().getString(R.string.maintainString_8);
        discription[9] = getResources().getString(R.string.maintainString_9);

        for (int i = 1; i <= 9; i++) {
            if (getId == ID_1[i]) {
                str = String.valueOf(i);
                str1 = str1 + str;
                maintain_Image_1 = discription[i];
            }
        }

        Intent intent = new Intent(this, ImageViewActivity.class);
        intent.putExtra(str1, maintain_Image_1);
        startActivity(intent);
    }


    public void Update(){

        startButton2 = (Button) findViewById(R.id.maintainStartButton);

        maintain_image1 = (ImageButton)findViewById(R.id.maintain_Image_1);
        maintain_image2 = (ImageButton)findViewById(R.id.maintain_Image_2);
        maintain_image3 = (ImageButton)findViewById(R.id.maintain_Image_3);
        maintain_image4 = (ImageButton)findViewById(R.id.maintain_Image_4);
        maintain_image5 = (ImageButton)findViewById(R.id.maintain_Image_5);
        maintain_image6 = (ImageButton)findViewById(R.id.maintain_Image_6);
        maintain_image7 = (ImageButton)findViewById(R.id.maintain_Image_7);
        maintain_image8 = (ImageButton)findViewById(R.id.maintain_Image_8);
        maintain_image9 = (ImageButton)findViewById(R.id.maintain_Image_9);

        maintain_image1.setImageResource(R.drawable.m1);
        maintain_image2.setImageResource(R.drawable.m2);
        maintain_image3.setImageResource(R.drawable.m3);
        maintain_image4.setImageResource(R.drawable.m4);
        maintain_image5.setImageResource(R.drawable.m5);
        maintain_image6.setImageResource(R.drawable.m6);
        maintain_image7.setImageResource(R.drawable.m7);
        maintain_image8.setImageResource(R.drawable.m8);
        maintain_image9.setImageResource(R.drawable.m9);

    }
}
