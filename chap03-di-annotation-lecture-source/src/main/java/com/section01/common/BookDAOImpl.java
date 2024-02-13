package com.section01.common;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookDAOImpl implements BookDAO{
    private Map<Integer,BookDTO> bookList;

    public BookDAOImpl() {
        bookList = new HashMap<>();
        bookList.put(1,new BookDTO(1,123456,"자바의 정석","남궁성","도우출판",new Date()));
        bookList.put(2,new BookDTO(2,223344,"칭찬은 고래도 춤추게 한다.","고래","고래출판",new Date()));
    }

    @Override
    public List<BookDTO> findAllobook() {
        return new ArrayList<>(bookList.values());  // 중요. HashMap의 값만 뽑아 ArrayList로 반환하기 위한 방법!    Map to List!!
    }

    @Override
    public BookDTO searchBookBySequence(int sequence) {
        return bookList.get(sequence);
    }
}
