package com.example.LyaposBot.model.response;

import javax.servlet.http.HttpServletResponse;

public interface ResponseCreator {
    void execute(HttpServletResponse response);
}
