package com.m.reza.khorasany.service.reader;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;

@Service
public class Reader {

    public String read(BufferedImage bufferedImage) {
        String encodedContent = null;
        try {
            BufferedImageLuminanceSource bufferedImageLuminanceSource = new BufferedImageLuminanceSource(bufferedImage);
            HybridBinarizer hybridBinarizer = new HybridBinarizer(bufferedImageLuminanceSource);
            BinaryBitmap binaryBitmap = new BinaryBitmap(hybridBinarizer);
            MultiFormatReader multiFormatReader = new MultiFormatReader();
            Result result = multiFormatReader.decode(binaryBitmap);
            encodedContent = result.getText();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return encodedContent;
    }

}
