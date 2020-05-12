package http_request;

import models.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Request {
    private static Request request;
    private int pageNumber;
    private String url;

    public Request(String url, int pageNumber) {
        this.url = url;
        this.pageNumber = pageNumber;
    }

    public static synchronized Request getInstance(String url, int pageNumber) {
        if (null == request) {
            request = new Request(url, pageNumber);
        }
        return request;
    }

    private String buildUrl() {
        return String.format("%s%s", this.url, this.pageNumber);
    }

    public Response get() {
        try {
            URL url = new URL(buildUrl());
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            int status = httpURLConnection.getResponseCode();

            if (status == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                System.out.println(content.toString());
                return new Response("00", "Request Executed Successfully", content.toString());
            } else {
                return new Response("99", "Request Failed", null);
            }
        } catch (IOException e) {
            return new Response("99", e.getMessage(), null);
        }

    }
}
