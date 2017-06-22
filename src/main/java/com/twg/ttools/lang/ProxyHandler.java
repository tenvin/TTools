package com.twg.ttools.lang;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by twg on 2017/4/5.
 */
public class ProxyHandler implements InvocationHandler {
    // 目标对象
    private Object target;

    /**
     * 构造方法
     * @param target 目标对象
     */
    public ProxyHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在目标对象的方法执行之前简单的打印一下
        System.out.println("------------------before------------------");

        // 执行目标对象的方法
        Object result = method.invoke(target, args);

        // 在目标对象的方法执行之后简单的打印一下
        System.out.println("-------------------after------------------");

        return result;
    }

    /**
     * 获取目标对象的代理对象
     * @return 代理对象
     */
    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(), this);
    }
}
