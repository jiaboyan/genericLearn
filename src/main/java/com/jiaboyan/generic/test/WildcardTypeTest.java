package com.jiaboyan.generic.test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;

/**
 * Created by jiaboyan on 2017/4/26.
 */
public class WildcardTypeTest {

    private List<? super String> listStr;

    public static void testGetLowerBounds() throws NoSuchFieldException {
        Field fieldStr = WildcardTypeTest.class.getDeclaredField("listStr");
        Type typeStr = fieldStr.getGenericType();
        ParameterizedType parameterizedTypeStr = (ParameterizedType) typeStr;
        //获取泛型中的实际类型：
        Type[] typesStr = parameterizedTypeStr.getActualTypeArguments();
        //通配符类型：class sun.reflect.generics.reflectiveObjects.WildcardTypeImpl
        WildcardType wildcardType = (WildcardType)typesStr[0];
        //获取泛型变量的下边界(super)：
        Type[] types = wildcardType.getLowerBounds();
        //class java.lang.String
        System.out.println(types[0]);
    }
    public static void main(String[] agrs) throws NoSuchFieldException {
        testGetLowerBounds();
    }




    private List<? extends Number> listNum;

    public static void testGetUpperBounds() throws NoSuchFieldException {
        Field fieldNum = WildcardTypeTest.class.getDeclaredField("listNum");
        Type typeNum = fieldNum.getGenericType();
        ParameterizedType parameterizedTypeNum = (ParameterizedType) typeNum;
        //获取泛型中的实际类型：
        Type[] typesNum = parameterizedTypeNum.getActualTypeArguments();
        //通配符类型：class sun.reflect.generics.reflectiveObjects.WildcardTypeImpl
        WildcardType wildcardType = (WildcardType)typesNum[0];
        //获取泛型变量的上边界(extends)：
        Type[] types = wildcardType.getUpperBounds();
        //class java.lang.Number
        System.out.println(types[0]);
    }

}
