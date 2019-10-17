package com.alice.udpDemo;

import java.io.IOException;
import java.net.*;

public class ClientDemo {

    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;

        try {
            // 创建Scoket
            datagramSocket = new DatagramSocket();
            byte[] bytes = "HelloWorld".getBytes();
            //创建发送包
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("localhost"), 9098);
            // 发送数据
            datagramSocket.send(datagramPacket);

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            datagramSocket.close();
        }


    }
}
