package de.tiupe.business;

import java.time.LocalDateTime;

public class News {

    private String titel;
    private String text;
    private LocalDateTime dateTime;

    public News(String titel, String text, LocalDateTime dateTime) {
        this.titel = titel;
        this.text = text;
        this.dateTime = dateTime;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
