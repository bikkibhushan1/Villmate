package com.bhushxxx.villmate;


public class ModelClass {

    private int imageResource;
    private String title ;


    public ModelClass(int imageResource, String title) {
        this.imageResource = imageResource;
        this.title = title;


    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }
}