package com.Model.ObjectImpl;

import java.util.List;

public class RestaurantImpl {
    public RestaurantType restaurantType;
    public List<MenuImpl> menuOptions;

    public List<MenuImpl> getMenuOptions() {
        return menuOptions;
    }

    public RestaurantImpl(List<MenuImpl> menuOptions) {
        this.menuOptions = menuOptions;
    }

    public RestaurantImpl(RestaurantType restName, List<MenuImpl> menuOptions) {
        this.restaurantType = restName;
        this.menuOptions = menuOptions;
    }
}
