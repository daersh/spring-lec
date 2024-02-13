package com.section01.autowired.subsection02.constructor;

import com.section01.autowired.subsection02.constructor.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext ac = new AnnotationConfigApplicationContext("com.section01");

        /*설명. subsection01에 있는 BookService 타입의 bean과의 혼선을 방지하기 위해 bean 이름을 달리 함*/
        BookService bookService = ac.getBean("bookServiceConstructor", BookService.class);
        System.out.println(bookService.findAllBook());
    }
}
