package com.example.LyaposBot.model.events;


public abstract class Event {
    String type;

    public Event(String type) {
        this.type = type;
    }

    abstract public String createAnswer();


}
