package com.kafka.notificationServer.handler;

import com.kafka.notificationServer.event.StudentCreatedEvent;
import com.kafka.notificationServer.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentCreatedHandler {

    @Autowired
    private EmailService emailService;

    public void handle(StudentCreatedEvent event) {
        emailService.sendEmail(event);
    }
}