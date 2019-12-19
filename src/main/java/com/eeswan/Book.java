package com.eeswan;

@MyAnnotaion("eeswan")
public class Book {

    private String a = "a";

    private static String B = "BOOK";

    private static final String C = "BOOK";

    @MyAnnotaion
    public String d = "d";

    @AnotherAnnotaion
    protected String e = "e";

    public Book (){}
    @AnotherAnnotaion
    public Book(String a, String d, String e) {
        this.a = a;
        this.d = d;
        this.e = e;
    }

    private void f() {
        System.out.println("F");
    }

    @AnotherAnnotaion
    public void g() {
        System.out.println("g");
    }

    public int h() {
        return 100;
    }
}
