package com.section01.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext("com.section01.aop");

        MemberService memberService = ac.getBean("memberService",MemberService.class);

        System.out.println("++++++++++++ select all members ++++++++++++");
        /*설명. findAllMembers() 호출 이후 AfterReturning Advice 가 회원 한명을 추가하니 아래 예외 테스트 시 주석할 것*/
        List<MemberDTO> members = memberService.findAllMembers();
        members.forEach(System.out::println);

        System.out.println("++++++++++++ select one members ++++++++++++");
        System.out.println(memberService.findMemberBy(0));
        System.out.println(memberService.findMemberBy(1));
        /*설명. 2번을 호출하여 의도적으로 에러 발생시키기 위함*/
//        System.out.println(memberService.findMemberBy(2));
    }
}
