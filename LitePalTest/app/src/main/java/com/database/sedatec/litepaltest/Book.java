package com.database.sedatec.litepaltest;

import org.litepal.crud.DataSupport;

/**
 * Created by SedateC on 2017/7/23.
 */

public class Book  extends DataSupport{

    private int id ;
    private String author;
    private double price;
    private int pages;
    private String name;
    private String press;

    public Book() {
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public int getPages() {
        return pages;
    }

    public String getName() {
        return name;
    }



    public void setId(int id) {
        this.id = id;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author=" + author +
                ", price=" + price +
                ", pages=" + pages +
                ", name='" + name + '\'' +
                '}';
    }
}
