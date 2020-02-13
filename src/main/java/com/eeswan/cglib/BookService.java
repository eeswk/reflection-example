package com.eeswan.cglib;

/**
 * 다이나믹 프록시 기법 CGLib
 */
public class BookService {

    public void rent(Book book) {
        System.out.println("rent: " + book.getTitle());
    }

    public void buy(Book book) {
        System.out.println("buy: " + book.getTitle());
    }
}
