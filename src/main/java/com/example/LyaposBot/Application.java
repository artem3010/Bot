package com.example.LyaposBot;

import com.example.LyaposBot.controller.CallBackApiHandler;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Application {
    private static final String PROPERTIES_FILE = "config.properties";
    private static Properties properties;
    private static GroupActor groupActor;
    private static VkApiClient vk;
    private static String accessToken;

    static {
        try {
            properties = readProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
        groupActor = createGroupActor(properties);
        HttpTransportClient httpClient = HttpTransportClient.getInstance();
        vk = new VkApiClient(httpClient);
    }

    public static String getAccessToken() {
        return accessToken;
    }

    private static GroupActor createGroupActor(Properties properties) {
        String groupId = properties.getProperty("group_id");
        accessToken = properties.getProperty("token");
        return new GroupActor(Integer.parseInt(groupId), accessToken);
    }

    private static Properties readProperties() throws IOException {
        InputStream inputStream = CallBackApiHandler.class.getClassLoader()
                .getResourceAsStream(PROPERTIES_FILE);
        if (inputStream == null) {
            throw new FileNotFoundException("property file '" + PROPERTIES_FILE
                    + "' not found in the classpath");
        }
        try {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException("Incorrect properties file");
        } finally {
            inputStream.close();
        }
    }

    public static GroupActor getGroupActor() {
        return groupActor;
    }

    public static VkApiClient getVk() {
        return vk;
    }
}
