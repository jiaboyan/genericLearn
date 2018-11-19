package com.jiaboyan.generic.test;

import com.jiaboyan.generic.entity.Test1111;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by jiaboyan on 2017/4/23.
 */
public class ParameterizedTypeTest<T extends Number> {



    public static void testGetActualTypeArguments() throws NoSuchFieldException {
        Field fieldMap = ParameterizedTypeTest.class.getDeclaredField("map");
        Type typeMap = fieldMap.getGenericType();
        ParameterizedType parameterizedTypeMap = (ParameterizedType) typeMap;
        //获取泛型中的实际类型：
        Type[] types = parameterizedTypeMap.getActualTypeArguments();
        System.out.println(types[0]);//class java.lang.String
        System.out.println(types[1]);//class java.lang.Integer
    }


    private Map<String,Integer> map = null;
    public static void testGetRawType() throws NoSuchFieldException {
        Field fieldMap = ParameterizedTypeTest.class.getDeclaredField("map");
        Type typeMap = fieldMap.getGenericType();
        ParameterizedType parameterizedTypeMap = (ParameterizedType) typeMap;
        //获取声明泛型的类/接口：
        Type type = parameterizedTypeMap.getRawType();

    }
    public static void main(String[] agrs) throws NoSuchFieldException {
        testGetRawType();
    }




//    private Map<String,Integer> map = null;
    private Map.Entry<String,Integer> mapEntry;

    public static void testGetOwnerType() throws NoSuchFieldException {
        Field fieldMapEntry = ParameterizedTypeTest.class.getDeclaredField("mapEntry");
        Type typeMapEntry = fieldMapEntry.getGenericType();
        ParameterizedType parameterizedTypeMapEntry = (ParameterizedType) typeMapEntry;
        //获取泛型的拥有者：
        Type type = parameterizedTypeMapEntry.getOwnerType();
    }
}
