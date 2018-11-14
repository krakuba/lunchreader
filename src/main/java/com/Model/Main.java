package com.Model;

import com.Model.ObjectImpl.MenuImpl;
import com.Model.webreader.WebReaderForNaszeMiejsce;
import com.Model.webreader.WebReaderForRestro;
import org.jetbrains.annotations.NotNull;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        String test = "27,00 zł Zupa ze słodkiej kapusty";
        System.out.println(test.trim().replaceAll(",00", "").substring(0, 5));
//        String baseUrl= "http://www.restro.pl/lunch";
//        try {
//            Connection connection = Jsoup.connect(baseUrl);
//            Document doc = connection.get();
//            Elements elements = doc.getElementsByClass("txt-col-content");
//            List<String> listOfResults = new ArrayList<>();
//            for (Element item : elements){
//                listOfResults.add(item.text());
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
    }

    private static List<String> processElements(String content) {
        List<String> listOfResults = new ArrayList<>();
        int counter = StringUtils.countOccurrencesOf(content, "zł");
        int index = -1;
        String text = "";
        int i = 0;
        while(i < counter){
            String res = content.substring(0, content.indexOf("zł"));
            index = content.indexOf("zł") + 1;
            content.replaceAll(res, "");
            listOfResults.add(res);
            i++;
        }

        return listOfResults;
    }
}
