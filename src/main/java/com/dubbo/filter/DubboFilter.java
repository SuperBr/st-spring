package com.dubbo.filter;

import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;


@Activate(order = Integer.MIN_VALUE)
public class DubboFilter implements Filter {
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {


        String i18n = RpcContext.getContext().getAttachments().get("i18n");

        Result re = invoker.invoke(invocation);

        if (RpcContext.getContext().getAttachments().get("i18n") == null) {
            if (i18n != null) {
                RpcContext.getContext().setAttachment("i18n", i18n);
            }
        }


        return re;
    }
}
