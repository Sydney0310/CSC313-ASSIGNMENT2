package com.bookstore.models;

import com.bookstore.abstracts.BaseItem;

public class Textbook extends BaseItem {

    private String author;
    private String moduleCode;
    private String edition;
    private int numberOfCopies;
    private double price;
    private String sellerName;
    private String contactNumber;
    private String bankName;
    private String accountNumber;
    private String accountHolder;

    public Textbook(String title, String author, String moduleCode,
                    String edition, int numberOfCopies, double price,
                    String sellerName, String contactNumber,
                    String bankName, String accountNumber, String accountHolder) {
        super(title);
        this.author = author;
        this.moduleCode = moduleCode;
        this.edition = edition;
        this.numberOfCopies = numberOfCopies;
        this.price = price;
        this.sellerName = sellerName;
        this.contactNumber = contactNumber;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
    }

    @Override
    public String getInfo() {
        return title + " by " + author + " - R" + String.format("%.2f", price);
    }

    // All your existing getters stay exactly the same
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getModuleCode() { return moduleCode; }
    public String getEdition() { return edition; }
    public int getNumberOfCopies() { return numberOfCopies; }
    public double getPrice() { return price; }
    public String getSellerName() { return sellerName; }
    public String getContactNumber() { return contactNumber; }
    public String getBankName() { return bankName; }
    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolder() { return accountHolder; }

    // All your existing setters stay exactly the same
    public void setAuthor(String author) { this.author = author; }
    public void setModuleCode(String moduleCode) { this.moduleCode = moduleCode; }
    public void setEdition(String edition) { this.edition = edition; }
    public void setNumberOfCopies(int numberOfCopies) { this.numberOfCopies = numberOfCopies; }
    public void setPrice(double price) { this.price = price; }
    public void setSellerName(String sellerName) { this.sellerName = sellerName; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public void setBankName(String bankName) { this.bankName = bankName; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public void setAccountHolder(String accountHolder) { this.accountHolder = accountHolder; }

    @Override
    public String toString() { return getInfo(); }
}