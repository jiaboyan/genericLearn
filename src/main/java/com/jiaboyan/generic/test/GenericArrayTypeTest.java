package com.jiaboyan.generic.test;

import com.jiaboyan.generic.entity.Test1111;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by jiaboyan on 2017/4/23.
 */
public class GenericArrayTypeTest<T> {

    private T[] t;

    private List<String>[] listArray;

    public static void main(String[] args) throws NoSuchFieldException {
        Field fieldListArray = GenericArrayTypeTest.class.getDeclaredField("listArray");
        Type typeListArray = fieldListArray.getGenericType();
        //获取实际Type类型：sun.reflect.generics.reflectiveObjects.GenericArrayTypeImpl
        System.out.println(typeListArray.getClass().getName());

        Field fieldT = GenericArrayTypeTest.class.getDeclaredField("listArray");
        Type typeT = fieldT.getGenericType();
        //获取实际Type类型：sun.reflect.generics.reflectiveObjects.GenericArrayTypeImpl
        System.out.println(typeT.getClass().getName());
    }



    public static void testGetGenericComponentType() throws NoSuchFieldException {
        Field fieldListArray = GenericArrayTypeTest.class.getDeclaredField("listArray");
        Type typeListArray = fieldListArray.getGenericType();
        GenericArrayType genericArrayType = (GenericArrayType)typeListArray;
        //获取泛型数组的Type对象：
        //List<String>的原始类型为泛型，所以type最终的类型为ParameterizedTypeImpl
        Type type = genericArrayType.getGenericComponentType();
    }
}
