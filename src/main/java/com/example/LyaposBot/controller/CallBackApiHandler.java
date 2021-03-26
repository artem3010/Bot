package com.example.LyaposBot.controller;

import com.example.LyaposBot.*;
import com.example.LyaposBot.model.response.ResponseCreator;
import com.example.LyaposBot.model.supports.Determinate;
import com.example.LyaposBot.model.events.Event;
import com.example.LyaposBot.model.events.Message;
import com.example.LyaposBot.model.response.ResponseCreatorForMessage;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "acceptServlet", value = "/accept-servlet")
public class CallBackApiHandler extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JsonObject jsonObject = JsonParser.parseReader(request.getReader()).getAsJsonObject();
        Event event = Determinate.defineEvent(jsonObject);
        ResponseCreator responseCreator = Determinate.defineResponseCreator(event);
        responseCreator.execute(response);
    }


    public void destroy() {
    }
}