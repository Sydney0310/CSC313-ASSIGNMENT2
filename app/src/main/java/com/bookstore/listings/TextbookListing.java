package com.bookstore.listings;

import com.bookstore.interfaces.IPayable;
import com.bookstore.interfaces.Listable;
import com.bookstore.models.Textbook;

public class TextbookListing implements Listable, IPayable {

    private Textbook textbook;

    public TextbookListing(Textbook textbook) {
        this.textbook = textbook;
    }

    @Override
    public boolean validate() {
        return textbook != null
                && textbook.getTitle() != null && !textbook.getTitle().isEmpty()
                && textbook.getPrice() > 0
                && textbook.getNumberOfCopies() > 0
                && textbook.getSellerName() != null && !textbook.getSellerName().isEmpty();
    }

    @Override
    public void listItem() {
        if (validate()) {
            System.out.println("Listing: " + textbook.getTitle()
                    + " by " + textbook.getSellerName()
                    + " at R" + textbook.getPrice());
        }
    }

    @Override
    public String getBankInfo() {
        return "Bank: " + textbook.getBankName()
                + "\nAcc No: " + textbook.getAccountNumber()
                + "\nHolder: " + textbook.getAccountHolder();
    }

    public Textbook getTextbook() { return textbook; }
}