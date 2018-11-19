package com.jiaboyan.generic;
import com.jiaboyan.generic.entity.ManEntity;
import com.jiaboyan.generic.entity.PeopleEntity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
public class GenericTest {

    public static void main(String[] agrs){
        PeopleEntity<String> peopleEntity  = new ManEntity<String>();
        Type superClass = peopleEntity.getClass().getGenericSuperclass();
        Type _type = ((ParameterizedType)superClass).getActualTypeArguments()[0];
        System.out.print(_type);
    }

}
