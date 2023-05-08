package com.example.Datadog;

import io.micrometer.core.annotation.Timed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Timed(value = "firstApi", description = "The description of the first API")
    @GetMapping("/first")
    public ResponseEntity getFirst() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @Timed(value = "secondApi", description = "The description of the second API")
    @GetMapping("/second")
    public ResponseEntity getSecond() throws InterruptedException {
        Thread.sleep(3000);
        return new ResponseEntity(HttpStatus.OK);
    }
}
