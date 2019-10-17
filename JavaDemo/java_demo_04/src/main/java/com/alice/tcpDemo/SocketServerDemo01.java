package com.alice.tcpDemo;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerDemo01 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9098);
            System.out.println("开始监听");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("监听success...");
                new Thread(new RunnableSocketDemo(socket)).start();

                System.out.println(socket.getInetAddress());
                System.out.println(socket.getPort());
                InetAddress address = InetAddress.getByName("www.baidu.com");
                System.out.println("address==>" + address);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
