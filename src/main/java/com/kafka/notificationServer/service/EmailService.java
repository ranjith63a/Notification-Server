package com.kafka.notificationServer.service;

import com.kafka.notificationServer.event.StudentCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Async
    public void sendEmail(StudentCreatedEvent event) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(event.getEmail());
        msg.setSubject("🎉 Welcome to Our School, " + event.getName() + "!");

        msg.setText(
                "Dear " + event.getName() + ",\n\n" +
                        "Congratulations and welcome to our school!\n\n" +
                        "We are pleased to inform you that your admission has been successfully completed.\n\n" +
                        "Here are your details:\n" +
                        "-----------------------------------\n" +
                        "Student Name : " + event.getName() + "\n" +
                        "Department   : " + event.getDepartmentCode() + "\n" +
                        "-----------------------------------\n\n" +
                        "Our faculty and staff are here to guide you throughout your academic journey.\n\n" +
                        "We wish you great success in your studies!\n\n" +
                        "Warm regards,\n" +
                        "Student Services Team"
        );

        mailSender.send(msg);
    }
}