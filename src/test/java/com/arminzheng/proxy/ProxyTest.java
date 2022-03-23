package com.arminzheng.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ProxyTest
 *
 * @author zy
 * @version 2022/3/24
 */
public class ProxyTest {


    public static void main(String[] args) {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        // 第二个参数必须是interface
        A o = (A) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[]{A.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Method[] methods = proxy.getClass().getMethods();
                for (Method method1 : methods) {
                    System.out.println("proxy.getClass().getMethods() = " + method1.getName());
                }
                // Object invoke = method.invoke(new AImpl(), args);
                // return invoke;
                return "我是你哥";
            }
        });
        System.out.println("o = " + o.getClass().getName()); // o = com.sun.proxy.$Proxy0
        System.out.println("o = " + o.getClass());
        Class<?>[] interfaces = o.getClass().getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("os = " + anInterface.getName());
        }
        System.out.println("o.sayHello() = " + o.sayHello());
    }
}
