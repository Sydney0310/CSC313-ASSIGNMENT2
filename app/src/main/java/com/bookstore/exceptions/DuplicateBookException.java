package com.bookstore.exceptions;

public class DuplicateBookException extends Exception {
    public DuplicateBookException(String bookTitle) {
        super("\"" + bookTitle + "\" is already listed.");
    }
}