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
        String opt = "Krem z pieczonego selera z karmelizowanym jabłkiem i szałwią. Lasagne z duszoną wołowiną i korzennymi warzywami w słodkich pomidorach z pieczarkami, kaparami, szalotką w aromacie bazylii zapieczona z serem mozzarella, sosem beszamelowym i szpinakiem. Krucha sałata z grillowanym ananasem, pestkami dyni i balsamiczną winegret.";
        System.out.println(PrintSentencesIntoNewLine(opt));
    }

    public static String PrintSentencesIntoNewLine(String text) {
        String result = "";
        for(String i : text.split("\\.")){
            result = result.concat(i);
            result = result.concat(".");
            result = result.concat("<br>");
        }
        return result;
    }
}
