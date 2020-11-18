package com.work1;

import org.junit.Test;

public class DynamicProxyTest {
    @Test
    public void test() {
        LogService logService = new LogServiceImpl();
        DynamicProxy handler = new DynamicProxy(logService);
        LogService proxyLogService = handler.getProxy();
        proxyLogService.info();
    }
}
