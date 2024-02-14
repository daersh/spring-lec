package com.section01.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext("com.section01.aop");

        MemberService memberService = ac.getBean("memberService",MemberService.class);

        System.out.println("++++++++++++ select all members ++++++++++++");

        List<MemberDTO> members = memberService.findAllMembers();
        members.forEach(System.out::println);

        System.out.println("++++++++++++ select one members ++++++++++++");
        MemberDTO member = memberService.findMemberBy(1L);
        System.out.println("member = " + member);
    }
}
