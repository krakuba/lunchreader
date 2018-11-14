package com.Model.webreader;

import com.Model.ObjectImpl.MenuImpl;
import com.Model.ObjectImpl.RestaurantType;
import org.jetbrains.annotations.NotNull;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class WebReaderForChmielarnia implements WebReader {
    private static final String baseUrl= "http://chmielarnia.pl/twarda/lunch/";
    private final RestaurantType restaurantType = RestaurantType.CHMIERLARNIA;

    @Override
    public List<MenuImpl> getMenuOptions() {
        List<MenuImpl> list = new ArrayList<>();
        List<String> readResult = read();
        for(String prop : readResult){
            list.add(new MenuImpl(restaurantType, getDescFromProp(prop), getPriceFromProp(prop)));
        }
        return list;
    }

    private List<String> read() {
        String content = "";
        try {
            Connection connection = Jsoup.connect(baseUrl);
            Document doc = connection.get();
            content = doc.select("span.big > p").toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return processElements(content);
    }

    @NotNull
    private String getDescFromProp(String prop) {
        String firstLetterLowerCase = prop.substring(0,1).toLowerCase();
        String propToLower = prop.trim().toLowerCase();
        String result = propToLower.replaceFirst(firstLetterLowerCase, firstLetterLowerCase.toUpperCase());
        return result;
    }

    @NotNull
    private String getPriceFromProp(String prop) {
        prop = prop.toLowerCase();
        if(prop.contains("kurczak")){ return "21 zł"; }
        if(prop.contains("warzywa")){ return "19 zł"; }
        return "26 zł";
    }

    private List<String> processElements(@NotNull String content) {
        ArrayList<String> listOfResults = new ArrayList<>();
        String[] items = content.split("<br>");
        for(String item : items){
            listOfResults.add(item.replaceAll("<p>", "").replaceAll("</p>", ""));
        }
        return listOfResults;
    }
}
