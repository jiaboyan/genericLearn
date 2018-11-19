package com.jiaboyan.generic.entity;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * Created by jiaboyan on 2017/3/27.
 */
public class FileEntity<T> {

    private String name;

    private Integer age;

    private String address;

    private Date date;

    public Type _type;

    public FileEntity(){
//        Type superClass = getClass().getGenericSuperclass();//获得带有泛型的父类
//
//        _type = ((ParameterizedType) superClass).getActualTypeArguments()[0];

        //ParameterizedType参数化类型，即泛型
        //getActualTypeArguments获取参数化类型的数组，泛型可能有多个
    }

    public String test(){
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int compare(T o1, T o2) {
        return 0;
    }
}
