package com.eeswan.proxy;

import org.junit.Test;

public class BookServiceTest {

    BookService bookService = new BookServiceProxy(new DefaultBookService());

    @Test
    public void proxyTest() {
        Book book = new Book();
        book.setTitle("Spring");
        bookService.rent(book);

    }

}
