package com.m.reza.khorasany;

import com.google.zxing.WriterException;
import com.m.reza.khorasany.service.generator.Generation;
import com.m.reza.khorasany.service.file.FileWriter;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Test {

    public static void main(String[] args) throws RuntimeException, WriterException, IOException {
        final Generation generation = new Generation();
        final BufferedImage qrCode = generation.generate("yahoo.com");
        final FileWriter fileWriter = new FileWriter();
        fileWriter.write(qrCode, "yahoo");

    }
}
