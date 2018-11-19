package com.jiaboyan.generic.entity;

/**
 * Created by jiaboyan on 2017/4/1.
 */
public class ClassTypeCapture<T> {

    Class<T> kind;

    T t;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

     public void newT() throws IllegalAccessException, InstantiationException {
         t = kind.newInstance();
     }

     public static void main(String[] agrs) throws InstantiationException, IllegalAccessException {
         ClassTypeCapture<String> classTypeCapture = new ClassTypeCapture<String>(String.class);
         classTypeCapture.f(new String());
         classTypeCapture.newT();
     }
}
