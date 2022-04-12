package com.arminzheng.factory.strategy;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * BeanFactory
 *
 * @author zy
 * @version 2022/4/9
 */
public class BeanFactory {

    private static final Properties env = new Properties();

    static {
        try (InputStream inputStream =
                BeanFactory.class.getResourceAsStream("/applicationContext.properties")) {
            env.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 简单工厂会存在大量的代码冗余
     *
     * @return UserService
     */
    public static UserService getUserService() {
        UserService userService = null;
        try {
            Class<?> userServiceClz = Class.forName(env.getProperty("userService"));
            userService = (UserService) userServiceClz.getConstructor().newInstance();
        } catch (ClassNotFoundException
                | NoSuchMethodException
                | InstantiationException
                | IllegalAccessException
                | InvocationTargetException e) {
            e.printStackTrace();
        }
        return userService;
    }

    /**
     * 获取配置文件中bean的通用方法
     *
     * @param key properties的key
     * @return bean
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String key) {
        T ret = null;
        try {
            Class<?> clz = Class.forName(env.getProperty(key));
            ret = (T) clz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * getBean() 和本方法都使用了类型参数推断。当作为参数传递时，编译器不会执行类型推断
     *
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> map() {
        return new HashMap<>();
    }

    public static <T> void m(T t) {
        System.out.println(t.getClass().getName());
    }

    public static void f(Map<UserService, UserController> h) {}
}
