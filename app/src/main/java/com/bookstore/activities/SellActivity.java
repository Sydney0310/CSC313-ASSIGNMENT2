package com.bookstore.activities;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.bookstore.R;
import com.bookstore.listings.TextbookListing;
import com.bookstore.models.Textbook;
import com.bookstore.repository.TextbookRepository;

public class SellActivity extends AppCompatActivity {


    EditText etTitle, etAuthor, etModuleCode, etEdition;
    EditText etCopies, etPrice;
    EditText etSellerName, etContactNumber;
    EditText etBankName, etAccountNumber, etAccountHolder;
    CardView btnSubmit;
    TextView btnBack;

    TextbookRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);


        etTitle         = findViewById(R.id.etTitle);
        etAuthor        = findViewById(R.id.etAuthor);
        etModuleCode    = findViewById(R.id.etModuleCode);
        etEdition       = findViewById(R.id.etEdition);
        etCopies        = findViewById(R.id.etCopies);
        etPrice         = findViewById(R.id.etPrice);
        etSellerName    = findViewById(R.id.etSellerName);
        etContactNumber = findViewById(R.id.etContactNumber);
        etBankName      = findViewById(R.id.etBankName);
        etAccountNumber = findViewById(R.id.etAccountNumber);
        etAccountHolder = findViewById(R.id.etAccountHolder);
        btnSubmit       = findViewById(R.id.btnSubmit);
        btnBack         = findViewById(R.id.btnBack);


        repository = TextbookRepository.getInstance();


        btnBack.setOnClickListener(v -> finish());


        btnSubmit.setOnClickListener(v -> submitListing());
    }

    private void submitListing() {

        try {
            String title         = etTitle.getText().toString().trim();
            String author        = etAuthor.getText().toString().trim();
            String moduleCode    = etModuleCode.getText().toString().trim();
            String edition       = etEdition.getText().toString().trim();
            String copiesStr     = etCopies.getText().toString().trim();
            String priceStr      = etPrice.getText().toString().trim();
            String sellerName    = etSellerName.getText().toString().trim();
            String contactNumber = etContactNumber.getText().toString().trim();
            String bankName      = etBankName.getText().toString().trim();
            String accountNumber = etAccountNumber.getText().toString().trim();
            String accountHolder = etAccountHolder.getText().toString().trim();


            if (title.isEmpty() || author.isEmpty() || moduleCode.isEmpty()
                    || copiesStr.isEmpty() || priceStr.isEmpty()
                    || sellerName.isEmpty() || contactNumber.isEmpty()
                    || bankName.isEmpty() || accountNumber.isEmpty()
                    || accountHolder.isEmpty()) {
                showErrorDialog("Please fill in all required fields marked with *");
                return;
            }


            int copies;
            double price;
            try {
                copies = Integer.parseInt(copiesStr);
                price  = Double.parseDouble(priceStr);

                if (copies <= 0) {
                    showErrorDialog("Number of copies must be greater than 0");
                    return;
                }
                if (price <= 0) {
                    showErrorDialog("Price must be greater than R0");
                    return;
                }

            } catch (NumberFormatException e) {
                showErrorDialog("Please enter valid numbers for copies and price");
                return;
            }


            Textbook textbook = new Textbook(
                    title, author, moduleCode, edition,
                    copies, price, sellerName, contactNumber,
                    bankName, accountNumber, accountHolder
            );


            TextbookListing listing = new TextbookListing(textbook);
            listing.listItem();


            boolean added = repository.addTextbook(textbook);

            if (added) {
                showSuccessDialog();
            } else {

                showErrorDialog("This textbook is already listed by you!\n\n" +
                        "A listing for \"" + title + "\" by " +
                        sellerName + " already exists.");
            }

        } catch (Exception e) {
            showErrorDialog("Something went wrong: " + e.getMessage());
        }
    }


    private void clearForm() {
        etTitle.setText("");
        etAuthor.setText("");
        etModuleCode.setText("");
        etEdition.setText("");
        etCopies.setText("");
        etPrice.setText("");
        etSellerName.setText("");
        etContactNumber.setText("");
        etBankName.setText("");
        etAccountNumber.setText("");
        etAccountHolder.setText("");
        etTitle.requestFocus();
    }


    private void showSuccessDialog() {
        new AlertDialog.Builder(this)
                .setTitle("✅ Book Listed!")
                .setMessage("Your textbook has been listed successfully!\n\n" +
                        "Buyers can now find your book in the Browse section.")
                .setPositiveButton("List Another Book", (dialog, which) -> {
                    clearForm();
                })
                .setNegativeButton("Go Back", (dialog, which) -> {
                    finish();
                })
                .setCancelable(false)
                .show();
    }


    private void showErrorDialog(String message) {
        new AlertDialog.Builder(this)
                .setTitle("⚠️ Error")
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show();
    }
}