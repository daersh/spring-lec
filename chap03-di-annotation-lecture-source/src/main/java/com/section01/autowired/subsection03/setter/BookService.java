package com.section01.autowired.subsection03.setter;

import com.section01.common.BookDAO;
import com.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookServiceSetter")
public class BookService {
    private BookDAO bookDAO;
    @Autowired
    // 설명. 옛날에 많이 쓰던 방식이나 지금은 안쓴다.
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }
    public List<BookDTO> findAllBook(){return bookDAO.findAllobook();}
    public BookDTO searchBookBySequence(int sequence){return bookDAO.searchBookBySequence(sequence);}
}
