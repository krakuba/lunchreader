package com.Model.webreader;

import com.Model.ObjectImpl.RestaurantType;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class WebReaderFactory {
    public WebReader getReader(RestaurantType type) {
        switch (type) {
            case NASZE_MIEJSCE:
                return new WebReaderForNaszeMiejsce();
            case RESTRO:
                return new WebReaderForRestro();
            default:
                throw new NotImplementedException();
        }
    }
}
