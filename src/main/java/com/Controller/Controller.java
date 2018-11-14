package com.Controller;

import com.Model.ContentProvider;
import com.Model.ObjectImpl.MenuImpl;
import com.Model.ObjectImpl.RestaurantImpl;
import com.Model.ObjectImpl.RestaurantType;
import com.Model.webreader.WebReaderForNaszeMiejsce;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.*;
import java.util.*;
import java.util.List;

import static com.Model.ObjectImpl.RestaurantType.CHMIERLARNIA;
import static com.Model.ObjectImpl.RestaurantType.NASZE_MIEJSCE;
import static com.Model.ObjectImpl.RestaurantType.RESTRO;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/")
    public String listOfItems(Model model) {
        ContentProvider cp = new ContentProvider();
        model.addAttribute("naszemiejsceMenu", cp.getMenuForRestaurant(NASZE_MIEJSCE));
        model.addAttribute("restroMenu", cp.getMenuForRestaurant(RESTRO));
        model.addAttribute("chmielarniaMenu", cp.getMenuForRestaurant(CHMIERLARNIA));
        return "index";
    }
}
