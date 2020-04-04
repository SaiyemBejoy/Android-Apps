package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class PlanActivity extends AppCompatActivity {
    private static final String TAG = "PlanActivity";

    private RecyclerView mondayRecView, tuesdayRecView, wednesdayRecView, thursdayRecView, fridayRecView, saturdayRecView, sundayRecView;
    private RelativeLayout notAddedAPlanRelLayout;
    private Button btnAddAPlan;
    private NestedScrollView nestedScrollView;
    private TextView mondayEdit, tuesdayEdit, wednesdayEdit, thursdayEdit, fridayEdit, saturdayEdit, sundayEdit;

    private PlanRecViewAdapter mondayAdapter, tuesdayAdapter, wednesdayAdapter, thursdayAdapter, fridayAdapter, saturdayAdapter, sundayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        initViews();
        initAdapter();
        initRecView();

        if (Utils.getUsersPlans().size()>0){
            notAddedAPlanRelLayout.setVisibility(View.GONE);
            nestedScrollView.setVisibility(View.VISIBLE);
        }else {
            notAddedAPlanRelLayout.setVisibility(View.VISIBLE);
            nestedScrollView.setVisibility(View.GONE);
        }

        setOnClickListeners();
    }


    private void setOnClickListeners(){
        Log.d(TAG, "setOnClickListeners: started");

        mondayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanActivity.this, EditActivity.class);
                intent.putExtra("day", "Monday");
                startActivity(intent);
            }
        });

        tuesdayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanActivity.this, EditActivity.class);
                intent.putExtra("day", "Tuesday");
                startActivity(intent);
            }
        });

        wednesdayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanActivity.this, EditActivity.class);
                intent.putExtra("day", "Wednesday");
                startActivity(intent);
            }
        });

        thursdayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanActivity.this, EditActivity.class);
                intent.putExtra("day", "Thursday");
                startActivity(intent);
            }
        });

        fridayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanActivity.this, EditActivity.class);
                intent.putExtra("day", "Friday");
                startActivity(intent);
            }
        });

        saturdayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanActivity.this, EditActivity.class);
                intent.putExtra("day", "Saturday");
                startActivity(intent);
            }
        });

        sundayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanActivity.this, EditActivity.class);
                intent.putExtra("day", "Sunday");
                startActivity(intent);
            }
        });

        btnAddAPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlanActivity.this, AllTrainingActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }

    private void initAdapter(){
        Log.d(TAG, "initAdapter: started");

        mondayAdapter = new PlanRecViewAdapter(this);
        tuesdayAdapter = new PlanRecViewAdapter(this);
        wednesdayAdapter = new PlanRecViewAdapter(this);
        thursdayAdapter = new PlanRecViewAdapter(this);
        fridayAdapter = new PlanRecViewAdapter(this);
        saturdayAdapter = new PlanRecViewAdapter(this);
        sundayAdapter = new PlanRecViewAdapter(this);

    }

    private void initRecView(){
        Log.d(TAG, "initRecView: started");

        mondayRecView.setAdapter(mondayAdapter);
        mondayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        ArrayList<Plan> mondayPlans = new ArrayList<>();
        for (Plan plan: Utils.getUsersPlans()){
            if (plan.getDay().equals("Monday")) {
                mondayPlans.add(plan);
            }
        }
        mondayAdapter.setPlans(mondayPlans);

        tuesdayRecView.setAdapter(tuesdayAdapter);
        tuesdayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        ArrayList<Plan> tuesdayPlans = new ArrayList<>();
        for (Plan plan: Utils.getUsersPlans()){
            if (plan.getDay().equals("Tuesday")) {
                tuesdayPlans.add(plan);
            }
        }
        tuesdayAdapter.setPlans(tuesdayPlans);

        wednesdayRecView.setAdapter(wednesdayAdapter);
        wednesdayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        ArrayList<Plan> wednesdayPlans = new ArrayList<>();
        for (Plan plan: Utils.getUsersPlans()){
            if (plan.getDay().equals("Wednesday")) {
                wednesdayPlans.add(plan);
            }
        }
        wednesdayAdapter.setPlans(wednesdayPlans);

        thursdayRecView.setAdapter(thursdayAdapter);
        thursdayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        ArrayList<Plan> thursdayPlans = new ArrayList<>();
        for (Plan plan: Utils.getUsersPlans()){
            if (plan.getDay().equals("Thursday")) {
                thursdayPlans.add(plan);
            }
        }
        thursdayAdapter.setPlans(thursdayPlans);

        fridayRecView.setAdapter(fridayAdapter);
        fridayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        ArrayList<Plan> fridayPlans = new ArrayList<>();
        for (Plan plan: Utils.getUsersPlans()){
            if (plan.getDay().equals("Friday")) {
                fridayPlans.add(plan);
            }
        }
        fridayAdapter.setPlans(fridayPlans);

        saturdayRecView.setAdapter(saturdayAdapter);
        saturdayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        ArrayList<Plan> saturdayPlans = new ArrayList<>();
        for (Plan plan: Utils.getUsersPlans()){
            if (plan.getDay().equals("Saturday")) {
                saturdayPlans.add(plan);
            }
        }
        saturdayAdapter.setPlans(saturdayPlans);

        sundayRecView.setAdapter(sundayAdapter);
        sundayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        ArrayList<Plan> sundayPlans = new ArrayList<>();
        for (Plan plan: Utils.getUsersPlans()){
            if (plan.getDay().equals("Sunday")) {
                sundayPlans.add(plan);
            }
        }
        sundayAdapter.setPlans(sundayPlans);

    }

    private void initViews(){
        Log.d(TAG, "initViews: started");

        mondayRecView = (RecyclerView) findViewById(R.id.mondayRecView);
        tuesdayRecView = (RecyclerView) findViewById(R.id.tuesdayRecView);
        wednesdayRecView = (RecyclerView) findViewById(R.id.wednesdayRecView);
        thursdayRecView = (RecyclerView) findViewById(R.id.thursdayRecView);
        fridayRecView = (RecyclerView) findViewById(R.id.fridayRecView);
        saturdayRecView = (RecyclerView) findViewById(R.id.saturdayRecView);
        sundayRecView = (RecyclerView) findViewById(R.id.sundayRecView);

        notAddedAPlanRelLayout = (RelativeLayout) findViewById(R.id.notAddedAPlanRelLayout);
        btnAddAPlan = (Button) findViewById(R.id.btnAddAPlan);
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        mondayEdit = (TextView) findViewById(R.id.editMondayPlan);
        tuesdayEdit = (TextView) findViewById(R.id.editTuesdayPlan);
        wednesdayEdit = (TextView) findViewById(R.id.editWednesdayPlan);
        thursdayEdit = (TextView) findViewById(R.id.editThursdayPlan);
        fridayEdit = (TextView) findViewById(R.id.editFridayPlan);
        saturdayEdit = (TextView) findViewById(R.id.editSaturdayPlan);
        sundayEdit = (TextView) findViewById(R.id.editSundayPlan);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }
}
