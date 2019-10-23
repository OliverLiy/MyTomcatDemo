package com.sdxb.servlet;

import com.sdxb.http.Request;
import com.sdxb.http.Response;

public abstract class MyHttpServlet implements MyServlet {

    //如果有请求过来，就会调用这个方法，然后再根据请求类型来调用不同的doXXX（）方法
    public void service(Request request, Response response) throws Exception {
        if("get".equalsIgnoreCase(request.getMethod())){
            this.doGet(request,response);
        }else {
            this.doPost(request,response);
        }
    }
    public abstract void doGet(Request request,Response response);
    public abstract void doPost(Request request,Response response);
}
