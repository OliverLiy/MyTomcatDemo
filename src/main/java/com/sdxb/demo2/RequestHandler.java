package com.sdxb.demo2;

import com.sdxb.http.Response;

import java.io.*;
import java.net.Socket;

public class RequestHandler implements Runnable{
    public Socket socket;
    public RequestHandler(Socket socket)
    {
        this.socket=socket;
    }

    public void run() {
        InputStream inputStream=null;
        try{
            inputStream=socket.getInputStream();
            System.out.println("执行客户请求"+Thread.currentThread());
            System.out.println("====收到客户端请求====");
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
            String msg=null;
            while((msg=reader.readLine())!=null){
                if(msg.length()==0){
                    break;
                }
                System.out.println(msg);
            }
            String resp= Response.responsebody + "OK";
            OutputStream outputStream=socket.getOutputStream();
            System.out.println(resp);
            outputStream.write(resp.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
