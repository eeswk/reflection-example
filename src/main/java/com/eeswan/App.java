package com.eeswan;

import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException {

        //클래스 정보를 가져오는 방법
        //1
        Class<Book> bookClass = Book.class;
        //2
        Book book = new Book();
        Class<? extends Book> aClass = book.getClass();
        //3
        Class<?> aClass1 = Class.forName("com.eeswan.Book");

        //클래스 필드 출력
        Arrays.stream(bookClass.getFields()).forEach(System.out::println);

        Book book1 = new Book();
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            try {
                f.setAccessible(true);
                System.out.printf("%s %s\n" , f, f.get(book1));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        Arrays.stream(bookClass.getDeclaredMethods()).forEach(System.out::println);
        Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);
        System.out.println(bookClass.getSuperclass());
        Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);

        Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
            int modifiers = f.getModifiers();
            System.out.println(f);
            System.out.println(Modifier.isPrivate(modifiers));
            System.out.println(Modifier.isStatic(modifiers));
        });

        Arrays.stream(Book.class.getMethods()).forEach(f -> {
            int modifiers = f.getModifiers();
            System.out.println(f);
            System.out.println(Modifier.isPrivate(modifiers));
            System.out.println(Modifier.isStatic(modifiers));
        });

        Arrays.stream(MyBook.class.getAnnotations()).forEach(System.out::println);

        Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
            Arrays.stream(f.getAnnotations()).forEach( a -> {
                if (a instanceof MyAnnotaion) {
                    MyAnnotaion myAnnotaion = (MyAnnotaion) a;
                    System.out.println(myAnnotaion.value());
                    System.out.println(myAnnotaion.number());
                }
            });
        });


    }
}
