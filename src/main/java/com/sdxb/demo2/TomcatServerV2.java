package com.sdxb.demo2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TomcatServerV2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8080);
        System.out.println("====服务启动====");
        while(!serverSocket.isClosed()){
            Socket socket=serverSocket.accept();
            RequestHandler requestHandler=new RequestHandler(socket);
            new Thread(requestHandler).start();

        }
    }
}
