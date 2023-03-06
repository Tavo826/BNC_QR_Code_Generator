package com.transform.qrimage.controller;

import com.google.zxing.WriterException;
import com.transform.qrimage.entity.RequestQR;
import com.transform.qrimage.service.ImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RestController
public class ImageController {

    private final ImageService service;

    public ImageController(ImageService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getStatus() {
        return "Service is OK";
    }

    @PostMapping("/getImage")
    public ResponseEntity<String> transformQRImage(@RequestBody RequestQR token) {
        return ResponseEntity.ok(service.generateQRCodeImage(token));
    }
}
