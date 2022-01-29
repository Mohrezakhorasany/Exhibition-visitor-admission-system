package hu.ak_akademia.file;

import hu.ak_akademia.property.Property;

import java.io.File;
import java.io.IOException;

public class FileSaver {

    private final Property property;

    public FileSaver(Property property) {
        this.property = property;
    }

    public boolean save(File file) {
        File directory = property.getDirectoryAddress();
        File fileWithAbsolutePath = new File(directory.getAbsolutePath(), file.getPath());
        try {
            return fileWithAbsolutePath.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
