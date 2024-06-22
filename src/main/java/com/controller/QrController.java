package com.controller;

import com.model.QrGenerator;
import com.model.QrRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class QrController {

    private static final Logger log = LoggerFactory.getLogger(QrController.class);

    @PostMapping("/qr")
    public ResponseEntity handleRequest(@RequestBody QrRequest qrRequest) {
        log.info("Received client request");
        if(qrRequest.getUrlToEmbed() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(HttpHeaders.CONTENT_TYPE, "image/png");
            String urlToEmbed = qrRequest.getUrlToEmbed();
            log.info("Generating QR image for "+urlToEmbed);
            return new ResponseEntity<byte[]>(
                    QrGenerator.generateQR(urlToEmbed, 512, 512),
                    httpHeaders,
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}