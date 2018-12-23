package com.netty.day_1.io.muchThread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) throws IOException {
        IoServer ioServer = new IoServer(21880);
        ioServer.open();

    }

    public static class IoServer {

        private final ServerSocket serverSocket;

        private char[] chars = new char[100];

        private final Executor executor = Executors.newFixedThreadPool(10);


        public IoServer(Integer port) throws IOException {
            this.serverSocket = new ServerSocket(port);

        }

        public void open() throws IOException {
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    executor.execute(new Runnable() {
                        @Override
                        public void run() {
                            InputStream in = null;
                            try {
                                in = socket.getInputStream();
                                OutputStream out = socket.getOutputStream();
                                socketProcess(in, out);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    });

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
