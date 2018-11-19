package com.jiaboyan.generic.service;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by jiaboyan on 2017/4/1.
 */
public class TestService<T> {

    private int x;

    private Map<String,? extends Number> map;

    private T e;

    private T[] array;

    public static void main(String[] agrs) throws NoSuchFieldException {
//        private int x
        Field x = TestService.class.getDeclaredField("x");
        Type xType =  x.getGenericType();
        System.out.println(xType.getClass());
        System.out.println(xType);

//        private Map<String,? extends Number> map
        Field mapField = TestService.class.getDeclaredField("map");
        Type mapType = mapField.getGenericType();
        System.out.println(mapType.getClass());
        System.out.println(mapType);

//        private T e
        Field eField = TestService.class.getDeclaredField("e");
        Type eType = eField.getGenericType();
        System.out.println(eType.getClass());
        System.out.println(eType);

//        private T[] array
        Field arrayField = TestService.class.getDeclaredField("array");
        Type arrayType = arrayField.getGenericType();
        System.out.println(arrayType.getClass());
        System.out.println(arrayType);

    }
}
