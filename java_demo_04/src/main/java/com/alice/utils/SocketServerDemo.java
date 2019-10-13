package com.alice.utils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * SocketServerDemo
 */
public class SocketServerDemo {

    public static void main(String[] args) {


        try {

            ServerSocket serverSocket = new ServerSocket(9098);
            System.out.println("开始监听......");
            Socket socket = serverSocket.accept();  //阻塞线程
            System.out.println("监听成功......");

            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream, true);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println(bufferedReader.readLine());
                printWriter.println(scanner.nextLine());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
