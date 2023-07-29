package com.msc.usermicroserv.utils;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import lombok.Data;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @program: user-microserv
 * @description:
 * @author: yfliu
 * @create: 2023-07-27 20:45
 **/
@Data
@Component
public class OpenMrsAPI {


    private String url;


    private String baseUrl;


    private String authorization;


    private String sessionUrl;


    private String personUrl;

    private String sessionID;


    public OpenMrsAPI(@Value("${openmrs.api.url}") String url,
                      @Value("${openmrs.api.baseUrl}") String baseUrl,
                      @Value("${openmrs.api.authorization}") String authorization,
                      @Value("${openmrs.api.sessionUrl}") String sessionUrl,
                      @Value("${openmrs.api.personUrl}") String personUrl) {

        this.url = url;
        this.baseUrl = baseUrl;
        this.authorization = authorization;
        this.sessionUrl = sessionUrl;
        this.personUrl = personUrl;
        this.sessionID = retrieveSessionToken();
    }


    private String retrieveSessionToken() {

        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url(buildUrl(sessionUrl))
                    .method("GET", null)
                    .addHeader("Authorization", "Basic " + authorization)
                    .build();
            Response response = client.newCall(request).execute();
            if (response.body() != null) {
                String temp = response.body().string();
                JSONObject json = (JSONObject) JSON.parse(temp);
                return json.get("sessionId").toString();
            } else {
                System.out.println("response.body() is null");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONObject queryPatients(String query) {
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url(buildUrl(personUrl) + "?q=" + query)
                    .method("GET", null)
                    .addHeader("Authorization", "Basic " + authorization)
                    .addHeader("Cookie", "JSESSIONID=" + sessionID)
                    .build();
            Response response = client.newCall(request).execute();
            if (response.body() != null) {
                String temp = response.body().string();
                JSONObject json = (JSONObject) JSON.parse(temp);
                return json;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


        public JSONObject getPatientInfoByUUID(String uuid){
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url(buildUrl(personUrl+"/"+uuid))
                    .method("GET", null)
                    .addHeader("Authorization", "Basic " + authorization)
                    .addHeader("Cookie", "JSESSIONID=" + sessionID)
                    .build();
            Response response = client.newCall(request).execute();
            if (response.body() != null) {
                String temp = response.body().string();
                JSONObject json = (JSONObject) JSON.parse(temp);
                return json;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    private String buildUrl(String path) {
        return url + baseUrl + path;
    }


}
