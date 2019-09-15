package com.bhushxxx.villmate;

public class CategoryBrandModelClass {

    private String brand_name, brand_price ;
    private int brand_image;



    public CategoryBrandModelClass( int brand_image, String brand_name, String brand_price) {
        this.brand_name = brand_name;
        this.brand_price = brand_price;
        this.brand_image = brand_image;


    }

    public int getBrand_image() {
        return brand_image;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public String getBrand_price() {
        return brand_price;
    }


}
