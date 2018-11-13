package com.Controller;

import com.Model.ContentProvider;
import com.Model.ObjectImpl.MenuImpl;
import com.Model.ObjectImpl.RestaurantImpl;
import com.Model.ObjectImpl.RestaurantType;
import com.Model.webreader.WebReaderForNaszeMiejsce;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

import static com.Model.ObjectImpl.RestaurantType.NASZE_MIEJSCE;
import static com.Model.ObjectImpl.RestaurantType.RESTRO;

@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping("/")
    public String listOfItems(Model model) {
        ContentProvider cp = new ContentProvider();
        List<MenuImpl> items = getListOfOptions(cp, NASZE_MIEJSCE);
        model.addAttribute("naszemiejsceMenu", items);
        //model.addAttribute("restroMenu", getListOfOptions(cp, RESTRO));
        return "test";
    }

    private List<MenuImpl> getListOfOptions(ContentProvider cp, RestaurantType typeOfPlace) {
        List<MenuImpl> listOfItemsMenu = new ArrayList<>();
        List<RestaurantImpl> rests = cp.getRestaurantsAndMenu();
        for(RestaurantImpl item : rests){
            for(MenuImpl menu : item.menuOptions){
                if(menu.getName().equals(typeOfPlace)) {
                    listOfItemsMenu.add(menu);
                }
            }
        }
        return listOfItemsMenu;
    }
}
