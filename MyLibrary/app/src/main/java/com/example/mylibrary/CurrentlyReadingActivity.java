package com.example.mylibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

public class CurrentlyReadingActivity extends AppCompatActivity {

    private static final String TAG = "CurrentlyReadingActivit";

    private RecyclerView recyclerView;

    private BookRecViewAdapter adapter;

    private Util utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currently_reading);

        overridePendingTransition(R.anim.in, R.anim.out);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adapter = new BookRecViewAdapter(this);

        utils = new Util();adapter.setType("currently reading");

        recyclerView = (RecyclerView) findViewById(R.id.recView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        adapter.setBooks(utils.getCurrentlyReadingBooks());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.close_in, R.anim.close_out);
    }
}
