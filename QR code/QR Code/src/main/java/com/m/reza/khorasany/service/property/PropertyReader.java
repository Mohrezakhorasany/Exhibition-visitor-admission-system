package com.m.reza.khorasany.service.property;

import lombok.AllArgsConstructor;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

@AllArgsConstructor
public class PropertyReader {

    private String path;

    public String readPropertyValue(String key) {
        String property = null;
        try (FileReader reader = new FileReader(path)) {
            Properties properties = new Properties();
            properties.load(reader);
            property = properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }

    public Properties readConnectionProperties(Map<String, String> keyValuesMap) {
        Properties properties = new Properties();
        for (Map.Entry<String, String> entry : keyValuesMap.entrySet()) {
            properties.setProperty(entry.getKey(), readPropertyValue(entry.getValue()));
        }
        return properties;
    }

}
