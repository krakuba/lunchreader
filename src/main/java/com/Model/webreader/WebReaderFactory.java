package com.Model.webreader;

import com.Model.ObjectImpl.RestaurantType;

public class WebReaderFactory {
    public WebReader getReader(RestaurantType type) {
        switch (type) {
            case NASZE_MIEJSCE:
                return new WebReaderForNaszeMiejsce();
            case RESTRO:
                return new WebReaderForRestro();
            case CHMIERLARNIA:
                return new WebReaderForChmielarnia();
            default:
                //throw new NotImplementedException();
                return null;
        }
    }
}
