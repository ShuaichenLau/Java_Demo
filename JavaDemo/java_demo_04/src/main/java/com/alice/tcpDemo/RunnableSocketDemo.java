package com.alice.tcpDemo;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class RunnableSocketDemo implements Runnable {

    private Socket socket;

    public RunnableSocketDemo(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream, true);

            Scanner scanner = new Scanner(System.in);
            while (true){
                System.err.println(bufferedReader.readLine());
                printWriter.println(scanner.nextLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
