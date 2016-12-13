package com.example.farshad.finalproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ResultsActivity extends AppCompatActivity {

    private final String TAG = "Exercises";

    //filename for location data
    private final String FILE_EXERCISE_COUNT = "exercise_count";


    private TextView lastCountLabelTextView;
    private TextView editEnterCountLabelTextView;
    private ImageView exerciseImageView;
    private Button exerciseNextButton;
    private Button exercisePreviousButton;

    private EditText exerciseCountEditText;
    private TextView exerciseLastCountTextView;

    //our model
    private final ExerciseCount[] ExeCount = new ExerciseCount[] {
            new ExerciseCount(R.string.pushups_lable, R.drawable.workout1),
            new ExerciseCount(R.string.situps_lable, R.drawable.workout2),
            new ExerciseCount(R.string.leftLunges_lable, R.drawable.workout7),
            new ExerciseCount(R.string.rightLunges_lable, R.drawable.workout8)
    };

    private int Index = 0;

    //key to save mCurrentIndex in Bundle
    private static final String KEY_EXERCISE_INDEX = "exercise_index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);




        try(FileInputStream in = openFileInput(FILE_EXERCISE_COUNT)){
            //load vehicle year from file, if file was written
            String line;
            char next;

            //loop over the 4 lines in the file (hardcoded, lazy!)
            for(int i = 0; i < 4; i++) {
                line = "";
                while ((next = (char) in.read()) != '\n') {
                    line += next;
                }

                Log.d(TAG, "Read the following location from file: " + line);
            }
            in.close();
        } catch (java.io.FileNotFoundException fnfe) {
            Log.d(TAG, "FileNotFoundException when trying to load file" + fnfe);
        } catch(java.io.IOException ioe) {
            Log.d(TAG, "IOException when trying to load file" + ioe);
        }

        try(FileInputStream in = openFileInput(FILE_EXERCISE_COUNT)){
            //load vehicle year from file, if file was written
            String line;
            char next;

            //loop over the 4 lines in the file (hardcoded, lazy!)
            for(int i = 0; i < 4; i++) {
                line = "";
                while ((next = (char) in.read()) != '\n') {
                    line += next;
                }
                ExeCount[i].setCount(line);
                Log.d(TAG, "Read the following location from file: " + line);
            }
            in.close();
        } catch (java.io.FileNotFoundException fnfe) {
            Log.d(TAG, "FileNotFoundException when trying to load file" + fnfe);
        } catch(java.io.IOException ioe) {
            Log.d(TAG, "IOException when trying to load file" + ioe);
        }

        //update with saved state when re-creating this activity
        if(savedInstanceState != null)

            Index = savedInstanceState.getInt(KEY_EXERCISE_INDEX, 0);

            exerciseImageView = (ImageView) findViewById(R.id.workoutImageView);
            exerciseNextButton = (Button) findViewById(R.id.NextExerciseButton);
            exercisePreviousButton = (Button) findViewById(R.id.PreviousExerciseButton);
            exerciseCountEditText = (EditText) findViewById(R.id.EditCountTextView);
            exerciseLastCountTextView = (TextView) findViewById(R.id.lastCountTextView);
            lastCountLabelTextView = (TextView) findViewById(R.id.lastCountLableTextView);
            editEnterCountLabelTextView = (TextView) findViewById(R.id.EditEnterCountLableTextView);

            exerciseCountEditText.addTextChangedListener(colorEditTextWatcher);

            exerciseCountEditText.setText(ExeCount[Index].getCount());

            update();

        //define the behavior of the Next Button
        exerciseNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //% ensures we wrap back to index 0
                Index = (Index + 1) % 4;
                update();
                exerciseCountEditText.setText(ExeCount[Index].getCount());
            }
        });

        //define the behavior of the Next Button
        exercisePreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Index = (Index - 1);

                //ensures we wrap back to index 3 (instead of -1)
                if(Index == -1)
                    Index = 3;

                update();

                exerciseCountEditText.setText(ExeCount[Index].getCount());

            }
        });

    } //end of onCreate


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");

        //when app is destroyed, save file info
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(FILE_EXERCISE_COUNT, Context.MODE_PRIVATE);


            outputStream.close();
        } catch (FileNotFoundException fnfe) {
            Log.d(TAG, "FileNotFound Exception when trying to write output");
        } catch (IOException ioe) {
            Log.d(TAG, "IOException when trying to write output");
        }

        try {
            outputStream = openFileOutput(FILE_EXERCISE_COUNT, Context.MODE_PRIVATE);

            //write each contact location to a new line
            for(int i = 0; i < 4; i++) {
                outputStream.write((ExeCount[i].getCount() + '\n').getBytes());/////////////////
                Log.d(TAG, "Writing location: " + ExeCount[i].getCount() + '\n');///////////////
            }

            outputStream.close();
        } catch (FileNotFoundException fnfe) {
            Log.d(TAG, "FileNotFound Exception when trying to write output");
        } catch (IOException ioe) {
            Log.d(TAG, "IOException when trying to write output");
        }

    }

    //define the TextWatcher for mNameEditText
    private final TextWatcher yearEditTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //update location based on what user entered
            update();
        }

        //we have to override these, but we don't have to make them do anything
        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
    };

    private final TextWatcher colorEditTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            //update location based on what user entered
            ExeCount[Index].setCount(s.toString());
            update();
        }

        //we have to override these, but we don't have to make them do anything
        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
    };

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(KEY_EXERCISE_INDEX, Index);
    }

    private void update() {
        exerciseImageView.setImageResource(ExeCount[Index].getmImageResId());
        exerciseLastCountTextView.setText(ExeCount[Index].getCount());
    }
}



