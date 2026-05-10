package com.bookstore.activities;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bookstore.R;
import com.bookstore.adapters.TextbookAdapter;
import com.bookstore.models.Textbook;
import com.bookstore.repository.TextbookRepository;
import java.util.List;

public class BrowseActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextbookAdapter adapter;
    EditText etSearch;
    TextView tvResultCount, btnBack;
    LinearLayout emptyState;
    TextbookRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);


        recyclerView    = findViewById(R.id.recyclerView);
        etSearch        = findViewById(R.id.etSearch);
        tvResultCount   = findViewById(R.id.tvResultCount);
        emptyState      = findViewById(R.id.emptyState);
        btnBack         = findViewById(R.id.btnBack);


        repository = TextbookRepository.getInstance();


        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        loadBooks(repository.getAllTextbooks());


        btnBack.setOnClickListener(v -> finish());

        // Search functionality
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                String query = s.toString().trim();
                if (query.isEmpty()) {
                    loadBooks(repository.getAllTextbooks());
                } else {
                    loadBooks(repository.search(query));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }


    private void loadBooks(List<Textbook> books) {
        if (books.isEmpty()) {
            recyclerView.setVisibility(View.GONE);
            emptyState.setVisibility(View.VISIBLE);
            tvResultCount.setText("No results found");
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            emptyState.setVisibility(View.GONE);
            tvResultCount.setText(books.size() + " textbook" +
                    (books.size() == 1 ? "" : "s") + " available");

            if (adapter == null) {
                adapter = new TextbookAdapter(this, books);
                recyclerView.setAdapter(adapter);
            } else {
                adapter.updateList(books);
            }
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        String query = etSearch.getText().toString().trim();
        if (query.isEmpty()) {
            loadBooks(repository.getAllTextbooks());
        } else {
            loadBooks(repository.search(query));
        }
    }
}