package com.cloud.other;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCodeGenerator {

    public static void main(String[] args) {
        String data = "危险物品" +
                "12345" +
                "dsfdsfds";
        String filePath = "qrcode.png";
        int width = 300;
        int height = 300;

        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, width,
                    height,generateQRCodeHints1());
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
                }
            }
            ImageIO.write(image, "png", new File(filePath));
            System.out.println("QR Code generated successfully!");
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
    }

    private static EncodeHintType generateQRCodeHints() {
        com.google.zxing.EncodeHintType hintType = EncodeHintType.ERROR_CORRECTION;
        ErrorCorrectionLevel level = ErrorCorrectionLevel.L; // 调整容错级别，根据您的需求进行更改
        return hintType;
    }

    private static Map<EncodeHintType, Object> generateQRCodeHints1() {
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        return hints;
    }
}

