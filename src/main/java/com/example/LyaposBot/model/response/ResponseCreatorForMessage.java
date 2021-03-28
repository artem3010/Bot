package com.example.LyaposBot.model.response;

import com.example.LyaposBot.model.events.Message;
import org.apache.http.client.utils.URIBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;

public class ResponseCreatorForMessage implements ResponseCreator {
    URIBuilder uriBuilder = null;

    public ResponseCreatorForMessage(Message message, String token) {
        try {
            uriBuilder = new URIBuilder("https://api.vk.com/method/messages.send");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        if (uriBuilder != null) {
            uriBuilder.addParameter("random_id", String.valueOf(Math.round(Math.random() * 200000)));
            uriBuilder.addParameter("peer_id", message.getPeerId());
            uriBuilder.addParameter("message", message.createAnswer());
            uriBuilder.addParameter("access_token", token);
            uriBuilder.addParameter("v", "5.130");

        }
    }


    @Override
    public void execute(HttpServletResponse response) {
        HTTPExecutorResponse rsp = new HTTPExecutorResponse();
        response.setStatus(200);
        try {
            if (uriBuilder != null) {
                rsp.execute(uriBuilder.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
