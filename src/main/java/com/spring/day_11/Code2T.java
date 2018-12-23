package com.spring.day_11;

import com.alibaba.dubbo.remoting.Codec2;
import com.alibaba.dubbo.remoting.exchange.codec.ExchangeCodec;
import com.alibaba.dubbo.rpc.protocol.dubbo.DubboCodec;
import com.alibaba.dubbo.rpc.protocol.thrift.ThriftCodec;

public class Code2T {

    public static void main(String[] args) {

        DubboCodec dubboCodec = new DubboCodec();

        ThriftCodec thriftCodec = new ThriftCodec();

        ExchangeCodec exchangeCodec = new DubboCodec();


    }
}
