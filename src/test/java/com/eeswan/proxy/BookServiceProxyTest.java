package com.eeswan.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

public class BookServiceProxyTest {

    //반드시 인터페이스이어야 함. DefaultBookService로 사용할경우 안됨 다이나믹프록시가 안됨
    private BookService bookService = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(), new Class[]{BookService.class},
            new InvocationHandler() {
                BookService bookService = new DefaultBookService();
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    // 1. 아무것도 하지 않을경우
                    //return method.invoke(bookService, args);

                    // 2. 중간에 메서드를 추가하는 경우
                    /*
                    System.out.println("start");
                    Object invoke = method.invoke(bookService, args);
                    System.out.println("end");
                    return invoke;
                    */
                    // 3. 특정메서드에만 추가하는경우
                    // 유연하게 할려면 스프링의 AOP를 활용
                    if (method.getName().equals("rent")) {
                        System.out.println("start");
                        Object invoke = method.invoke(bookService, args);
                        System.out.println("end");
                        return invoke;
                    }
                    return method.invoke(bookService, args);

                }
            });

    @Test
    public void proxyTest() {
        Book book = new Book();
        book.setTitle("Spring");
        bookService.rent(book);
        bookService.buy(book);
    }
}