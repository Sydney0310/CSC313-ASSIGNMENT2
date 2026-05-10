package com.bookstore.abstracts;

public abstract class BaseItem {
    protected String title;

    public BaseItem(String title) {
        this.title = title;
    }

    public String getTitle() { return title; }
    public abstract String getInfo();

    @Override
    public String toString() { return getInfo(); }
}