package com.example.android.wiquiz;


/**
 * Created by raghu on 30/3/16.
 * Returns a random number between min and max,
 *
 */
public class GetRandomNumberFromRange {

    public static int getRandom(int Min,int Max)
    {
        int randomNum=Min + (int)(Math.random() * ((Max - Min) + 1));
        return randomNum;
    }
}
