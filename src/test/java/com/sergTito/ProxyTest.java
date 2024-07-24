package com.sergTito;

import com.sergTito.entity.CompanyEntity;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    @Test

    void testDynamic(){
        CompanyEntity company = new CompanyEntity();
        Proxy.newProxyInstance(company.getClass().getClassLoader(),
                company.getClass().getInterfaces(),
                (proxy, method, args) -> method.invoke(company,args));
    }
}
