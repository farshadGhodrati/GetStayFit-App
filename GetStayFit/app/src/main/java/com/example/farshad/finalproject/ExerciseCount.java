package com.example.farshad.finalproject;

/**
 * Created by admin on 12/8/16.
 */

public class ExerciseCount {
    private String count;
    private int mNameResId;
    private int mImageResId;

    //Return the resource ID
    public int getmNameResId() {
        return mNameResId;
    }

    //Set the resource ID
    public void setmNameResId(int mNameResId) {
        this.mNameResId = mNameResId;
    }

    //Return the resource ID
    public int getmImageResId() {
        return mImageResId;
    }

    //Set the resource ID
    public void setmImageResId(int mImageResId) {
        this.mImageResId = mImageResId;
    }

    public String getCount(){
        return count;
    }

    public void setCount(String Count) {
        this.count = Count;
    }

    //Constructor
    public ExerciseCount(int nameResId, int imageResId) {
        mNameResId = nameResId;
        mImageResId = imageResId;
        count = "";
    }
}
