package com.alice.utils;

import java.io.*;
import java.net.Socket;

public class SocketClientDemo {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",9098);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream,true);
            printWriter.println("helloWorld liusc");

            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println(bufferedReader.readLine());
//            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
