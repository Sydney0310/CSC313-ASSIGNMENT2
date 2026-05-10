package com.bookstore.activities;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bookstore.R;

public class BookDetailActivity extends AppCompatActivity {

    TextView tvDetailTitle, tvDetailAuthor, tvDetailPrice,
            tvDetailModuleCode, tvDetailEdition, tvDetailCopies,
            tvDetailSeller, tvDetailContact, tvDetailBank, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        // Match the new XML IDs exactly
        tvDetailTitle      = findViewById(R.id.tvDetailTitle);
        tvDetailAuthor     = findViewById(R.id.tvDetailAuthor);
        tvDetailPrice      = findViewById(R.id.tvDetailPrice);
        tvDetailModuleCode = findViewById(R.id.tvDetailModuleCode);
        tvDetailEdition    = findViewById(R.id.tvDetailEdition);
        tvDetailCopies     = findViewById(R.id.tvDetailCopies);
        tvDetailSeller     = findViewById(R.id.tvDetailSeller);
        tvDetailContact    = findViewById(R.id.tvDetailContact);
        tvDetailBank       = findViewById(R.id.tvDetailBank);
        btnBack            = findViewById(R.id.btnBack);

        Bundle data = getIntent().getExtras();

        if (data != null) {
            String title         = data.getString("title");
            String author        = data.getString("author");
            String moduleCode    = data.getString("moduleCode");
            String edition       = data.getString("edition");
            int    copies        = data.getInt("copies");
            double price         = data.getDouble("price");
            String sellerName    = data.getString("sellerName");
            String contactNumber = data.getString("contactNumber");
            String bankName      = data.getString("bankName");
            String accountNumber = data.getString("accountNumber");
            String accountHolder = data.getString("accountHolder");

            tvDetailTitle.setText(title);
            tvDetailAuthor.setText("By " + author);
            tvDetailPrice.setText("R " + String.format("%.2f", price));
            tvDetailModuleCode.setText(moduleCode);
            tvDetailEdition.setText(
                    edition == null || edition.isEmpty() ? "Not specified" : edition);
            tvDetailCopies.setText(copies + " cop" +
                    (copies == 1 ? "y" : "ies") + " available");
            tvDetailSeller.setText(sellerName);
            tvDetailContact.setText(contactNumber);

            // Formatted banking info in one block
            tvDetailBank.setText(
                    "Bank: "    + bankName      + "\n" +
                            "Acc No: "  + accountNumber + "\n" +
                            "Holder: "  + accountHolder
            );
        }

        btnBack.setOnClickListener(v -> finish());
    }
}