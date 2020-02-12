package com.eeswan.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.Method;

public class BookServiceTest {

    BookService bookService = new BookService();

    @Test
    public void di() {
        MethodInterceptor handler = new MethodInterceptor() {
            BookService bookService = new BookService();
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                if (method.getName().equals("rent")) {
                    System.out.println("cglib start");
                    Object invoke = method.invoke(bookService, args);
                    System.out.println("cglib end");
                    return invoke;
                }
                return method.invoke(bookService, args);

            }
        };
        BookService bookService = (BookService) Enhancer.create(BookService.class, handler);

        Book book = new Book();
        book.setTitle("cglibBook");
        bookService.rent(book);
        bookService.buy(book);

    }
}