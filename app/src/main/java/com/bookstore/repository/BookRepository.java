package com.bookstore.repository;

import com.bookstore.exceptions.DuplicateBookException;
import com.bookstore.interfaces.Searchable;
import com.bookstore.models.Textbook;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookRepository implements Searchable {

    private static BookRepository instance;
    private final List<Textbook> listings = new ArrayList<>();

    private BookRepository() {}

    public static BookRepository getInstance() {
        if (instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }

    public void addListing(Textbook book) throws DuplicateBookException {
        if (isDuplicate(book)) {
            throw new DuplicateBookException(book.getTitle());
        }
        listings.add(book);
    }

    private boolean isDuplicate(Textbook newBook) {
        for (Textbook b : listings) {
            if (b.getTitle().equalsIgnoreCase(newBook.getTitle()) &&
                    b.getSellerName().equalsIgnoreCase(newBook.getSellerName()))
                return true;
        }
        return false;
    }

    public List<Textbook> getAllListings() {
        return new ArrayList<>(listings);
    }

    @Override
    public List<Textbook> searchByTitle(String query) {
        List<Textbook> results = new ArrayList<>();
        for (Textbook b : listings) {
            if (b.getTitle().toLowerCase().contains(query.toLowerCase()))
                results.add(b);
        }
        return results;
    }

    @Override
    public List<Textbook> searchBySeller(String query) {
        List<Textbook> results = new ArrayList<>();
        for (Textbook b : listings) {
            if (b.getSellerName().toLowerCase().contains(query.toLowerCase()))
                results.add(b);
        }
        return results;
    }

    public static String generateId() {
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}