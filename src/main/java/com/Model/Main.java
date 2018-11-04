package com.Model;

import com.Model.ObjectImpl.MenuImpl;
import com.Model.webreader.WebReaderForNaszeMiejsce;
import com.Model.webreader.WebReaderForRestro;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        WebReaderForRestro reader = new WebReaderForRestro();
        List<String> menus = reader.read();
        for(String item : menus) {
            System.out.println(item);
        }
    }
}
