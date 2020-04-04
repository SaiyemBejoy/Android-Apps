package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Button btnSeePlan, btnActivities, btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utils.initializeAll();

        initViews();
        setOnClickListeners();
    }

    private void setOnClickListeners(){
        Log.d(TAG, "setOnClickListeners: started");
        btnActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllTrainingActivity.class);
                startActivity(intent);
            }
        });

        btnSeePlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlanActivity.class);
                startActivity(intent);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AboutDialog aboutDialog = new AboutDialog();
                aboutDialog.show(getSupportFragmentManager(), "about dialog");
            }
        });
    }

    private void initViews(){
        Log.d(TAG, "initViews: started");

        btnSeePlan = (Button) findViewById(R.id.btnSeeYourPlan);
        btnActivities = (Button) findViewById(R.id.btnAllActivities);
        btnAbout = (Button) findViewById(R.id.btnAbout);
    }
}
