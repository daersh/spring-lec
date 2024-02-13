package com.section01.xmlconfig;

import com.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * <h1> </h1>
 *
 */
public class Application {
    public static void main(String[] args) {
        ApplicationContext ac = new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");
        MemberDTO member = ac.getBean("member", MemberDTO.class);

        /*설명. 컨테이너가 관리 중인 MemberDTO 타입의 빈에 은행 코드 20번인 PersonalAccount 객체가 주입 되어 있음을 확인할 수 있다.*/
        System.out.println("member = " + member);
        //결과 member = MemberDTO(sequence=1, name=홍길동, phone=010-1234-1234, email=hong123@gmail.com, personalAccount=com.common.PersonalAccount@1a052a00)
        System.out.println("member.getPersonalAccount() = " + member.getPersonalAccount());
        /*설명. member bean이 가진 계좌 객체의 기능을 통해 입출급, 조회 진행*/
        System.out.println(member.getPersonalAccount().deposit(10000));
        System.out.println(member.getPersonalAccount().getBalance());
        System.out.println(member.getPersonalAccount().witDraw(5000));
        System.out.println(member.getPersonalAccount().getBalance());

    }
}
