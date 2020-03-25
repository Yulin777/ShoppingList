package com.yaara.shoppinglist.entities;

/**
 * Created by Yulin. I on 25,March,2020
 */
public class Product {
    public String name;
    public int amount;
    public String size;
    public String comment;

    public Product(String name, int amount, String size, String comment) {
        this.name = name;
        this.amount = amount;
        this.size = size;
        this.comment = comment;
    }

    public Product() {
    }
}
