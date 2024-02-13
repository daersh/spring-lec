package com.section02.javaconfig;

import com.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        MemberDTO member = ac.getBean(MemberDTO.class);

        System.out.println("member = " + member);
        //결과 member = MemberDTO(sequence=1, name=홍길동, phone=010-1234-1234, email=hong12@gmail.com, personalAccount=com.common.PersonalAccount@3835c46)
        
    }
}
