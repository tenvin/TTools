package com.twg.ttools.lang;

import java.lang.reflect.Method;

public class MyAnnotation {

    @MyTarget
    public void doSomething() { }

    public static void main(String[] args) throws Exception{
        Method method = MyAnnotation.class.getMethod("doSomething", null);
        if (method.isAnnotationPresent(MyTarget.class)) {
            System.out.println(method.getAnnotation(MyTarget.class));
        }

    }
}
