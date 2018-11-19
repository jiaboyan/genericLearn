package com.jiaboyan.generic.dfdfs;

import sun.misc.Unsafe;
import sun.reflect.CallerSensitive;
import sun.reflect.ConstantPool;
import sun.reflect.Reflection;
import sun.reflect.ReflectionFactory;
import sun.reflect.annotation.AnnotationParser;
import sun.reflect.annotation.AnnotationType;
import sun.reflect.generics.factory.CoreReflectionFactory;
import sun.reflect.generics.factory.GenericsFactory;
import sun.reflect.generics.repository.ClassRepository;
import sun.reflect.generics.repository.ConstructorRepository;
import sun.reflect.generics.repository.MethodRepository;
import sun.reflect.generics.scope.ClassScope;
import sun.reflect.misc.ReflectUtil;
import sun.security.util.SecurityConstants;

import java.io.InputStream;
import java.io.ObjectStreamField;
import java.lang.annotation.Annotation;
import java.lang.ref.SoftReference;
import java.lang.reflect.*;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.*;

/**
 * Created by jiaboyan on 2017/4/6.
 */
public interface haha<T> {

}



interface ParameterizedTypess extends Type {

    //获得<>中实际类型
    Type[] getActualTypeArguments();

    //获得<>前面实际类型
    Type getRawType();

    //如果这个类型是某个类型所属，获得这个所有者类型，否则返回null
    Type getOwnerType();
}

interface TypeVariabless<D extends GenericDeclaration> extends Type {

    //获得泛型的上限，无显式定义（extends），默认为Object
    Type[] getBounds();

    //获取声明该类型变量实体(即获得类、方法或构造器名)
    D getGenericDeclaration();

    //获得名称，即K、V、E之类名称
    String getName();
}



interface GenericArrayTypess extends Type {
    //获得这个数组元素类型，即获得：A<T>（A<T>[]）或T（T[]）
    Type getGenericComponentType();
}

interface WildcardTypess extends Type {

    //获得泛型表达式上界（上限extends）
    Type[] getUpperBounds();

    //获得泛型表达式下界（下限super）
    Type[] getLowerBounds();
}
