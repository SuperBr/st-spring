package com.netty.day_1.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        IoServer ioServer = new IoServer(21880);
        ioServer.open();

    }

    public static class IoServer {

        private final ServerSocket serverSocket;

        private char[] chars = new char[100];


        public IoServer(Integer port) throws IOException {
            this.serverSocket = new ServerSocket(port);

        }

        public void open() throws IOException {
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    InputStream in = socket.getInputStream();
                    OutputStream out = socket.getOutputStream();
                    this.socketProcess(in, out);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
        }

        private void socketProcess(InputStream inputStream, OutputStream outputStream) throws IOException {
            BufferedReader buffReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            int a;
            do {
                a = buffReader.read(chars);
                System.out.println("读到字符：" + a);
                stringBuilder.append(chars, 0, a);
                if (a < chars.length) {
                    System.out.println(stringBuilder.toString());
                    stringBuilder.delete(0, stringBuilder.length());
                }
            } while (a > 0);


        }


    }

}
