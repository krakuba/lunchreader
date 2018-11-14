package com.Model.webreader;

import com.Model.ObjectImpl.MenuImpl;
import com.Model.ObjectImpl.RestaurantType;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class WebReaderForRestro implements WebReader {
    private static final String baseUrl= "http://www.restro.pl/lunch";
    private final RestaurantType restaurantType = RestaurantType.RESTRO;

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
        List<String> listOfResults = new ArrayList<>();
        try {
            Connection connection = Jsoup.connect(baseUrl);
            Document doc = connection.get();
            Elements elements = doc.getElementsByClass("txt-col-content");

            for (Element item : elements){
                listOfResults.add(item.text());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        listOfResults.remove(listOfResults.size() - 1);
        //return processElements(listOfResults);
        return listOfResults;
    }

    private String getDescFromProp(String prop) {
        try {
            String desc = prop.trim().replaceAll(",00", "").substring(5);
            int i = desc.lastIndexOf(".");
            return desc.trim();
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String getPriceFromProp(String prop) {
        try {
            return prop.trim().replaceAll(",00", "").substring(0, 5);
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return "";
    }

    private List<String> processElements(List<String> contentList) {
        ArrayList<String> listOfResults = new ArrayList<>();
//        for(String content : contentList){
//            content.replaceAll("\\s+(?=[****])", ".");
//        }
        return listOfResults;
    }
}
