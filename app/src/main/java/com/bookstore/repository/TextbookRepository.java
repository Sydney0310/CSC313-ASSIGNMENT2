// TextbookRepository - Implemented by Okuhlegenge
// Manages all textbook listings with duplicate prevention and search functionality
package com.bookstore.repository;

import com.bookstore.exceptions.DuplicateBookException;
import com.bookstore.interfaces.Searchable;
import com.bookstore.models.Textbook;
import java.util.ArrayList;
import java.util.List;

public class TextbookRepository implements Searchable {

    private static TextbookRepository instance;
    private final List<Textbook> textbooks = new ArrayList<>();

    private TextbookRepository() {}

    public static TextbookRepository getInstance() {
        if (instance == null) instance = new TextbookRepository();
        return instance;
    }

    public boolean addTextbook(Textbook textbook) {
        try {
            if (isDuplicate(textbook)) {
                throw new DuplicateBookException(textbook.getTitle());
            }
            textbooks.add(textbook);
            return true;
        } catch (DuplicateBookException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean isDuplicate(Textbook newBook) {
        for (Textbook b : textbooks) {
            if (b.getTitle().equalsIgnoreCase(newBook.getTitle()) &&
                    b.getSellerName().equalsIgnoreCase(newBook.getSellerName()))
                return true;
        }
        return false;
    }

    public List<Textbook> getAllTextbooks() {
        return new ArrayList<>(textbooks);
    }

    // Combined search — searches both title and seller at once
    public List<Textbook> search(String query) {
        List<Textbook> results = new ArrayList<>();
        for (Textbook b : textbooks) {
            if (b.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    b.getSellerName().toLowerCase().contains(query.toLowerCase())) {
                results.add(b);
            }
        }
        return results;
    }

    @Override
    public List<Textbook> searchByTitle(String query) {
        List<Textbook> results = new ArrayList<>();
        for (Textbook b : textbooks) {
            if (b.getTitle().toLowerCase().contains(query.toLowerCase()))
                results.add(b);
        }
        return results;
    }

    @Override
    public List<Textbook> searchBySeller(String query) {
        List<Textbook> results = new ArrayList<>();
        for (Textbook b : textbooks) {
            if (b.getSellerName().toLowerCase().contains(query.toLowerCase()))
                results.add(b);
        }
        return results;
    }
}