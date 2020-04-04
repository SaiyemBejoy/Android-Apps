package com.example.mylibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Button btnSeeAll, btnCurrentlyReading, btnWantToRead, btnAlreadyRead, btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        overridePendingTransition(R.anim.in, R.anim.out);

        initWidgets();
        setOnClickListner();

    }

    private void setOnClickListner() {
        btnSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllBooksActivity.class);
                startActivity(intent);
            }
        });

        btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlreadyReadActivity.class);
                startActivity(intent);
            }
        });

        btnWantToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WantToActivity.class);
                startActivity(intent);
            }
        });

        btnCurrentlyReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CurrentlyReadingActivity.class);
                startActivity(intent);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutTapped();
            }
        });
    }

    private void aboutTapped() {
        Log.d(TAG, "aboutTapped: started");

        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("About My Library App")
                .setMessage("Build by Md Jannatus Saiyem" +
                        "\nBSc in CSE" +
                        "\nEmail: jannatus15-836@diu.edu.bd" +
                        "Portfolio: https://sites.google.com/view/mjsaiyem")
                .setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this, MyWebViewActivity.class);
                        intent.putExtra("url", "https://sites.google.com/view/mjsaiyem");
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        //builder.setCancelable(true);
        builder.create().show();
    }


    private void initWidgets() {
        btnSeeAll = (Button) findViewById(R.id.btnAllBooks);
        btnCurrentlyReading = (Button) findViewById(R.id.btnCurrent);
        btnWantToRead = (Button) findViewById(R.id.btnWantTo);
        btnAlreadyRead = (Button) findViewById(R.id.btnAlreadyRead);
        btnAbout = (Button) findViewById(R.id.btnAbout);
    }

//    @Override
//    public void finish() {
//        super.finish();
//        overridePendingTransition(R.anim.close_in, R.anim.close_out);
//    }
}
