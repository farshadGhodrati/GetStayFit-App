package com.example.farshad.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class ImageViewActivity extends AppCompatActivity {

    String imageDescribtion = "";
    ImageView  exerciseImage;
    TextView ImageDescribtionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        exerciseImage = (ImageView)findViewById(R.id.exerciseImageView);
        ImageDescribtionTextView = (TextView) findViewById(R.id.imageDescribtionTextView);

        update();


    }

    //update image and discription
    public void update() {

        Bundle bundle = getIntent().getExtras();

        //will get inflexibility activity image discription
        if (imageDescribtion == "") {
            imageDescribtion = bundle.getString("inflex_image_1");
            exerciseImage.setImageResource(R.drawable.stretch1);
        }
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

        int id2[] = new int[10];
        id2[1] = R.drawable.workout1;
        id2[2] = R.drawable.workout2;
        id2[3] = R.drawable.workout3;
        id2[4] = R.drawable.workout4;
        id2[5] = R.drawable.workout5;
        id2[6] = R.drawable.workout6;
        id2[7] = R.drawable.workout7;
        id2[8] = R.drawable.workout8;
        id2[9] = R.drawable.workout9;

        int id3[] = new int[10];
        id3[1] = R.drawable.maintain1;
        id3[2] = R.drawable.maintain2;
        id3[3] = R.drawable.maintain3;
        id3[4] = R.drawable.maintain4;
        id3[5] = R.drawable.maintain5;
        id3[6] = R.drawable.maintain6;
        id3[7] = R.drawable.maintain7;
        id3[8] = R.drawable.maintain8;
        id3[9] = R.drawable.maintain9;


        for (int i = 2; i <= 9; i++){
            String strInflex ="inflex_image_";
            picID = id[i];
            String str1 = String.valueOf(i);
            strInflex = strInflex + str1;
            if (imageDescribtion == null) {
                imageDescribtion = bundle.getString(strInflex);
                exerciseImage.setImageResource(picID);
            }
        }
        for (int i = 1; i <= 9; i++){
            String strMaintain = "maintain_image_";
            picID = id3[i];
            String str1 = String.valueOf(i);
            strMaintain = strMaintain + str1;
            if (imageDescribtion == null) {
                imageDescribtion = bundle.getString(strMaintain);
                exerciseImage.setImageResource(picID);
            }
        }
        for (int i = 1; i <= 9; i++){
            String strWorkout ="homeWorkout_image_";
            picID = id2[i];
            String str1 = String.valueOf(i);
            strWorkout = strWorkout + str1;
            if (imageDescribtion == null) {
                imageDescribtion = bundle.getString(strWorkout);
                exerciseImage.setImageResource(picID);
            }
        }


        ImageDescribtionTextView.setText(imageDescribtion);
    }

}

