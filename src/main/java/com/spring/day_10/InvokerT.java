package com.spring.day_10;

import com.alibaba.dubbo.rpc.proxy.javassist.JavassistProxyFactory;
import com.spring.day_10.api.ICatService;
import com.spring.day_10.service.CatService;

/**
 * @author wangyongchao
 * @date 2018/12/13  10:47
 */
public class InvokerT {

    public static void main(String[] args){

        ICatService iCatService = new CatService();


        JavassistProxyFactory proxyFactory = new JavassistProxyFactory();





    }
}
