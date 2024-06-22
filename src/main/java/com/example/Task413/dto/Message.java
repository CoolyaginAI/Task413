package com.example.Task413.dto;

import java.time.LocalDate;

public class Message {

    private int id;
    private String title;
    private String text;
    LocalDate birthday;

    public Message() {
    }

    public Message(int id, String title,
                   String text, LocalDate birthday) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

}
