package com.jiaboyan.generic.test;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * Created by jiaboyan on 2017/4/23.
 */
public class TypeVariableTest<T> {

    private T t;
    public static void testGetName() throws NoSuchFieldException {
        Field fieldT = TypeVariableTest.class.getDeclaredField("t");
        TypeVariable typeVariable = (TypeVariable)fieldT.getGenericType();
        //获取类型变量在源码中定义的名称：
        String name = typeVariable.getName();
    }
    public static void main(String[] agrs) throws NoSuchFieldException {
        testGetName();
    }


    public static void testGetBounds() throws NoSuchFieldException {
        Field fieldT = TypeVariableTest.class.getDeclaredField("t");
        TypeVariable typeVariable = (TypeVariable)fieldT.getGenericType();
        //获取类型变量t的上边界：
        Type[] types = typeVariable.getBounds();
        //class java.lang.Object
        for(Type type:types){
            System.out.println(type);
        }
    }

    public static void testGetGenericDeclaration() throws NoSuchFieldException {
        Field fieldT = TypeVariableTest.class.getDeclaredField("t");
        TypeVariable typeVariable = (TypeVariable)fieldT.getGenericType();
        //获取声明该类型变量(T)的实体：
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        //class com.jiaboyan.generic.test.TypeVariableTest
        System.out.print(genericDeclaration);
    }


    public <V extends Number> TypeVariableTest(T t ){

    }

    public <K extends Number> void test(K k){

    }
}
