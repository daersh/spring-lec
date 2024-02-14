package com.section01.autowired.subsection03.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext ac = new AnnotationConfigApplicationContext("com.section01");
        BookService bookService = ac.getBean("bookServiceSetter", BookService.class);
        System.out.println(bookService.findAllBook());
        int [] arr= new int[]{1, 2, 3, 4, 5};
        for(int a : arr){
            System.out.println(a);
        }
    }
}
