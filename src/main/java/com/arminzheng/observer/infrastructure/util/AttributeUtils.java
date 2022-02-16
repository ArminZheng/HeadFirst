package com.arminzheng.observer.infrastructure.util;

import com.arminzheng.observer.infrastructure.annotation.FieldMap;
import com.arminzheng.observer.infrastructure.annotation.FieldMaps;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * @author Armin Zheng
 * @since 2021-09-04
 */
public class AttributeUtils {

    public static void copy(Object source, Object target, String channel) throws IllegalAccessException, NoSuchFieldException {
        Class<?> sourceClass = source.getClass();
        Class<?> targetClass = target.getClass();

        Field[] sourceFields = sourceClass.getDeclaredFields();
        HashMap<String, Object> sourceMap = new HashMap<>();
        for (Field field : sourceFields) {
            field.setAccessible(true);
            sourceMap.put(field.getName(), field.get(source));
        }

        Field[] targetFields = targetClass.getDeclaredFields();
        for (Field field : targetFields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(FieldMaps.class)) {
                // FieldMap annotation =
                FieldMap[] annotationsByType = field.getAnnotationsByType(FieldMap.class);
                for (FieldMap annotation : annotationsByType) {
                    if (channel.equals(annotation.channel())) {
                        String value = annotation.value();
                        Object sourceValue = sourceMap.get(value);
                        if (field.getType() == sourceClass.getDeclaredField(value).getType()) {
                            field.set(target, sourceValue);
                        } else {
                            System.out.println("属性类型不一致");
                        }
                    }
                }
                continue;
            }
            field.set(target, sourceMap.get(field.getName()));
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        // 静态方法
        Method parseDouble = Double.class.getDeclaredMethod("parseDouble", String.class);

        Double d1 = (Double) parseDouble.invoke(null, "3");

        System.out.println("d1 = " + d1);

        Method m = Integer.class.getMethod("parseInt", String.class);
        // 调用该静态方法并获取结果:
        Integer n = (Integer) m.invoke(null, "12345");
        // 打印调用结果:
        System.out.println(n);

        // 获取属性
        Integer i = 3;
        Field value = i.getClass().getDeclaredField("value");
        System.out.print(value.getName() + ": ");
        value.setAccessible(true); // 私有属性
        int i1 = (int) value.get(i); // i1为对象i的属性值
        System.out.println(i1);
        // 设置属性
        value.set(i, 4);
        System.out.println("设置过后的 i = " + i);

        String s = String.class.newInstance();
        s = "hello";
        System.out.println("s = " + s);
        Constructor<Integer> constructor = Integer.class.getConstructor(int.class);
        Integer integer1 = constructor.newInstance(20);
        System.out.println("integer1 = " + integer1);
        System.out.println("Integer.class.getSuperclass() = " + Integer.class.getSuperclass());
        System.out.println("Integer.class.getSuperclass() = " + Integer.class.getSuperclass().getSuperclass());
        System.out.println("Integer.class.getSuperclass() = " + Integer.class.getSuperclass().getSuperclass().getSuperclass());
        Class<?>[] interfaces = Integer.class.getSuperclass().getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("anInterface = " + anInterface);
            System.out.println("anInterface = " + Arrays.stream(anInterface.getInterfaces()).collect(Collectors.toList()));
        }
        System.out.println("Number.class.isAssignableFrom(Integer.class) = " + Number.class.isAssignableFrom(Integer.class));
        // Number.class.isAssignableFrom(Integer.class) = true

        // Type gc = target.getClass().getGenericSuperclass();
        // ((ParameterizedType) gc).getActualTypeArguments();
        // ((ParameterizedType) gc).getActualTypeArguments();
    }
}
