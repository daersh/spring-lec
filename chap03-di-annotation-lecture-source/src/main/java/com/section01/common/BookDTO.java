package com.section01.common;
import lombok.*;
import java.util.Date;

@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class BookDTO {
    private int sequence;
    private int isbn;
    private String title;
    private String author;
    private String publisher;
    private Date createdDate;
}
