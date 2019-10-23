package com.sdxb.servlet;

import com.sdxb.http.Request;
import com.sdxb.http.Response;

public interface MyServlet {
    void init() throws Exception;
    void service(Request request, Response response) throws Exception;
    void destory();
}
