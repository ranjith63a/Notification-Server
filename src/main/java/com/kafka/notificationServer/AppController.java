package com.kafka.notificationServer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AppController {

    @GetMapping
    public ResponseEntity<String> home() {
        log.info("Welcome To the Notification Application");
        return ResponseEntity.ok("Welcome To the Notification Application");
    }

}
