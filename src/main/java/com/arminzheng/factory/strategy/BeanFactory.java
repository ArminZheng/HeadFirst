package com.arminzheng.factory.strategy;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
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
        try (InputStream inputStream = BeanFactory.class.getResourceAsStream("/applicationContext.properties")) {
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
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
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
    public static Object getBean(String key) {
        Object ret = null;
        try {
            Class<?> clz = Class.forName(env.getProperty(key));
            ret = clz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}
