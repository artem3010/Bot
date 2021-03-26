package com.example.LyaposBot.model.events;

import com.example.LyaposBot.Application;
import com.vk.api.sdk.actions.Groups;


public class Accept extends Event {

    public Accept(String type) {
        super(type);
    }

    @Override
    public String createAnswer() {
        return new Groups(Application.getVk())
                .getCallbackConfirmationCode(Application.getGroupActor(), Application.getGroupActor().getGroupId()).toString();
    }
}
