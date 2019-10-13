package com.alice.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * SocketServerDemo
 */
public class SocketServerDemo {

    public static void main(String[] args) {


        try {

            ServerSocket serverSocket = new ServerSocket(9098);
            System.out.println("开始监听");
            Socket socket = serverSocket.accept();
            System.out.println("监听成功");
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println(bufferedReader.readLine());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
