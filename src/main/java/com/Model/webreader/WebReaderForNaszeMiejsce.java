package com.Model.webreader;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class WebReaderForNaszeMiejsce implements WebReader {
    private static final String baseUrl= "https://naszemiejscerestauracja.pl/lunch/";
    @Override
    public List<String> read () {
        String content = "";
        try {
            Connection connection = Jsoup.connect(baseUrl);
            Document doc = connection.get();
            Elements elements = doc.getElementsByClass("entry");
            content = elements.text();
        } catch (Exception ex) {}
        return processElements(content);
    }

    public List<String> processElements(String content) {
        ArrayList<String> listOfResults = new ArrayList<>();
        String[] props = content.split("Propozycja");
        int i = 0;
        for(String prop : props){
            listOfResults.add(props[i]);
            i++;
        }
        return listOfResults;
    }
}
