package com.example.LyaposBot.model.events;
import com.example.LyaposBot.model.supports.AnswerCreator;

import java.util.Map;

public class Message extends Event {

    private String text;
    private String peerId;
    private Map object;


    public Message(String type, String text, String peerId, Map object) {
        super(type);
        this.text = text;
        this.peerId = peerId;
        this.object = object;
    }

    @Override
    public String createAnswer() {

        return AnswerCreator.create(this);
    }


    public String getText() {
        return text;
    }

    public String getPeerId() {
        return peerId;
    }

    public Map getObject() {
        return object;
    }
}
