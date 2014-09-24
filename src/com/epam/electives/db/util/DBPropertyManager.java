package com.epam.electives.db.util;

import java.util.ResourceBundle;

public class DBPropertyManager {
    /**
     * Manager for database connection settings
     */
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resourses.database");

    private DBPropertyManager() {

    }

    /**
     *
     * @param key
     * @return value according key
     */
    public static String getDBProperty (String key) {
        return resourceBundle.getString(key);
    }

}
