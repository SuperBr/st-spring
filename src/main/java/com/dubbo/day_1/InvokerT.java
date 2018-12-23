package com.dubbo.day_1;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.remoting.Channel;
import com.alibaba.dubbo.remoting.ChannelHandler;
import com.alibaba.dubbo.remoting.RemotingException;
import com.alibaba.dubbo.remoting.exchange.ExchangeChannel;
import com.alibaba.dubbo.remoting.exchange.ExchangeClient;
import com.alibaba.dubbo.remoting.exchange.ExchangeHandler;
import com.alibaba.dubbo.remoting.exchange.support.header.HeaderExchangeClient;
import com.alibaba.dubbo.remoting.exchange.support.header.HeaderExchangeHandler;
import com.alibaba.dubbo.remoting.exchange.support.header.HeartbeatHandler;
import com.alibaba.dubbo.remoting.transport.DecodeHandler;
import com.alibaba.dubbo.remoting.transport.MultiMessageHandler;
import com.alibaba.dubbo.remoting.transport.netty.NettyClient;
import com.alibaba.dubbo.rpc.*;
import com.alibaba.dubbo.rpc.protocol.InvokerWrapper;
import com.alibaba.dubbo.rpc.protocol.dubbo.DubboInvoker;
import com.spring.day_10.api.ICatService;
import com.spring.day_10.model.Cat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wangyongchao
 * @date 2018/12/20  11:07
 */
public class InvokerT {


    public static void main(String[] args) throws RemotingException {

        Map<String, String> map = new HashMap<>();
        map.put(Constants.CODEC_KEY, "dubbo");
        map.put(Constants.TIMEOUT_KEY, "5000");
        map.put(Constants.PATH_KEY, "com");
        map.put(Constants.GROUP_KEY, "wyc-test");

        NettyClient nettyClient = new NettyClient(new URL("dubbo", "127.0.0.1", 20889, null, map), new DecodeHandler(new HeaderExchangeHandler(new CChannelHandler())));


        ExchangeClient[] exchangeClients = new ExchangeClient[]{
                new HeaderExchangeClient(nettyClient)
        };

        Invoker invoker = new DubboInvoker(ICatService.class, new URL("dubbo", "127.0.0.1", 20889, "com.spring.day_10.api.ICatService", map), exchangeClients);

        Invoker invoker1 = new InvokerWrapper(invoker, invoker.getUrl()) {

            @Override
            public Result invoke(Invocation invocation) throws RpcException {
                Invoker last = invoker;
                List<Filter> filters = ExtensionLoader.getExtensionLoader(Filter.class).getActivateExtension(invoker.getUrl(), "filter");
                if (filters.size() > 0) {
                    for (int i = filters.size() - 1; i >= 0; i--) {
                        final Filter filter = filters.get(i);
                        final Invoker next = last;
                        last = new Invoker() {

                            public Class getInterface() {
                                return invoker.getInterface();
                            }

                            public URL getUrl() {
                                return invoker.getUrl();
                            }

                            public boolean isAvailable() {
                                return invoker.isAvailable();
                            }

                            public Result invoke(Invocation invocation) throws RpcException {
                                return filter.invoke(next, invocation);
                            }

                            public void destroy() {
                                invoker.destroy();
                            }

                            @Override
                            public String toString() {
                                return invoker.toString();
                            }
                        };
                    }
                }
                return last.invoke(invocation);
            }


        };


        RpcInvocation invocation = new RpcInvocation();
        invocation.setAttachments(map);
        invocation.setMethodName("printCat");
        invocation.setArguments(new Object[]{new Cat()});
        invocation.setParameterTypes(new Class[]{Cat.class});
        invocation.setAttachmentIfAbsent("path", "com");

        Result result = invoker1.invoke(invocation);

        System.out.println(result.getValue());


    }

    public static class CChannelHandler implements ExchangeHandler {
        @Override
        public void connected(Channel channel) throws RemotingException {
            System.out.println("connected!!!!!!!!!!");
        }

        @Override
        public void disconnected(Channel channel) throws RemotingException {
            System.out.println("disconnected!!!!!!!!!!");
        }

        @Override
        public void sent(Channel channel, Object message) throws RemotingException {
            System.out.println("sent!!!!!!!!!!" + message);
        }

        @Override
        public void received(Channel channel, Object message) throws RemotingException {
            System.out.println("received!!!!!!!!!!" + message);
        }

        @Override
        public void caught(Channel channel, Throwable exception) throws RemotingException {
            System.out.println("caught!!!!!!!!!!");
        }

        @Override
        public Object reply(ExchangeChannel channel, Object request) throws RemotingException {
            return request;
        }

        @Override
        public String telnet(Channel channel, String message) throws RemotingException {
            return message;
        }
    }

}
