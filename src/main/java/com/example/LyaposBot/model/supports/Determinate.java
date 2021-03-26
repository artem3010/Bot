package com.example.LyaposBot.model.supports;

import com.example.LyaposBot.Application;
import com.example.LyaposBot.model.events.Accept;
import com.example.LyaposBot.model.events.Event;
import com.example.LyaposBot.model.events.Message;
import com.example.LyaposBot.model.response.ResponseCreator;
import com.example.LyaposBot.model.response.ResponseCreatorForAccept;
import com.example.LyaposBot.model.response.ResponseCreatorForMessage;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.Map;

public class Determinate {

    public static Event defineEvent(JsonObject jsonObject){
        String type = jsonObject.get("type").getAsString();
        if (type.equals("confirmation")){
            return new Accept(type);
        } else if (type.equals("message_new")){
            String text = jsonObject.get("object").getAsJsonObject().get("message").getAsJsonObject().get("text").getAsString();
            String peerId = jsonObject.get("object").getAsJsonObject().get("message").getAsJsonObject().get("peer_id").getAsString();
            Map object = new Gson().fromJson(jsonObject,Map.class);
            return new Message(type,text,peerId,object);
        }
        throw new IllegalArgumentException();
    }

    public static ResponseCreator defineResponseCreator(Event event){
        if (event instanceof Message){
            return new ResponseCreatorForMessage((Message) event, Application.getAccessToken());
        }else if (event instanceof Accept){
            return new ResponseCreatorForAccept();
        }
        throw new IllegalArgumentException();
    }
}
