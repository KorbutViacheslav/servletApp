package com.example.demo.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class DatabaseConfigInit {
    private static final Properties PROPERTIES;

    static {
        PROPERTIES = new Properties();
        try (InputStream inputStream = DatabaseConfigInit.class
                .getClassLoader()
                .getResourceAsStream("application.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return PROPERTIES.getProperty("database.url");
    }

    public static String getUser() {
        return PROPERTIES.getProperty("database.user");
    }

    public static String getPassword() {
        return PROPERTIES.getProperty("database.password");
    }
}
