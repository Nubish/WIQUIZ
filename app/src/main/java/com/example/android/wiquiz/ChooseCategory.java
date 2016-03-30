package com.example.android.wiquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import static com.example.android.wiquiz.GetRandomNumberFromRange.getRandom;

public class ChooseCategory extends AppCompatActivity implements View.OnClickListener {

    Button randomButton, gkButton, sportsButton, entertainmentButton, historyButton, sci_techButton;

    private void instantiate() {
        randomButton = (Button) findViewById(R.id.buttonRandom);
        gkButton = (Button) findViewById(R.id.buttonGk);
        sportsButton = (Button) findViewById(R.id.buttonSports);
        entertainmentButton = (Button) findViewById(R.id.buttonEntertainment);
        historyButton = (Button) findViewById(R.id.buttonHistory);
        sci_techButton = (Button) findViewById(R.id.buttonSci_Tech);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category);

        instantiate();
        Score.resetScore(this);

        randomButton.setOnClickListener(this);
        gkButton.setOnClickListener(this);
        sportsButton.setOnClickListener(this);
        entertainmentButton.setOnClickListener(this);
        historyButton.setOnClickListener(this);
        sci_techButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonRandom: {
                saveCategory(-1);
                startActivity(new Intent(this, QuizMode.class));
                break;
            }
            case R.id.buttonGk: {
                saveCategory(0);
                startActivity(new Intent(this, QuizMode.class));
                break;
            }
            case R.id.buttonSports: {
                saveCategory(1);
                startActivity(new Intent(this, QuizMode.class));
                break;
            }
            case R.id.buttonEntertainment: {
                saveCategory(2);
                startActivity(new Intent(this, QuizMode.class));
                break;
            }
            case R.id.buttonHistory: {
                saveCategory(3);
                startActivity(new Intent(this, QuizMode.class));
                break;
            }
            case R.id.buttonSci_Tech: {
                saveCategory(4);
                startActivity(new Intent(this, QuizMode.class));
                break;
            }
        }
    }

    private void saveCategory(int categoryIndex) {
        SharedPreferences sharedPreferences = getSharedPreferences("Game", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("categoryIndex", categoryIndex);
        editor.commit();
        Log.d("game",""+categoryIndex);
    }


}
