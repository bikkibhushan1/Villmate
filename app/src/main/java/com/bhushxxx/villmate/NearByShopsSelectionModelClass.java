package com.bhushxxx.villmate;


public class NearByShopsSelectionModelClass {

    private int shop_image;
    private String shop_name, category_price, shop_distance ;


    public NearByShopsSelectionModelClass(int shop_image, String shop_name, String category_price, String shop_distance) {
        this.shop_image = shop_image;
        this.shop_name = shop_name;
        this.category_price=category_price;
        this.shop_distance = shop_distance;


    }

    public int getShop_image() {
        return shop_image;
    }

    public String getShop_name() {
        return shop_name;
    }

    public String getCategory_price() {
        return category_price;
    }

    public String getShop_distance() {
        return shop_distance;
    }


}