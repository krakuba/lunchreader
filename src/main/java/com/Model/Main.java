package com.Model;

import com.Model.ObjectImpl.MenuImpl;
import com.Model.webreader.WebReaderForNaszeMiejsce;
import com.Model.webreader.WebReaderForRestro;
import org.jetbrains.annotations.NotNull;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        String content = "";
        String baseUrl= "http://www.restro.pl/lunch";
        try {
            Connection connection = Jsoup.connect(baseUrl);
            Document doc = connection.get();
            Elements elements = doc.getElementsByClass("txt-col-content");
            content = elements.text();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        for (String item : processElements(content)){
            System.out.println(processElements(item));
        }

    }

    private static List<String> processElements(String content) {
        List<String> listOfResults = new ArrayList<>();
        String[] props = content.split("zł");
        props[0] = props[0] + props[1];
        props[1] = "";
        int i = 0;
        for(String prop : props){
            if(prop == ""){continue;}
            prop.trim();
            listOfResults.add(props[i]);
            i++;
        }
        return listOfResults;
    }
}
