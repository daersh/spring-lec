package com.section01.autowired.subsection01.field;


import com.section01.common.BookDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        /*설명.
            * AnnotationConfigApplicationContext 생성자에 basePackages 문자열을 전달하여 ComponentScan 개념을
            * 따로 설정 클래스 없이 바로 적용할 수도 있다.
        * */
        ApplicationContext ac = new AnnotationConfigApplicationContext("com.section01");
        BookService bookService = ac.getBean("bookService", BookService.class);
        List<BookDTO> list =  bookService.findAllBook();
        //설명. 저장되어 있는 도서 전부 출력
        bookService.findAllBook().forEach(System.out::println);

        //설명. 특정 sequence의 도서 정보 출력
        System.out.println(bookService.searchBookBySequence(1));
        System.out.println(bookService.searchBookBySequence(2));


    }
}
