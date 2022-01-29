package hu.ak_akademia.property;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Property {

    private static final Properties properties = new Properties();
    private final String propertyFilePath;


    public Property(String propertyFilePath) {
        this.propertyFilePath = propertyFilePath;
    }

    public File getDirectoryAddress() {
        try {
            properties.load(new FileReader(propertyFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new File(properties.getProperty("dir_path"));
    }
}
