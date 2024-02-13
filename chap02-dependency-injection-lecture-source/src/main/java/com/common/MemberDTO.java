package com.common;

import lombok.*;

@NoArgsConstructor@AllArgsConstructor       //기본생성자, 매개변수가지는 생성자 어노테이션
@Getter@Setter@ToString
public class MemberDTO {
    private int sequence;
    private String name;
    private String phone;
    private String email;
    private Account personalAccount;   //개인 계좌. 스프링 진행하면서 new가 안들어가도록 변경됨
}
