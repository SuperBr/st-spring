package com.netty.day_1.io;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        IoClient ioClient = new IoClient(21880);
        ioClient.clientProcess();
    }


    public static class IoClient {

        private final Socket socket = new Socket();

        private final Integer port;

        public IoClient(Integer port) {
            this.port = port;
        }

        public Socket connect() throws IOException {
            socket.connect(new InetSocketAddress(port));
            return socket;
        }


        public void clientProcess() throws IOException {
            if (!socket.isConnected()) {
                connect();
            }
            Scanner scanner = new Scanner(System.in);
            while (true) {
                OutputStream out = socket.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(out, Charset.forName("utf-8")));
                String st = scanner.nextLine();
                System.out.println(st);
                bufferedWriter.write(st);
                bufferedWriter.flush();
            }

        }

    }


}
