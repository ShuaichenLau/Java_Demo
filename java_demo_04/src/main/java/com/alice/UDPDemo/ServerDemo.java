package com.alice.UDPDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerDemo {

    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;

        try {
            datagramSocket = new DatagramSocket(9098);
            byte[] data = new byte[1024];
            // 创建接收包
            DatagramPacket datagramPacket = new DatagramPacket(data, data.length);
            // 进行阻塞 读取发送过来的数据包
            datagramSocket.receive(datagramPacket);
            // 从数据包里读取数据
            String sData = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            System.out.println(sData);

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            datagramSocket.close();
        }
    }
}
