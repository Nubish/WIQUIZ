package com.example.android.wiquiz;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.example.android.wiquiz.GetRandomNumberFromRange.getRandom;


/**
 * Created by raghu on 29/3/16.
 */
public class CustomQuizAdapter extends RecyclerView.Adapter<CustomQuizAdapter.CustomViewholder> {

    private int randomQuestion;
    private Context context;
    private Response.CategoriesArray responseCategoriesArray;
    private int category;

    public CustomQuizAdapter(Context context, Response.CategoriesArray responseCategoriesArray, int category) {
        this.context = context;
        this.responseCategoriesArray = responseCategoriesArray;
        this.category=category;
        this.randomQuestion=getRandom(1, this.responseCategoriesArray.getQuestion().size());
        Log.d("size",""+randomQuestion);

    }

    @Override
    public CustomViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_quiz_mode_row, parent, false);
        return new CustomViewholder(view);
    }

    @Override
    public void onBindViewHolder(final CustomViewholder holder, int position) {

        String ques = responseCategoriesArray.getQuestion().get(randomQuestion).getProblem();
        final String correct = responseCategoriesArray.getQuestion().get(randomQuestion).getCorrectAnswer();
        ((QuizMode) context).setQuestion(ques);

        holder.answer.setText(responseCategoriesArray.getQuestion().get(randomQuestion).getAnswerArray().get(position));

        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (holder.answer.getText().toString().equals(correct))
                    holder.root.setCardBackgroundColor(ContextCompat.getColor(context, R.color.correctAnswer));
                else
                    holder.root.setCardBackgroundColor(ContextCompat.getColor(context, R.color.wrongAnswer));
            }
        });

    }

    @Override
    public int getItemCount() {
        return responseCategoriesArray.getQuestion().get(0).getAnswerArray().size();
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
