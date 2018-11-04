package com.Model;

import com.Model.ObjectImpl.MenuImpl;
import com.Model.ObjectImpl.RestaurantImpl;
import com.Model.ObjectImpl.RestaurantType;
import com.Model.webreader.WebReaderForNaszeMiejsce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContentProvider {

    public List<RestaurantImpl> getRestaurantsAndMenu() {
        List<RestaurantImpl> list = new ArrayList<>();
//        list.add(new RestaurantImpl(Arrays.asList(new MenuImpl(RestaurantType.NASZE_MIEJSCE, "opcja nr 1", "21"),
//                                                  new MenuImpl(RestaurantType.NASZE_MIEJSCE, "opcja nr 2", "23"))
//        ));
//        list.add(new RestaurantImpl(Arrays.asList(new MenuImpl(RestaurantType.RESTRO, "opcja nr 1", "11"),
//                                                  new MenuImpl(RestaurantType.RESTRO, "opcja nr 2", "25"))
//        ));
//        List<RestaurantImpl> list = new ArrayList<>();
//        list.add(new RestaurantImpl("value 1"));
//        list.add(new RestaurantImpl("value 2"));
//        list.add(new RestaurantImpl("value 3"));
        WebReaderForNaszeMiejsce reader = new WebReaderForNaszeMiejsce();
        list.add(new RestaurantImpl (reader.getMenuOptions()));
        return list;
    }
}
