package com.example.mylibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    private static final String TAG = "BookActivity";

    private TextView bookName, authorName, description, pages;
    private ImageView bookImage;
    private Button btnCurReading, btnWantToRead, btnAlreadyRead;
    private Book incomingBook;
    private Util util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        overridePendingTransition(R.anim.in, R.anim.out);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initWidgets();

        Intent intent = getIntent();
        int id = intent.getIntExtra("bookId", 0);
        util = new Util();
        ArrayList<Book> books = util.getAllBooks();
        for (Book b : books) {
            if (b.getId() == id) {

                incomingBook = b;

                bookName.setText(b.getName());
                authorName.setText(b.getAuthor());
                description.setText(b.getDescription());
                pages.setText("Pages: " + b.getPages());

                Glide.with(this)
                        .asBitmap()
                        .load(b.getImageUrl())
                        .into(bookImage);
            }
        }

        btnCurReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnCurReadingTapped();
            }
        });

        btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAlreadyReadTapped();
            }
        });

        btnWantToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnWantToReadTapped();
            }
        });

    }

    private void initWidgets() {
        bookName = (TextView) findViewById(R.id.bookName);
        authorName = (TextView) findViewById(R.id.authorName);
        description = (TextView) findViewById(R.id.bookDesc);
        pages = (TextView) findViewById(R.id.bookPages);

        bookImage = (ImageView) findViewById(R.id.bookImage);

        btnCurReading = (Button) findViewById(R.id.btnCurReading);
        btnWantToRead = (Button) findViewById(R.id.btnWantToRead);
        btnAlreadyRead = (Button) findViewById(R.id.btnAlreadyRead);
    }

    private void btnCurReadingTapped() {
        Log.d(TAG, "btnCurReadingTapped: started");

        //boolean doesExist = false;

        ArrayList<Book> currentlyReadingBooks = util.getCurrentlyReadingBooks();
//        for (Book book: currentlyReadingBooks){
//            if (book.getId() == incomingBook.getId()){
//                doesExist = true;
//            }
//        }

        if (currentlyReadingBooks.contains(incomingBook)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You already added this book to your currently reading list");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setCancelable(true);

            builder.create().show();
        } else {

            ArrayList<Book> wantToReadBooks = util.getWantToReadBooks();

            if (wantToReadBooks.contains(incomingBook)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Are you going to start reading this book?");
                builder.setTitle("Error");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        util.removeWantToReadBook(incomingBook);
                        util.addCurrentlyReadingBook(incomingBook);
                        Toast.makeText(BookActivity.this, "The book " + incomingBook.getName() + " added to your currently reading shelf", Toast.LENGTH_LONG).show();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                //builder.setCancelable(true);

                builder.create().show();
            } else {

                ArrayList<Book> alreadyReadBooks = util.getAlreadyReadBooks();

                if (alreadyReadBooks.contains(incomingBook)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Do you want to read it again?");
                    builder.setTitle("Error");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //util.removeAlreadyReadBook(incomingBook);
                            util.addCurrentlyReadingBook(incomingBook);
                            Toast.makeText(BookActivity.this, "The book " + incomingBook.getName() + " added to your currently reading shelf", Toast.LENGTH_LONG).show();
                        }
                    });

                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    //builder.setCancelable(true);

                    builder.create().show();
                } else {

                    util.addCurrentlyReadingBook(incomingBook);
                    Toast.makeText(this, "The book " + incomingBook.getName() + " added to your currently reading shelf", Toast.LENGTH_LONG).show();
                }
            }

        }
    }


    private void btnAlreadyReadTapped() {
        Log.d(TAG, "btnAlreadyReadTapped: started");

        //boolean doesExist = false;

        ArrayList<Book> alreadyReadBooks = util.getAlreadyReadBooks();
//        for (Book book: alreadyReadBooks){
//            if (book.getId() == incomingBook.getId()){
//                doesExist = true;
//            }
//        }

        if (alreadyReadBooks.contains(incomingBook)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You already added this book to your already read list");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setCancelable(true);

            builder.create().show();
        } else {

            ArrayList<Book> currentlyReadingBooks = util.getCurrentlyReadingBooks();

            if (currentlyReadingBooks.contains(incomingBook)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Have you finished reading this book?");
                builder.setTitle("Error");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        util.removeCurrentlyReadingBook(incomingBook);
                        util.addAlreadyReadBook(incomingBook);
                        Toast.makeText(BookActivity.this, "The book " + incomingBook.getName() + " added to your already read shelf", Toast.LENGTH_LONG).show();
                    }
                });

                builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                //builder.setCancelable(true);

                builder.create().show();
            } else {
                util.addAlreadyReadBook(incomingBook);
                Toast.makeText(this, "The book " + incomingBook.getName() + " added to your already read shelf", Toast.LENGTH_LONG).show();
            }

        }
    }


    private void btnWantToReadTapped() {
        Log.d(TAG, "btnWantToReadTapped: started");

        //boolean doesExist = false;

        ArrayList<Book> wantToReadBooks = util.getWantToReadBooks();
//        for (Book book: wantToReadBooks){
//            if (book.getId() == incomingBook.getId()){
//                doesExist = true;
//            }
//        }

        if (wantToReadBooks.contains(incomingBook)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You already added this book to your want to read  list");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setCancelable(true);

            builder.create().show();
        } else {
            ArrayList<Book> alreadyReadBooks = util.getAlreadyReadBooks();
            if (alreadyReadBooks.contains(incomingBook)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("You already read this book");
                builder.setTitle("Error");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.setCancelable(true);

                builder.create().show();
            } else {
                ArrayList<Book> currentlyReadingBook = util.getCurrentlyReadingBooks();
                if (currentlyReadingBook.contains(incomingBook)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("You are already reading this book");
                    builder.setTitle("Error");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    builder.setCancelable(true);

                    builder.create().show();
                } else {
                    util.addWantToReadBook(incomingBook);
                    Toast.makeText(this, "The book " + incomingBook.getName() + " added to your want to read shelf", Toast.LENGTH_LONG).show();
                }
            }

        }
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
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
