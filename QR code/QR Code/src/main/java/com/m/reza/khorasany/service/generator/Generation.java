package com.m.reza.khorasany.service.generator;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
public class Generation {

    private static final int WIDTH = 200;
    private static final int HEIGHT = 200;

    public BufferedImage generate(String barCodeText) throws RuntimeException, WriterException {
        return MatrixToImageWriter
                .toBufferedImage(new QRCodeWriter()
                        .encode(barCodeText, BarcodeFormat.QR_CODE, WIDTH, HEIGHT));
    }

}
