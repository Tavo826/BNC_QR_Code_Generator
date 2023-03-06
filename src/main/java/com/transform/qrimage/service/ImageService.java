package com.transform.qrimage.service;

import com.transform.qrimage.entity.RequestQR;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.util.Base64;

@Service
public class ImageService {

    public String generateQRCodeImage(RequestQR barcodeText) {

        var decodeMessage = new String(Base64.getDecoder().decode(barcodeText.getQRImage()));

        try {

            new File("qrImage.svg");

            FileWriter fileWriter = new FileWriter("qrImage.svg");
            fileWriter.write(decodeMessage);
            fileWriter.close();

        } catch (Exception e) {
            System.out.println("Excepcion file: " + e);
            throw new RuntimeException();
        }

        return "QR saved in root as qrImage.svg";
    }
}
