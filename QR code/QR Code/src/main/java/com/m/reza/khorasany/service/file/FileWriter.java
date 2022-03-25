package com.m.reza.khorasany.service.file;

import com.m.reza.khorasany.service.property.PropertyReader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileWriter {

    private static final String PATH = "QR code/QR Code/src/main/resources/qr-code.properties";

    private final PropertyReader propertyReader = new PropertyReader(PATH);

    public void write(BufferedImage bufferedImage, String fileName) throws IOException {
        File file = new File(propertyReader.readPropertyValue("path") + "\\" + fileName + ".jpg");
        file.createNewFile();
        ImageIO.write(bufferedImage, "jpg", file);
    }

}
