package hu.ak_akademia.file;

import hu.ak_akademia.property.Property;

import java.io.File;

public class FileLoader {

    private final Property property;

    public FileLoader(Property property) {
        this.property = property;
    }

    public File load(String fileName, String fileExtension) {
        return new File(property.getDirectoryAddress(), fileName + fileExtension);
    }
}
