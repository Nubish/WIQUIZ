package com.example.android.wiquiz;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity implements View.OnClickListener {

    Button playButton, addCategoryButton, shareCategoryButton, editProfileButton, quitButton;

    private void instantiate() {
        playButton = (Button) findViewById(R.id.buttonPlay);
        addCategoryButton = (Button) findViewById(R.id.buttonAddCategory);
        shareCategoryButton = (Button) findViewById(R.id.buttonShareCategory);
        editProfileButton = (Button) findViewById(R.id.buttonEditProfile);
        quitButton = (Button) findViewById(R.id.buttonQuit);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        instantiate();
        playButton.setOnClickListener(this);
        quitButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonPlay: {
                startActivity(new Intent(this, ChooseCategory.class));

                break;
            }
            case R.id.buttonQuit: {
                dialogBox();
                break;
            }
        }
    }


    public void dialogBox() {
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
