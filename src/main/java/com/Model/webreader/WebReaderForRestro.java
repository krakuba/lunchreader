package com.Model.webreader;

import com.Model.ObjectImpl.MenuImpl;
import com.Model.ObjectImpl.RestaurantType;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebReaderForRestro implements WebReader {
    private static final String baseUrl= "http://www.restro.pl/lunch";
    private final RestaurantType restName = RestaurantType.RESTRO;

    @Override
    public List<MenuImpl> getMenuOptions() {
        List<MenuImpl> list = new ArrayList<>();
        for(String prop : read()){
            list.add(new MenuImpl(restName, getDescFromProp(prop), getPriceFromProp(prop)));
        }
        return list;
    }

    private List<String> read() {
        String content = "";
        try {
            Connection connection = Jsoup.connect(baseUrl);
            Document doc = connection.get();
            Elements elements = doc.getElementsByClass("txt-col-content");
            content = elements.text();
        } catch (ConnectException ex) {
            System.out.println("Could not connect");
        } catch (Exception ex) {
            System.out.println("Could not read page");
        }
        return Arrays.asList(content);//processElements(content);
    }

    private String getDescFromProp(String prop) {
        try {
            String desc = prop.substring(3).trim();
            int i = desc.lastIndexOf(".");
            return desc.trim().substring(0, i+1);
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String getPriceFromProp(String prop) {
        try {
            String txt = prop.trim().substring(3);
            int i = txt.indexOf("2");
            return txt.substring(i, i+5);
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return "";
    }

    private List<String> processElements(String content) {
        ArrayList<String> listOfResults = new ArrayList<>();
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
