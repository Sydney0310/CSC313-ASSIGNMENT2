package com.bookstore.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.bookstore.R;

public class MainActivity extends AppCompatActivity {

    CardView btnBrowse, btnSell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBrowse = findViewById(R.id.btnBrowse);
        btnSell   = findViewById(R.id.btnSell);

        btnBrowse.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, BrowseActivity.class));
        });

        btnSell.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SellActivity.class));
        });
    }
}
