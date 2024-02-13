package com.section01.common;

import java.util.List;

public interface BookDAO {

    List<BookDTO> findAllobook();

    BookDTO searchBookBySequence(int sequence);
}
