package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity implements PlanRecViewAdapter.DeletePlan {
    private static final String TAG = "EditActivity";

    @Override
    public void onDeletingPlan(String day) {
        Log.d(TAG, "onDeletingPlan: day: " + day);

        txtDay.setText(day);

        ArrayList<Plan> plans = new ArrayList<>();
        for (Plan plan:Utils.getUsersPlans()){
            if (plan.getDay().equals(day)){
                plans.add(plan);
            }
        }

        adapter.setPlans(plans);
    }

    private RecyclerView recyclerView;
    private TextView txtDay;
    private Button btnAddMorePlan;

    private PlanRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        initViews();

        adapter = new PlanRecViewAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setType("edit");

        Intent intent = getIntent();
        try{

            String day = intent.getStringExtra("day");
            if (day != null){
                txtDay.setText(day);

                ArrayList<Plan> plans = new ArrayList<>();
                for (Plan plan: Utils.getUsersPlans()){
                    if (plan.getDay().equals(day)){
                        plans.add(plan);
                    }
                }

                adapter.setPlans(plans);
            }

        }catch (NullPointerException e){
            e.printStackTrace();
        }

        btnAddMorePlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditActivity.this, AllTrainingActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }

    private void initViews(){
        Log.d(TAG, "initViews: started");

        recyclerView = (RecyclerView) findViewById(R.id.reCyclerView);
        txtDay = (TextView) findViewById(R.id.txtDay);
        btnAddMorePlan = (Button) findViewById(R.id.btnAddMorePlan);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, PlanActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
}
