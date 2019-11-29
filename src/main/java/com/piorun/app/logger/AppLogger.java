package com.piorun.app.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Component
public class AppLogger {

    private List<String> logs = new ArrayList<>();
    private Logger logger = LoggerFactory.getLogger(AppLogger.class);


    public List<String> getLogs() {
        return logs;
    }

    public void debug(String s) {
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDate localDate = dateTime.toLocalDate();
        String msg = localDate + " " + dateTime.toLocalTime() + s;
        logs.add(msg);
        logger.debug(s);
    }

    public void clean() {
        this.logs.clear();
    }
}
