package com.Model;

import com.Model.ObjectImpl.MenuImpl;
import com.Model.ObjectImpl.RestaurantImpl;
import com.Model.ObjectImpl.RestaurantType;
import com.Model.webreader.WebReaderFactory;

import java.util.*;
import java.util.stream.Collectors;

public class ContentProvider {
    private Map<RestaurantType, List<MenuImpl>> restaurantMap = new HashMap<>();

    public List<MenuImpl> getMenuForRestaurant(RestaurantType typeOfPlace) {
        if(restaurantMap.isEmpty()) {
            restaurantMap = getMenuForAllRestaurants();
        }
        return restaurantMap.get(typeOfPlace);
    }

    private Map<RestaurantType, List<MenuImpl>> getMenuForAllRestaurants() {
        Map<RestaurantType, List<MenuImpl>>  restMap = new HashMap<>();
        List<RestaurantImpl> rests = getRestaurantsAndMenu();
        for(RestaurantImpl item : rests){
            if(!restMap.containsKey(item.restaurantType)){
                List<MenuImpl> list = new ArrayList<>();
                list.addAll(item.menuOptions);
                restMap.put(item.restaurantType, list);
            } else {
                restMap.get(item.restaurantType).addAll(item.menuOptions);
            }
        }
        return restMap;
    }

    private List<RestaurantImpl> getRestaurantsAndMenu() {
        WebReaderFactory webReaderFactory = new WebReaderFactory();
        return Arrays.stream(RestaurantType.values())
                .map(restaurant -> new RestaurantImpl(restaurant, webReaderFactory.getReader(restaurant).getMenuOptions())).collect(Collectors.toList());
    }
}
