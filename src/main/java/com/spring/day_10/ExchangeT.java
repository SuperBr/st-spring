package com.spring.day_10;


import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.remoting.RemotingException;
import com.alibaba.dubbo.remoting.exchange.ExchangeClient;
import com.alibaba.dubbo.remoting.exchange.ExchangeHandler;
import com.alibaba.dubbo.remoting.exchange.ExchangeServer;
import com.alibaba.dubbo.remoting.exchange.Exchanger;
import com.alibaba.dubbo.remoting.exchange.support.header.HeaderExchanger;

/**
 * @author wangyongchao
 * @date 2018/12/13  10:18
 */
public class ExchangeT {

    public static void main(String[] args){


        Exchanger exchanger=new Exchanger() {
            @Override
            public ExchangeServer bind(URL url, ExchangeHandler handler) throws RemotingException {
                return null;
            }

            @Override
            public ExchangeClient connect(URL url, ExchangeHandler handler) throws RemotingException {
                return null;
            }
        };


        Exchanger headExchanger=new HeaderExchanger();


    }
}
