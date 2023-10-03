package com.example.cicdhsa26;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.Date;


@RestController
@RequestMapping("/api")
public class MyController {
    @GetMapping(produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public byte[] get() throws IOException {
        System.out.println("image requested ; " + Date.from(Instant.now()));
        try (InputStream in = getClass().getResourceAsStream("/Zugpsitze_mountain.jpg")) {
            return in.readAllBytes();
        }

    }
}
