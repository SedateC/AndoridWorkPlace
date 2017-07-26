package com.database.sedatec.litepaltest;

/**
 * Created by SedateC on 2017/7/23.
 */

public class Category {
    private int id;
    private String categoryName;
    private int categoryCode  ;

    public Category() {
    }

    public int getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }
}
