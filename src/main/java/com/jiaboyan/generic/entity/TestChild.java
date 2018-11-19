package com.jiaboyan.generic.entity;


/**
 * Created by jiaboyan on 2017/5/6.
 */
public class TestChild extends Test {

    @Override
    public String getT() {
        return null;
    }

    public static void main(String[] agrs){
        TestChild testChild = new TestChild();
        Object obj = testChild.getT();
        String s = testChild.getT();
    }
}
