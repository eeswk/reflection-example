package com.eeswan.bytebuudy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import static net.bytebuddy.matcher.ElementMatchers.named;


public class BookServiceTest {

    @Test
    public void di() throws Exception {
        Class<? extends BookService> proxyClass = new ByteBuddy().subclass(BookService.class)
                .method(named("rent")).intercept(InvocationHandlerAdapter.of(new InvocationHandler() {
                    BookService bookService = new BookService();
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("bytebuddy start");
                        Object invoke = method.invoke(bookService, args);
                        System.out.println("bytebuddy end");
                        return invoke;
                    }
                }))
                .make().load(BookService.class.getClassLoader()).getLoaded();
        BookService bookService = proxyClass.getConstructor(null).newInstance();

        Book book = new Book();
        book.setTitle("byteBuddy book");
        bookService.rent(book);
        bookService.buy(book);
    }

}