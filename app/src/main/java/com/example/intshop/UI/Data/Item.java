package com.example.intshop.UI.Data;

public class Item {
    String itemText;
    public Item(String itemText) {
        super();
        this.itemText = itemText;
    }

    public void setText(String itemText) {
        this.itemText = itemText;
    }

    public String getText() {
        return itemText;
    }
}