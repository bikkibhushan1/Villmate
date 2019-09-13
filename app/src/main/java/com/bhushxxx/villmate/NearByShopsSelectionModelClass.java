package com.bhushxxx.villmate;


public class NearByShopsSelectionModelClass {

    private int imageResource;
    private String title, category_price ;


    public NearByShopsSelectionModelClass(int imageResource, String title, String category_price) {
        this.imageResource = imageResource;
        this.title = title;
        this.category_price=category_price;


    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory_price() {
        return category_price;
    }
}