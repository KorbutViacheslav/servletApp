package com.example.demo.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfigInit {
    private static Properties properties;

    static {
        properties = new Properties();
        try (InputStream inputStream = DatabaseConfigInit.class
                .getClassLoader()
                .getResourceAsStream("application.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return properties.getProperty("database.url");
    }

    public static String getUser() {
        return properties.getProperty("database.user");
    }

    public static String getPassword() {
        return properties.getProperty("database.password");
    }
}
