package com.eeswan.proxy;

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
}
