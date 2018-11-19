package com.jiaboyan.generic.test;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * Created by jiaboyan on 2017/4/26.
 */
public class ClassTest {

    private ClassTest classTest;

    public static void test() throws NoSuchFieldException {
        Field field = ClassTest.class.getDeclaredField("classTest");
        Type type = field.getGenericType();
        System.out.print(type);
    }
    public static void main(String[] agrs) throws NoSuchFieldException {
        test();
    }


}
