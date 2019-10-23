package com.sdxb.http;

import java.io.OutputStream;

public class Response {
    public OutputStream outputStream;

    public static final String responsebody="HTTP/1.1 200+\r\n"+"Content-Type：text/html+\r\n"
            +"\r\n";
    public Response(OutputStream outputStream){
        this.outputStream=outputStream;
    }
}
