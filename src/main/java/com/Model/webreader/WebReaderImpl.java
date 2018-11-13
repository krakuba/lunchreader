package com.Model.webreader;

import com.Model.ObjectImpl.MenuImpl;
import com.Model.ObjectImpl.RestaurantType;

import java.util.Arrays;
import java.util.List;

public class WebReaderImpl {
    public List<MenuImpl> getMenuForRestaurant(RestaurantType type){
        WebReader reader = getReader(type);
        if(reader != null) {
            return reader.getMenuOptions();
        }
        System.out.println("There is no reader for giver restaurant type");
        return Arrays.asList();
    }

    private WebReader getReader(RestaurantType type) {
        switch (type) {
            case NASZE_MIEJSCE:
                return new WebReaderForNaszeMiejsce();
//            case RESTRO:
//                return new WebReaderForRestro();
            default:
                return null;
        }
    }
}
