package com.example.android.wiquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectMode extends AppCompatActivity implements View.OnClickListener {
    Button singleUserButton, multiUserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_mode);
        singleUserButton = (Button) findViewById(R.id.singleUserButton);
        multiUserButton = (Button) findViewById(R.id.multiUserButton);
        singleUserButton.setOnClickListener(this);
        multiUserButton.setOnClickListener(this);
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.singleUserButton: {
                startActivity(new Intent(this, ChooseCategory.class));

                break;
            }
            case R.id.multiUserButton: {
                startActivity(new Intent(this, WiFiDirectActivity.class));

                break;
            }
        }
    }
}