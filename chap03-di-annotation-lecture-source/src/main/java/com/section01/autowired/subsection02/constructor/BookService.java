package com.section01.autowired.subsection02.constructor;

import com.section01.common.BookDAO;
import com.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "bookServiceConstructor") // = ("bookServiceConstructor") 생략 가능
public class BookService {
/**<h1>생성자 주입</h1>
     *  BookDAO 타입의 빈 객체를 생성자를 통해 주입 받는다.<br>
     *  Autowired를 생성자에 작성하고 주입받을 타입의 bean을 매개변수로 작성한다.<br>
     * 중요. 기본 생성자로는 불가능하다<br>
     *  @장점
        * @1. 필드에 final 키워드를 사용할 수 있다.
        * @2. 순환 참조를 스프링 시작(컨테이너 생성 시)과 동시에 확인하여 에러를 띄울 수 있다.
        * @3. 중간에 값이 오염되지 않음을 확신하고 사용할 수 있다.(불변성)
        * @4. 테스트 코드 작성 시 테스트 코드에 @Autowired 또는 주입받는 대상의 setter 등을 추가하지 않고 순수 자바코드로 테스트 가능하다.
     * */
    private final BookDAO bookDAO;  // 필드 주입할 시 매번 @Autowired를 다 붙여야 함
    @Autowired
    public BookService(BookDAO bookDAO) { this.bookDAO = bookDAO; }
    public List<BookDTO> findAllBook(){return bookDAO.findAllobook();}
    public BookDTO searchBookBySequence(int sequence){return bookDAO.searchBookBySequence(sequence);}
}
