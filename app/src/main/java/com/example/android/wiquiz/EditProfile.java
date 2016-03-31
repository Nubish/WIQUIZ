package com.example.android.wiquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditProfile extends AppCompatActivity implements View.OnClickListener {

    private static final String DEFAULT="NA";
    EditText editNameEditText;
    TextView highScoreTextView;
    Button saveEditedButton;

    private void instantiate() {
        editNameEditText = (EditText) findViewById(R.id.editTextEditName);
        highScoreTextView = (TextView) findViewById(R.id.textViewHighScore2);
        saveEditedButton = (Button) findViewById(R.id.buttonSaveEdited);
    }

    private void instantiateName() {
        SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
        String name=sharedPreferences.getString("userName","NA");
        editNameEditText.setText(name);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        instantiate();
        instantiateName();
        saveEditedButton.setOnClickListener(this);
        showHighScore();

    }

    private void showHighScore() {
        int highScore = Score.getHighscore(this);
        String highScoreString = "" + highScore;
        highScoreTextView.setText(highScoreString);
    }


    @Override
    public void onClick(View v) {
        saveEditedData(editNameEditText.toString());
    }

    private void saveEditedData(String name) {

        if (name.equals("")) {
            Toast.makeText(this, "Name cannot be blank.", Toast.LENGTH_LONG).show();
        } else {
            SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("userName", name);
            editor.commit();
            Toast.makeText(this, "Changes Saved", Toast.LENGTH_SHORT).show();

        }

    }
}