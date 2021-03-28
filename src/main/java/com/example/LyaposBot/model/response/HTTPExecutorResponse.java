package com.example.LyaposBot.model.response;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class HTTPExecutorResponse {

    final CloseableHttpClient httpclient = HttpClients.createMinimal();

    public void execute(String url) throws IOException {
        final HttpUriRequest httpGet = new HttpGet(url);
        try {
            httpclient.execute(httpGet);//TODO: fix the request is repeated several times.
        } catch (IOException e) {
            e.printStackTrace();
        }
        httpclient.close();
    }


}
