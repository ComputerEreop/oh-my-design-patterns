package io.innofang.proxy.example.java;

import java.lang.reflect.Proxy;

/**
 * Created by Inno Fang on 2017/4/8.
 */
public class Client {
    public static void main(String[] args) {
        IPicker picker = new RealPicker();
        ProxyPicker proxyPicker = new ProxyPicker(picker);

        proxyPicker.receiveMessage();
        proxyPicker.takeCourier();
        proxyPicker.signatureAcceptance();

        System.out.println();
        /*      Dynamic proxy        */

        IPicker iPicker = new RealPicker();
        DynamicProxy proxy = new DynamicProxy(iPicker);
        ClassLoader loader = IPicker.class.getClassLoader();
        IPicker dynamicPicker = (IPicker) Proxy.newProxyInstance(
                loader, new Class[]{IPicker.class}, proxy);

        dynamicPicker.receiveMessage();
        dynamicPicker.takeCourier();
        dynamicPicker.signatureAcceptance();

    }
}
