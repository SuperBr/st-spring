package com.spring.day_6;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpTest {

    public static void main(String[] args) throws IOException, InterruptedException {


        Socket socket = new Socket("192.168.2.1", 8000);


        socket.getOutputStream().write(0x01);

        while (true) {
            Thread.sleep(1000);

            byte[] bt = new byte[100];

            BufferedInputStream bufferedInputStream=new BufferedInputStream(socket.getInputStream());

            bufferedInputStream.read(bt);

            System.out.println("r:"+new String(bt));
        }


    }
}
