package com.smart.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {

    public static Car initByDefaultConst() throws Throwable {
        //通过类加载器获取类的实例对象
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class clazz = classLoader.loadClass("com.smart.reflect.Car");

        //获取类的默认构造函数并实例化
        Constructor constructor = clazz.getDeclaredConstructor((Class[]) null);
        Car car = (Car) constructor.newInstance();

        //通过反射方法设置属性
        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car, "red flag car 72");
        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car, "black");
        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car, 90);
        return car;
    }

    public static void main(String[] args) throws Throwable {
        Car car = initByDefaultConst();
        car.introduce();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println("classloader:"+classLoader);
        System.out.println("classloader parent:"+classLoader.getParent());
        System.out.println("classloader parent's parent:"+classLoader.getParent().getParent());
    }
}
