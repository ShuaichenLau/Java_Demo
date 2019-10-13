package com.alice.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClientDemo {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",9098);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println("helloWorld liusc");
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
