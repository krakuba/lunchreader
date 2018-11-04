package com.Model.ObjectImpl;

public class MenuImpl {
    private RestaurantType name;
    private String option;
    private String price;

    public MenuImpl(RestaurantType restaurantName, String option, String price) {
        this.name = restaurantName;
        this.option = option;
        this.price = price;
    }

    public RestaurantType getName() {
        return name;
    }

    public String getOption() {
        return option;
    }

    public String getPrice() {
        return price;
    }
}
