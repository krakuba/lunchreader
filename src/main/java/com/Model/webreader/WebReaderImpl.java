package com.Model.webreader;

import com.Model.ObjectImpl.MenuImpl;

import java.util.List;

public abstract class WebReaderImpl {
    public abstract List<MenuImpl> getMenuOptions();

    protected String removeEmptySpaceBeforeDotsAndCommas(String text) {
        return text.replaceAll("\\s+(?=[,.])", "");
    }
}
