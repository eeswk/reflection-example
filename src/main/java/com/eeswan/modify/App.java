package com.eeswan.modify;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 리플렉션 API 사용
 * 클래스를 조작하는 방법들
 */
public class App {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        Class<?> bookClass = Class.forName("com.eeswan.modify.Book");

        Constructor<?> constructor = bookClass.getConstructor(null);
        Book book = (Book) constructor.newInstance();
        System.out.println(book);

        Constructor<?> constructor1 = bookClass.getConstructor(String.class);
        Book book1 = (Book) constructor1.newInstance("myBook");
        System.out.println(book1);

        Field a = Book.class.getDeclaredField("A");
        System.out.println( a.get(null));
        a.set(null, "AAA");
        System.out.println(a.get(null));

        Field b = Book.class.getDeclaredField("B");
        b.setAccessible(true);
        System.out.println(b.get(book));
        b.set(book, "BBBB");
        System.out.println(b.get(book));


        Method c = Book.class.getDeclaredMethod("c");
        c.setAccessible(true);
        c.invoke(book);

        Method d = Book.class.getDeclaredMethod("sum", int.class, int.class);
        int invoke = (int) d.invoke(book, 1, 2);
        System.out.println(invoke);





    }
}
