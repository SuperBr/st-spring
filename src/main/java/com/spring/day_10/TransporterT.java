package com.spring.day_10;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.remoting.Channel;
import com.alibaba.dubbo.remoting.ChannelHandler;
import com.alibaba.dubbo.remoting.RemotingException;
import com.alibaba.dubbo.remoting.Transporter;
import com.alibaba.dubbo.remoting.transport.netty.NettyServer;
import com.alibaba.dubbo.remoting.transport.netty.NettyTransporter;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TransporterT {

    public static void main(String[] args) throws RemotingException, BrokenBarrierException, InterruptedException {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        Transporter transporter=new NettyTransporter();


        transporter.bind(URL.valueOf("127.0.0.1:20885"), new ChannelHandler() {
            @Override
            public void connected(Channel channel) throws RemotingException {
                System.out.println("connected!!!");
            }

            @Override
            public void disconnected(Channel channel) throws RemotingException {
                System.out.println("disconnected!!!");
            }

            @Override
            public void sent(Channel channel, Object message) throws RemotingException {
                System.out.println("sent!!!");
            }

            @Override
            public void received(Channel channel, Object message) throws RemotingException {
                System.out.println("received!!!:"+message.toString());
            }

            @Override
            public void caught(Channel channel, Throwable exception) throws RemotingException {
                System.out.println("caught!!!");
            }
        });

        cyclicBarrier.await();
    }
}
