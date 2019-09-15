package com.bhushxxx.villmate;


public class CheckoutModelClass {

    private String category_name, category_price, shop_name ;


    public CheckoutModelClass(String category_name, String shop_name, String category_price) {
        this.category_name = category_name;
        this.shop_name = shop_name;
        this.category_price=category_price;


    }

    public String getCategory_name() {
        return category_name;
    }

    public String getShop_name() {
        return shop_name;
    }

    public String getCategory_price() {
        return category_price;
    }
}