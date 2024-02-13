package com.section02.javaconfig;

import com.common.Account;
import com.common.MemberDTO;
import com.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//설명. bean 어떻게 관리할지 저장하는 클래스이다.
@Configuration
public class ContextConfiguration {
    @Bean
    public Account accountGenerator(){
        return new PersonalAccount(20,"110-123-1234");
    }

    @Bean
    public MemberDTO memberGenerator(){
        /*설명 1. 메소드에서 반환한 값(Account bean)을 setter 주입*/
//        MemberDTO member = new MemberDTO();
//        member.setSequence(1);
//        member.setName("홍길동");
//        member.setPhone("010-1234-1234");
//        member.setEmail("hong12@gmail.com");
//        member.setPersonalAccount(accountGenerator());
//        return member;

        /* 설명 2. 메소드에서 반환한 값을 생성자 주입 */
        return new MemberDTO(1,"홍길동","010-1234-1234","hong@gmail.com",accountGenerator());
    }
}
