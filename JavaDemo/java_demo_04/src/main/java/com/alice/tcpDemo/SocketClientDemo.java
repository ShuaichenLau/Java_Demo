package com.alice.tcpDemo;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SocketClientDemo {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 9098);

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream, true);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner scanner = new Scanner(System.in);

            while (true) {
                printWriter.println(scanner.nextLine());
                System.out.println(bufferedReader.readLine());
            }
//            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
