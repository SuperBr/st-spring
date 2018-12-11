package com.spring.day_10;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.registry.Registry;
import com.alibaba.dubbo.registry.integration.RegistryProtocol;
import com.alibaba.dubbo.registry.zookeeper.ZookeeperRegistryFactory;
import com.alibaba.dubbo.remoting.zookeeper.curator.CuratorZookeeperTransporter;
import com.alibaba.dubbo.remoting.zookeeper.zkclient.ZkclientZookeeperTransporter;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.RpcInvocation;
import com.alibaba.dubbo.rpc.cluster.support.AvailableCluster;
import com.alibaba.dubbo.rpc.protocol.dubbo.DubboProtocol;
import com.alibaba.dubbo.rpc.proxy.javassist.JavassistProxyFactory;
import com.spring.day_10.api.ICatService;

public class RegisterT {
    public static void main(String[] args) {

        ZookeeperRegistryFactory zookeeperRegistryFactory = new ZookeeperRegistryFactory();

        zookeeperRegistryFactory.setZookeeperTransporter(new ZkclientZookeeperTransporter());


      //  Registry register = zookeeperRegistryFactory.createRegistry(new URL("zookeeper", "127.0.0.1", 2181));

        RegistryProtocol registryProtocol = new RegistryProtocol();

        registryProtocol.setCluster(new AvailableCluster());

        registryProtocol.setProtocol(new DubboProtocol());


        registryProtocol.setRegistryFactory(zookeeperRegistryFactory);

        registryProtocol.setProxyFactory(new JavassistProxyFactory());


        Invoker<ICatService> inverk = registryProtocol.refer(ICatService.class, new URL("zookeeper", "127.0.0.1", 2181, "com.alibaba.dubbo.registry.RegistryService"));

        inverk.invoke(new RpcInvocation());


    }
}
