package com.jiaboyan.generic.test;

import com.jiaboyan.generic.exception.GenericException;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaboyan on 2017/5/4.
 */
public class GenericTest<T> {

    private List<?> list;

    public void test(List<?> list){
        Object obj = list.get(0);
    }
}
