package com.bookstore.abstracts;

import com.bookstore.interfaces.Listable;
import com.bookstore.models.Textbook;


public abstract class AbstractListing implements Listable {

    protected Textbook textbook;

    public AbstractListing(Textbook textbook) {
        this.textbook = textbook;
    }

    public Textbook getTextbook() {
        return textbook;
    }


    public abstract String getSummary();


    @Override
    public void listItem() {
        System.out.println("Listing: " + getSummary());
    }
}