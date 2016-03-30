package com.example.android.wiquiz;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class ShowScore extends AppCompatActivity implements View.OnClickListener {

    Context context;
    Button tryAgainButton, quitButton;
    TextView yourScoreTextView, highScoreTextView;


    private void instantiate() {
        context = getApplicationContext();
        tryAgainButton = (Button) findViewById(R.id.buttonTryAgain);
        quitButton = (Button) findViewById(R.id.buttonQuit);
        yourScoreTextView = (TextView) findViewById(R.id.textviewYourScore);
        highScoreTextView = (TextView) findViewById(R.id.textViewHighScore);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_score);

        instantiate();


        int score = Score.getScore(context);
        int highScore = Score.getHighscore(context);

        String scoreString = "" + score;
        String highScoreString = "" + highScore;

        Log.d("ff", scoreString);
        Log.d("ff", highScoreString);

        yourScoreTextView.setText(scoreString);
        highScoreTextView.setText(highScoreString);
        tryAgainButton.setOnClickListener(this);
        quitButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonTryAgain: {
                startActivity(new Intent(this, ChooseCategory.class));
                break;
            }
            case R.id.buttonQuit: {
                showQuitDialog();
                break;
            }
        }

    }

    private void showQuitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.quit_dialog_message);
        builder.setCancelable(false);

        builder.setPositiveButton(R.string.Yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                int pid = android.os.Process.myPid();
                android.os.Process.killProcess(pid);
            }
        });

        builder.setNegativeButton(R.string.No, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}

