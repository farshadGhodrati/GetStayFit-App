//farshad ghodrati
//home training app to keep individuals in shape

package com.example.farshad.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int timer = 30;

    ImageView mainImage;
    Button inflexibleStretch;
    Button maintainFlexibility;
    Button homeWorkout;
    Button addTime;
    Button decTime;
    Button goToResult;
    TextView timerTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mainImage = (ImageView)findViewById(R.id.mainImageView);
        inflexibleStretch = (Button) findViewById(R.id.inflexible_button);
        maintainFlexibility = (Button) findViewById(R.id.maintainFlexibility_button);
        homeWorkout = (Button) findViewById(R.id.homeWorkout_button);
        addTime = (Button) findViewById(R.id.increaseTime_time);
        decTime = (Button)findViewById(R.id.decreaseTime_button);
        goToResult = (Button)findViewById(R.id.enterResults_button);
        timerTextView = (TextView)findViewById(R.id.timerTextView);



        timerTextView.setText(String.valueOf(timer)); //set default time to 30 seconds

        addTime.setOnClickListener(new View.OnClickListener() { // increase time
            @Override
            public void onClick(View view) {// increase timer
                timer++;
                if(timer >= 300){
                    timer = 300;
                }
                timerTextView.setText(String.valueOf(timer));
            }
        });

        decTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //decrease timer
                timer--;
                if(timer <= 10){
                    timer = 10;
                }
                timerTextView.setText(String.valueOf(timer));
            }
        });
    }

    public void inflexibilityActivity(View view){
        Intent intent = new Intent(this, InflexibilityActivity.class);
        intent.putExtra("timer_timer", timer);
        startActivity(intent);

    }

    public void maintainActivity(View view){
        Intent intent = new Intent(this, MaintainActivity.class);
        intent.putExtra("timer_timer1", timer);
        startActivity(intent);


    }

    public void homeWorkoutActivity(View view){
        Intent intent = new Intent(this, HomeWrokoutActivity.class);
        intent.putExtra("timer_timer2", timer);
        startActivity(intent);
    }

    public void goToResultsActivity(View view){
        startActivity(new Intent(this, ResultsActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
