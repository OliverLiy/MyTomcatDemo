package com.sdxb.demo1;

import com.sdxb.http.Response;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TomcatServerV1 {
    public static void main(String[] args)throws IOException{
        ServerSocket serverSocket=new ServerSocket(8080);
        System.out.println("======服务启动成功========");
        while(!serverSocket.isClosed()){
            Socket socket=serverSocket.accept();
            InputStream inputStream=socket.getInputStream();
            System.out.println("执行客户请求:"+Thread.currentThread());
            System.out.println("收到客户请求");
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
            String msg=null;
            while((msg=reader.readLine())!=null){
                if(msg.length()==0) break;
                System.out.println(msg);
            }
            String resp= Response.responsebody+"OK";
            OutputStream outputStream=socket.getOutputStream();
            System.out.println(resp);
            outputStream.write(resp.getBytes());
            outputStream.flush();
            outputStream.close();
            socket.close();
        }
    }
}
