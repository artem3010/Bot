package com.example.LyaposBot.model.response;

import com.example.LyaposBot.model.events.Message;
import org.apache.http.HttpEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseCreatorForMessage implements ResponseCreator {
    private String url;
    public ResponseCreatorForMessage(Message message, String token){
        url = "https://api.vk.com/method/messages.send?random_id="
                + Math.round(Math.random() * 200000) //random_id
                + "&peer_id=" + message.getPeerId()
                + "&message=" + message.createAnswer()
                + "&access_token=" + token
                + "&v=5.130";
    }



    @Override
    public void execute(HttpServletResponse response) {
        HTTPExecutorResponse rsp = new HTTPExecutorResponse();
        response.setStatus(200);
        try {
            rsp.execute(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
