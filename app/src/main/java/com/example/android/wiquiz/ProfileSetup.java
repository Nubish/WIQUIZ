package com.example.android.wiquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProfileSetup extends AppCompatActivity implements View.OnClickListener {

    EditText nameEditText;
    Button nextButton;

    private void instantiate() {
        nameEditText = (EditText) findViewById(R.id.editText2);
        nextButton = (Button) findViewById(R.id.button11);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_setup);

        instantiate();
        nextButton.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button11) {
            saveData();
        }
    }

    private void saveData() {

        String name = nameEditText.getText().toString();

        if (name.equals("")) {
            Toast.makeText(this, "Please enter your name.", Toast.LENGTH_LONG).show();
        } else {
            SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("userName", name);
            editor.putBoolean("isFirst", false);
            editor.commit();
            Log.d("raghucheck", "activityprofile else");
            Toast.makeText(this, "Profile Created", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ProfileSetup.this, MainMenu.class);
            startActivity(intent);
        }
    }
}