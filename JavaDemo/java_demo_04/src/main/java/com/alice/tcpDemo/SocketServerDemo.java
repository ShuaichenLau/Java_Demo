package com.alice.tcpDemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * SocketServerDemo
 * 获取网络输入输出流  TCP模型
 *  通过Socket获取输入流和输出流 这两个方法是使用Socket通讯的关键方法 封装了TCP协议的Socket是基于流建立通讯的
 *  所以我们在创建了双方连接之后,只需要获取相应的输入流和输出流即可实现通讯
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
