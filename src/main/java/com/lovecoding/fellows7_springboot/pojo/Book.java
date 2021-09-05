package com.lovecoding.fellows7_springboot.pojo;

import java.io.Serializable;

public class Book implements Serializable {

    private String author;

    private String bookName;


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
