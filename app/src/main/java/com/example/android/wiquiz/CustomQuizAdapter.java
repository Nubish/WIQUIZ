package com.example.android.wiquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import static com.example.android.wiquiz.GetRandomNumberFromRange.getRandom;


/**
 * Created by raghu on 29/3/16.
 */
public class CustomQuizAdapter extends RecyclerView.Adapter<CustomQuizAdapter.CustomViewholder> {

    //private int randomQuestion;
    private Context context;
    private Response response;
    private int category;

    public CustomQuizAdapter(Context context, Response response, int category) {
        this.context = context;
        this.response = response;
        this.category = category;
        //  this.randomQuestion = getRandom(1, this.responseCategoriesArray.getQuestion().size());
        //    Log.d("size", "" + randomQuestion);

    }

    @Override
    public CustomViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_quiz_mode_row, parent, false);
        return new CustomViewholder(view);
    }

    @Override
    public void onBindViewHolder(final CustomViewholder holder, int position) {

        //String ques = responseCategoriesArray.getQuestion().get(randomQuestion).getProblem();
        Response.CategoriesArray.Question ques = getRandomQuestion(category);

        final String correct = ques.getCorrectAnswer().toString();
        ((QuizMode) context).setQuestion(ques.getProblem().toString());


        //holder.answer.setText(responseCategoriesArray.getQuestion().get(randomQuestion).getAnswerArray().get(position));
        holder.answer.setText(ques.getAnswerArray().get(position));

        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (holder.answer.getText().toString().equals(correct)) {
                    //    holder.root.setCardBackgroundColor(ContextCompat.getColor(context, R.color.correctAnswer));

                } else {
                    //  holder.root.setCardBackgroundColor(ContextCompat.getColor(context, R.color.wrongAnswer));*//**//*
                }

                context.startActivity(new Intent(context, QuizMode.class));


            }
        });


    }

    private Response.CategoriesArray.Question getRandomQuestion(int category) {
        Response.CategoriesArray.Question ques = new Response.CategoriesArray.Question();
        if (category == -1) {
            int randomCategory = getRandom(0, response.getCategoriesArray().size());
            int randomQuestion = getRandom(0, response.getCategoriesArray().get(randomCategory).getQuestion().size());
            String questionId=response.getCategoriesArray().get(randomCategory).getQuestion().get(randomQuestion).getQuestionId().toString();
            String problem=response.getCategoriesArray().get(randomCategory).getQuestion().get(randomQuestion).getProblem().toString();
            List<String> answerArray=response.getCategoriesArray().get(randomCategory).getQuestion().get(randomQuestion).getAnswerArray();
            String correctAnswer=response.getCategoriesArray().get(randomCategory).getQuestion().get(randomQuestion).getCorrectAnswer().toString();


            ques.setQuestionId(questionId);
            ques.setProblem(problem);
            ques.setAnswerArray(answerArray);
            ques.setCorrectAnswer(correctAnswer);


        }
        else {
            int randomQuestion = getRandom(0, response.getCategoriesArray().get(category).getQuestion().size());

            String questionId=response.getCategoriesArray().get(category).getQuestion().get(randomQuestion).getQuestionId().toString();
            String problem=response.getCategoriesArray().get(category).getQuestion().get(randomQuestion).getProblem().toString();
            List<String> answerArray=response.getCategoriesArray().get(category).getQuestion().get(randomQuestion).getAnswerArray();
            String correctAnswer=response.getCategoriesArray().get(category).getQuestion().get(randomQuestion).getCorrectAnswer().toString();


            ques.setQuestionId(questionId);
            ques.setProblem(problem);
            ques.setAnswerArray(answerArray);
            ques.setCorrectAnswer(correctAnswer);


        }

        return ques;
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    static class CustomViewholder extends RecyclerView.ViewHolder {

        private TextView answer;
        private CardView root;

        public CustomViewholder(View itemView) {
            super(itemView);
            answer = (TextView) itemView.findViewById(R.id.answer);
            root = (CardView) itemView.findViewById(R.id.root);
        }
    }
}
