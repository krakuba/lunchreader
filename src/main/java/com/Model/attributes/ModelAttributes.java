package com.Model.attributes;

import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

public class ModelAttributes {
    @ModelAttribute("naszeMiejsceMenu")
    public List<String> naszeMiejsceMenu() {
        List<String> menu = new ArrayList<>();
        menu.add("test1");
        menu.add("test2");
        menu.add("test3");
        return menu;
    }
}
