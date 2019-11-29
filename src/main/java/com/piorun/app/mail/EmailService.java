package com.piorun.app.mail;

import com.piorun.app.house.Flatmate;
import com.piorun.app.house.Room;
import com.piorun.app.logger.AppLogger;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.piorun.app.mail.TextCreator.*;


@Component
public class EmailService {

    private final JavaMailSender emailSender;

    private final AppLogger logger;

    private List<Flatmate> flatmates = Arrays.asList(Flatmate.values());

    private boolean isWeekend = false;

    public EmailService(JavaMailSender emailSender, AppLogger logger) {
        this.emailSender = emailSender;
        this.logger = logger;
    }

    public void remindAll() {

        logger.debug("Starting sending reminders");

        for (int i = 0; i < Room.values().length; i++) {
            logger.debug("Creating reminder for " + flatmates.get(i).getName());
            logger.debug("Today you have to clean " + Room.values()[i]);
            sendReminder(flatmates.get(i), Room.values()[i]);
        }
        if (isWeekend) {
            Collections.rotate(flatmates, 1);
            logger.clean();
        }
    }

    private void sendReminder(Flatmate mate, Room room) {

        String address = mate.getAddress();
        String subject = createSubject();
        String text = createGreeting(mate.getName()) + createCleaning(room.getName());

        logger.debug("Message content prepared");
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(address);
        mailMessage.setSubject(subject);
        mailMessage.setText(text);

        logger.debug("Message object created successfully");
        emailSender.send(mailMessage);
        logger.debug("Message sent to " + mate.getAddress());

    }

    public void startWeekend() {
        isWeekend = true;
    }

    public void endWeekend() {
        isWeekend = false;
    }
}
