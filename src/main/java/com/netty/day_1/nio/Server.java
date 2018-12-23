package com.netty.day_1.nio;

import sun.nio.ch.SelectorImpl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;

public class Server {
    public static void main(String[] args) throws IOException {
        NioServer nioServer = new NioServer();
        nioServer.open();
    }

    public static class NioServer {
        public NioServer() throws IOException {
        }

        private final ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        private ByteBuffer byteBuffer = ByteBuffer.allocate(1024);


        public void open() throws IOException {
            try {
                Selector selector = Selector.open();
                serverSocketChannel.configureBlocking(false);
                serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
                serverSocketChannel.bind(new InetSocketAddress(20880));
                while (true) {
                    selector.select();
                    Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                    while (it.hasNext()) {
                        SelectionKey selectionKey = it.next();
                        it.remove();
                        if (selectionKey.isAcceptable()) {
                            SocketChannel socketChannel = serverSocketChannel.accept();
                            socketChannel.configureBlocking(false);
                            System.out.println(" is accept!");
                            socketChannel.register(selector, SelectionKey.OP_READ);
                        }
                        if (selectionKey.isReadable()) {
                            System.out.println(" is read!");
                            SocketChannel channel = (SocketChannel) selectionKey.channel();
                            StringBuilder stringBuilder = new StringBuilder();
                            int a;
                            do {
                                byteBuffer.clear();
                                a = channel.read(byteBuffer);
                                byteBuffer.flip();
                                System.out.println("读到字符：" + a);
                                stringBuilder.append(Charset.forName("utf-8").decode(byteBuffer));
                                if (a < 1024) {
                                    System.out.println(stringBuilder.toString());
                                    stringBuilder.delete(0, stringBuilder.length());
                                }
                            } while (a >= 1024);
                        }
                    }


                }


            } catch (Exception e) {

            }
        }
    }
}
