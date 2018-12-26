package com.netty.day_1.netty.day_2;

import io.netty.channel.*;
import io.netty.channel.socket.nio.NioSocketChannel;

public class ChannelT {
    public static void main(String[] args) {

        Channel channel = new NioSocketChannel();

        ChannelInboundHandler channelInboundHandler = new ChannelInboundHandlerAdapter();

        ChannelInboundHandler channelInboundHandler1 = new SimpleChannelInboundHandler() {
            @Override
            protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

            }
        };

        ChannelHandler channelHandler=new ChannelHandler() {
            @Override
            public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

            }

            @Override
            public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {

            }

            @Override
            public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

            }
        };

        ChannelPipeline entries = new DefaultChannelPipeline(channel){

        };

        entries.addLast(channelInboundHandler);


        ChannelFuture channelFuture = new DefaultChannelPromise(new NioSocketChannel());



    }
}
