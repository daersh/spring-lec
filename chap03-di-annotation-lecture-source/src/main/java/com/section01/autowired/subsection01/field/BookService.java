package com.section01.autowired.subsection01.field;

import com.section01.common.BookDAO;
import com.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {


    /**
     * <h2>아래 3가지는 ComponentScan 범위 안에 어노테이션들이 달렸을 때 유효하다.</h2>
     * <ul>
     * 1. @Service에 의해서 BookService 타입의 bookService bean이 관리된다.<br>
     * 2. BookDAOImpl에 있는 @Repository 에 의해 BookDAOImp 빈이 관리된다 (BookDAO 타입이기도 하다.)<br>
     * 3. @Autowired에 의해 BookDao 타입의 빈이 BookService의 필드인 bookDAO 필드에 주입된다.<br>
     * </ul>
     * */
    @Autowired  // 필드에 autowired를 달아 필드 주입이라 한다.
    private BookDAO bookDAO;  // = new BookDAOImpl();   //설명. ComponentScan 범위 안에 BookDAO 타입의 빈이 대입된다.

    /*목차 1. 도서 목록 전체 조회*/
    public List<BookDTO> findAllBook(){
        return bookDAO.findAllobook();
    }
    /*목차 2. */
    /*목차 3. 도서 목록 전체 조회*/

}
