package com.sdxb.servlet;

import com.sdxb.http.Request;
import com.sdxb.http.Response;

import java.io.IOException;
import java.io.OutputStream;

public class UserServlet extends MyHttpServlet {

    @Override
    public void doGet(Request request, Response response) {
        this.doPost(request,response);
    }

    @Override
    public void doPost(Request request, Response response) {
        try {

            //根据request对象里面的inputStream拿到对应的参数进行业务调用
            //模拟业务层调用后的返回
            OutputStream outputStream=response.outputStream;
            String result=Response.responsebody+"user handle successful";
            outputStream.write(result.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() throws Exception {

    }

    public void destory() {

    }


}
