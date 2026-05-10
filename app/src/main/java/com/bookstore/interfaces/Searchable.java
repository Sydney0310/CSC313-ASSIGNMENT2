package com.bookstore.interfaces;

import com.bookstore.models.Textbook;
import java.util.List;

public interface Searchable {
    List<Textbook> searchByTitle(String query);
    List<Textbook> searchBySeller(String query);
}