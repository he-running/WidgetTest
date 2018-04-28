package com.example.widgettest.recyclerview;

import java.io.Serializable;

/**
 * Created by hesh on 2018/4/17.
 */

public class Book implements Serializable{

    private int img;
    private String name;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "img=" + img +
                ", name='" + name + '\'' +
                '}';
    }
}
