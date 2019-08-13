package com.edgeconnect.automation.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    static Properties properties;
    static FileInputStream fileInputStream;

    public static Properties getConfData() {
        try {
            properties = new Properties();
            fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/config.properties");
            properties.load(fileInputStream);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return properties;
    }
}
