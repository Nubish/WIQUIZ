package com.example.android.wiquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity implements View.OnClickListener {

    Button playButton,addCategoryButton,shareCategoryButton,editProfileButton,quitButton;

    private void instantiate() {
        playButton= (Button) findViewById(R.id.buttonPlay);
        addCategoryButton= (Button) findViewById(R.id.buttonAddCategory);
        shareCategoryButton= (Button) findViewById(R.id.buttonShareCategory);
        editProfileButton= (Button) findViewById(R.id.buttonEditProfile);
        quitButton= (Button) findViewById(R.id.buttonQuit);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        instantiate();
        playButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.buttonPlay)
        {
            startActivity(new Intent(this,QuizMode.class));
        }
    }
}
