package com.example.android.wiquiz;


/**
 * Created by raghu on 30/3/16.
 * Returns a random number between min and max,
 *
 */
public class GetRandomNumberFromRange {

    public static int getRandom(int Min,int Max)
    {
        int randomNum= (int) (Min + (Math.random() * (Max - Min)));
        return randomNum;
    }
}
