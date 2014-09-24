package com.epam.electives.util;

import java.util.ResourceBundle;

/**
 * Manager for project pages
 */
public class PageManager {

    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resourses.pageconfig");

    private PageManager() {

    }

    /**
     *
     * @param key
     * @return
     */
    public static String getPage (String key) {
        return resourceBundle.getString(key);
    }


}
