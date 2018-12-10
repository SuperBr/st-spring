package com.spring.day_10;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.registry.Registry;
import com.alibaba.dubbo.registry.zookeeper.ZookeeperRegistryFactory;
import com.alibaba.dubbo.remoting.zookeeper.curator.CuratorZookeeperTransporter;

public class RegisterT {
    public static void main(String[] args) {

        ZookeeperRegistryFactory zookeeperRegistryFactory = new ZookeeperRegistryFactory();

        zookeeperRegistryFactory.setZookeeperTransporter(new CuratorZookeeperTransporter());

        Registry register = zookeeperRegistryFactory.createRegistry(new URL("zookeeper", "127.0.0.1", 2181));





    }
}
