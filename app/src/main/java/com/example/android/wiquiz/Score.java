package com.example.android.wiquiz;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by raghu on 31/3/16.
 */
public class Score {

    int score;
    int highscore;

    public static void resetScore(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Score", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("score", 0);
        editor.commit();
    }

    public void increaseScore(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Score", Context.MODE_PRIVATE);
        score = sharedPreferences.getInt("score", 0);
        highscore=sharedPreferences.getInt("highScore",0);
        score++;
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("score", score);
        editor.commit();
        if(score>highscore)
        {
            Score score1 = new Score();
            score1.setHighscore(score,context);
        }

    }

    public static int getScore(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Score", Context.MODE_PRIVATE);
        Score scoreobj=new Score();
        scoreobj.score = sharedPreferences.getInt("score", 0);

        return scoreobj.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static int getHighscore(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Score", Context.MODE_PRIVATE);
        Score scoreobj=new Score();
        scoreobj.highscore = sharedPreferences.getInt("highScore", 0);

        return scoreobj.highscore;
    }

    private void setHighscore(int highscore,Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Score", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("highScore", highscore);
        editor.commit();


    }

}
