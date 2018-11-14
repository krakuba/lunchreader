package com.Model.webreader;

import com.Model.ObjectImpl.MenuImpl;
import com.Model.ObjectImpl.RestaurantType;
import org.jetbrains.annotations.NotNull;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

public class WebReaderForNaszeMiejsce extends WebReaderImpl implements WebReader {
    private static final String baseUrl= "https://naszemiejscerestauracja.pl/lunch/";
    private final RestaurantType restaurantType = RestaurantType.NASZE_MIEJSCE;

    @Override
    public List<MenuImpl> getMenuOptions() {
        List<MenuImpl> list = new ArrayList<>();
        for(String prop : read()){
            list.add(new MenuImpl(restaurantType, getDescFromProp(prop), getPriceFromProp(prop)));
        }
        return list;
    }

    private List<String> read() {
        String content = "";
        try {
            Connection connection = Jsoup.connect(baseUrl);
            Document doc = connection.get();
            Elements elements = doc.getElementsByClass("entry");
            content = elements.text();
        } catch (ConnectException ex) {
            System.out.println("Could not connect");
        } catch (Exception ex) {
            System.out.println("Could not read page");
        }
        return processElements(content);
    }

    private String getDescFromProp(@NotNull String prop) {
        try {
            String desc = prop.substring(3).trim();
            int i = desc.lastIndexOf(".");
            String text = desc.trim().substring(0, i+1);
            return removeEmptySpaceBeforeDotsAndCommas(text);
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String getPriceFromProp(@NotNull String prop) {
        try {
            String txt = prop.trim().substring(3);
            int i = txt.indexOf("2");
            return txt.substring(i, i+5);
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return "";
    }

    private List<String> processElements(@NotNull String content) {
        List<String> listOfResults = new ArrayList<>();
        String[] props = content.split("Propozycja");
        int i = 0;
        for(String prop : props){
            listOfResults.add(props[i]);
            i++;
        }
        listOfResults.remove(0);
        return listOfResults;
    }
}
