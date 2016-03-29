

package com.example.android.wiquiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

public class QuizMode extends AppCompatActivity {

    private Context context;
    public TextView question;
    private RecyclerView recyclerView;
    private ArrayList<String> answers;

    private String fileName = "src/main/res/raw/datajson.txt";
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


        gson = new Gson();
        responseobj = gson.fromJson(data, Response.class);
        //answers=responseobj.getCategoriesArray().get(0).getQuestion().get(0).getAnswerArray();
        recyclerView.setAdapter(new CustomQuizAdapter(context, responseobj));
    }

    public void setQuestion(String ques) {
        question.setText(ques);
    }

}
