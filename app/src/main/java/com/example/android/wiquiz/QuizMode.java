

package com.example.android.wiquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import static android.content.SharedPreferences.*;
import static com.example.android.wiquiz.GetRandomNumberFromRange.getRandom;

public class QuizMode extends AppCompatActivity {


    private static final int DEFAULT_CATEGORY = getRandom(0, 4);
    private Context context;
    public TextView question;
    private RecyclerView recyclerView;
    private ArrayList<String> answers;

    //private String fileName = "src/main/res/raw/datajson.txt";
    Gson gson;
    private Response responseobj;

    private String data = "";


    private void instantiate() {
        context = QuizMode.this;
        question = (TextView) findViewById(R.id.question);
        answers = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setHasFixedSize(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_mode);

        instantiate();

        FileReaderHelper fileReaderHelper = new FileReaderHelper();
        try {
            data = fileReaderHelper.readData(this);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //int category = getCategory();

        gson = new Gson();
        responseobj = gson.fromJson(data, Response.class);
        //answers=responseobj.getCategoriesArray().get(0).getQuestion().get(0).getAnswerArray();
        //recyclerView.setAdapter(new CustomQuizAdapter(context, responseobj));
        recyclerView.setAdapter(new CustomQuizAdapter(context, responseobj, getCategory()));

    }

    private int getCategory() {
        SharedPreferences sharedPreferences = getSharedPreferences("Game", Context.MODE_PRIVATE);
        int category = sharedPreferences.getInt("categoryIndex", DEFAULT_CATEGORY);
        return category;
    }

    public void setQuestion(String ques) {

        question.setText(ques);
    }

}
