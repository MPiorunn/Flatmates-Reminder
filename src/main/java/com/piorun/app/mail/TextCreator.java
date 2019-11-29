package com.piorun.app.mail;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TextCreator {

    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM");

    static String createGreeting(String mate) {
        return "Siemka " + mate + "\n";
    }

    static String createCleaning(String room) {
        return "W tym tygodniu sprzątasz " + room + "\n\n Pozdrowienia od automatycznego remindera od Pioruna :***:***:*";
    }

    static String createSubject() {
        String basic = "Sprzątanie ";
        basic += createDatesRange();
        return basic + ".";
    }

    private static String createDatesRange() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        String beginning = firstDayOfLastWeek(c);
        String end = lastDayOfLastWeek(c);
        return beginning + " - " + end;
    }

    private static String firstDayOfLastWeek(Calendar c) {
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return dateFormat.format(c.getTime());
    }

    private static String lastDayOfLastWeek(Calendar c) {
        for (int i = 0; i < 6; i++) {
            c.add(Calendar.DATE, 1);
        }
        return dateFormat.format(c.getTime());
    }
}
