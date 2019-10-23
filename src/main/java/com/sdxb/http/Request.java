package com.sdxb.http;

import java.io.*;

public class Request {
    // /user
    private String uri;
    // GET or POST
    private String method;
    public Request(InputStream inputStream){
        try {
            BufferedReader read=new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
            String[] data=read.readLine().split(" ");
            this.uri=data[1];
            this.method=data[0];
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
