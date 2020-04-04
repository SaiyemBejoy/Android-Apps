package com.example.mylibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AllBooksActivity extends AppCompatActivity {

    private static final String TAG = "AllBooksActivity";
    private RecyclerView bookRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        overridePendingTransition(R.anim.in, R.anim.out);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Log.d(TAG, "onCreate: started");

        bookRecView = (RecyclerView) findViewById(R.id.booksRecView);

        BookRecViewAdapter adapter = new BookRecViewAdapter(this);
        bookRecView.setAdapter(adapter);
        //bookRecView.setLayoutManager(new LinearLayoutManager(this)); //single column view
        bookRecView.setLayoutManager(new GridLayoutManager(this, 2)); //2 or more column view


//        books.add(new Book("Chemistry 1st paper", "Hazari", 600, "https://4.bp.blogspot.com/-kFk80vrbgvA/W-MV55MxMrI/AAAAAAAAAtM/snxpuvbQ1LYs2jPCXZHHEm1RFbFOzRfyACLcBGAs/s1600/Intermediate%2BChemistry%2B2nd%2BPaper%2Bby%2BHazari%2Band%2BNag%2B%2528tanbircox%2529.jpg", "Its a poisonous book"));
//        books.add(new Book("Chemistry 2nd paper", "Nag", 800, "https://4.bp.blogspot.com/-kFk80vrbgvA/W-MV55MxMrI/AAAAAAAAAtM/snxpuvbQ1LYs2jPCXZHHEm1RFbFOzRfyACLcBGAs/s1600/Intermediate%2BChemistry%2B2nd%2BPaper%2Bby%2BHazari%2Band%2BNag%2B%2528tanbircox%2529.jpg", "Its another poisonous book"));
//        books.add(new Book("Java Programming", "Deitel", 550, "https://d1w7fb2mkkr3kw.cloudfront.net/assets/images/book/lrg/9780/1338/9780133807806.jpg", "Its a programming learning book"));

        Util util = new Util();
        ArrayList<Book> books = new ArrayList<>();
        books = util.getAllBooks();
        adapter.setBooks(books);
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

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.close_in, R.anim.close_out);
    }
}






















