package com.eeswan.proxy;

/**
 * 컴파일시점에서 프록시를 만듬
 */
public class BookServiceProxy  implements BookService {

    private BookService bookService;

    public BookServiceProxy(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void rent(Book book) {
        System.out.println("proxy add start");
        bookService.rent(book);
        System.out.println("proxy add end");
    }

    @Override
    public void buy(Book book) {
        bookService.buy(book);
    }
}
