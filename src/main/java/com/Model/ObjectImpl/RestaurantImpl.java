package com.Model.ObjectImpl;

import java.util.List;

public class RestaurantImpl {
    public List<MenuImpl> menuOptions;

    public List<MenuImpl> getMenuOptions() {
        return menuOptions;
    }

    public RestaurantImpl(List<MenuImpl> menuOptions) {
        this.menuOptions = menuOptions;
    }
}
