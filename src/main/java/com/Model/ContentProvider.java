package com.Model;

import com.Model.ObjectImpl.RestaurantImpl;
import com.Model.ObjectImpl.RestaurantType;
import com.Model.webreader.WebReaderFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ContentProvider {
    public List<RestaurantImpl> getRestaurantsAndMenu() {
        WebReaderFactory webReaderFactory = new WebReaderFactory();
        return Arrays.stream(RestaurantType.values())
                .map(restaurant -> new RestaurantImpl(restaurant, webReaderFactory.getReader(restaurant).getMenuOptions())).collect(Collectors.toList());
    }
}
