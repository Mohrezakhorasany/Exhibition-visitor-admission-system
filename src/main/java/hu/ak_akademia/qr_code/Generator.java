package hu.ak_akademia.qr_code;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.io.UnsupportedEncodingException;

public class Generator {

    private static final String CHARSET = "UTF-8";
    private static final int HEIGHT = 200;
    private static final int WIDTH = 200;


    public BitMatrix generate(String data) throws UnsupportedEncodingException, WriterException {
        BarcodeFormat barcodeFormat;
        return new MultiFormatWriter().encode(new String(data.getBytes(CHARSET), CHARSET),BarcodeFormat.QR_CODE,WIDTH,HEIGHT);
    }

}
