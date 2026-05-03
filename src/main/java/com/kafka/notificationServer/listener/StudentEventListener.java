package com.kafka.notificationServer.listener;

import com.kafka.notificationServer.event.StudentCreatedEvent;
import com.kafka.notificationServer.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StudentEventListener {

    @Autowired
    private EmailService emailService;

    @KafkaListener(topics = "student.created", groupId = "notification-group")
    public void listen(StudentCreatedEvent event) {
        System.out.println(">>> KAFKA LISTENER ACTIVE <<<");
        System.out.println("🔥 EVENT RECEIVED: " + event);

        emailService.sendEmail(event);

        System.out.println(">>> MAIL SEND SUCCESSFULLY <<<");
    }
}
