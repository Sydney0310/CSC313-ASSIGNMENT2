package com.bookstore.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import com.bookstore.R;
import com.bookstore.exceptions.DuplicateBookException;
import com.bookstore.models.Textbook;
import com.bookstore.repository.TextbookRepository;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Populate sample data when app starts
        populateSampleData();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2500);
    }

    private void populateSampleData() {
        TextbookRepository repo = TextbookRepository.getInstance();

        repo.addTextbook(new Textbook(
                "Introduction to Java Programming",
                "Y. Daniel Liang",
                "CSC113",
                "11th Edition",
                3,
                350.00,
                "Orilwela Sadiki",
                "0712345678",
                "FNB",
                "62123456789",
                "Thabo Mokoena"
        ));

        repo.addTextbook(new Textbook(
                "Data Structures and Algorithms",
                "Michael T. Goodrich",
                "CSC213",
                "6th Edition",
                2,
                420.00,
                "Nomsa Dlamini",
                "0823456789",
                "Capitec",
                "1234567890",
                "Nomsa Dlamini"
        ));

        repo.addTextbook(new Textbook(
                "Object-Oriented Programming in Java",
                "David J. Barnes",
                "CSC313",
                "5th Edition",
                1,
                280.00,
                "Sipho Khumalo",
                "0634567890",
                "Absa",
                "4056789012",
                "Sipho Khumalo"
        ));

        repo.addTextbook(new Textbook(
                "Database Management Systems",
                "Ramakrishnan and Gehrke",
                "CSC323",
                "3rd Edition",
                4,
                390.00,
                "Ayanda Nkosi",
                "0745678901",
                "Standard Bank",
                "0012345678",
                "Ayanda Nkosi"
        ));

        repo.addTextbook(new Textbook(
                "Computer Networks",
                "Andrew S. Tanenbaum",
                "CSC423",
                "5th Edition",
                2,
                450.00,
                "Lerato Sithole",
                "0856789012",
                "Nedbank",
                "1987654321",
                "Lerato Sithole"
        ));

    }
}