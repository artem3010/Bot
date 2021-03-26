package com.example.LyaposBot.model.response;

import com.example.LyaposBot.Application;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.http.HttpEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseCreatorForAccept implements ResponseCreator {


    @Override
    public void execute(HttpServletResponse response) {
        try {
        String acceptCode = "ee5f6fb1";
        response.getWriter().println(acceptCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
