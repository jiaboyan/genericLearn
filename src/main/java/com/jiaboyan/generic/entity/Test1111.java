package com.jiaboyan.generic.entity;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jiaboyan on 2017/3/31.
 */
public class Test1111<T,K> {

    private Map<T,K> map = null;

    private List<T> list = null;

    private Map<? extends Number, ? super Integer> map1 = null;

    private List<T[]> tListArray = null;

    private File file = null;

    private FileEntity<T> fileEntity = null;

    // ,: 表示一种参数化的类型
    public static void testParameterizedType() throws NoSuchFieldException {
        Field field = Test1111.class.getDeclaredField("fileEntity");
        Type type = field.getGenericType();
//      List<T> list  sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl
        System.out.println(type.getClass().getName());
    }

//    TypeVariable: 是各种类型变量的公共父接口 , 类型变量，如参数化类型中的E、K等类型变量，表示泛指任何类，如
    public static void testTypeVariable() throws NoSuchFieldException {
        Field field = Test1111.class.getDeclaredField("map");
        Type fieldType = field.getGenericType();
        Type[] types = ((ParameterizedType) fieldType).getActualTypeArguments();
        for(Type type : types){
//          Map<T,K> map = null;  sun.reflect.generics.reflectiveObjects.TypeVariableImpl
            System.out.println(type.getClass().getName());
        }
    }

//    WildcardType: 代表一种通配符类型表达式，比如?, ? extends Number,
    public static void testWildcardType() throws NoSuchFieldException {
        Field field = Test1111.class.getDeclaredField("map1");
        Type fieldType = field.getGenericType();
        Type[] types = ((ParameterizedType) fieldType).getActualTypeArguments();
        for(Type type : types){
//          Map<? extends Number, ? super Integer> map1
//          sun.reflect.generics.reflectiveObjects.WildcardTypeImpl
            System.out.println(type.getClass().getName());
        }
    }


    // GenericArrayType: 表示一种元素类型是参数化类型或者类型变量的数组类型
//    表示泛型数组类型
    public static void testGenericArrayType() throws NoSuchFieldException {
        Field field = Test1111.class.getDeclaredField("tListArray");
        Type fieldType = field.getGenericType();//返回Type对象，标识此字段的声明类型
        Type[] types = ((ParameterizedType) fieldType).getActualTypeArguments();
        for(Type type : types){
//          List<T[]> tListArray  sun.reflect.generics.reflectiveObjects.GenericArrayTypeImpl
            System.out.println(type.getClass().getName());
        }
    }

//    Class也是实现了Type接口。像前面的代码中得到了java.lang.Integer等
    public static void  testClass() throws NoSuchFieldException {
        Field field = Test1111.class.getDeclaredField("file");
        Type fieldType = field.getGenericType();//返回Type对象，标识此字段的声明类型
        //java.lang.Class
        System.out.print(fieldType.getClass().getName());
    }

    public static void main(String[] agrs) throws NoSuchFieldException {

        testParameterizedType();

//        类型检查就是针对引用的，谁是一个引用，用这个引用调用泛型方法，
//  就会对这个引用调用的方法进行类型检测，而无关它真正引用的对象。
        ArrayList<String> arrayList1 = new ArrayList();
        arrayList1.add("111");


        ArrayList arrayList = new ArrayList<String>();
        arrayList.add(222);


    }


    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
