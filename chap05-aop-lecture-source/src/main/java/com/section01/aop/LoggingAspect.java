package com.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    /*
    * 설명.
        *  타겟 클래스의 메소드에서 어드바이스를 적용할 수 있는 지점들을 조인포인트라 한다.
        * 포인트컷은 여러 조인포인트들에 어드바이스를 적용할 곳을 지정한 것이다.
        * 해당 조인포인트에서 어드바이스가 동작한다.
        *
        * <포인트컷 표현식>
        * execution([수식어]리턴타입 [클래스이름].이름(파라미터))
        * 1. 수식어: public, private 등 수식어 명시(생략 가능)
        * 2. 리턴타입: 리턴 타입 명시
        * 3. 클래스 이름(패키지명 포함) 및 메소드 이름: 클래스이름과 메소드 이름 명시
        * 4. 파라미터(매개변수): 메소드 파라미터 명시
        * 5."*" : 1개이면서 모든 값이 올 수 있음
        * 6. "..": 0개 이상 모든 값 올 수 있음
        *
        * ex)
            * execution(* com.section01.aop.*Service.*(..))
                * -> com.section01.advice 패키지에 속해 있는 다음 하위 클래스에 파라미터가 1개인 모든 메소드이자 접근제어자가
                   * public이고, 반환형이 Integer인 경우
            * executiom(* com.section01.advice.annotation..stu*(..))
                * -> com.section01.advice 패키지 및 하위 패키지에 속하고 이름이 stu로 시작하는 파라미터가 0개 이상인
                   * 모든 메소드이며 접근제어자의 반환형은 상관없다.
    * */

    @Pointcut("execution(* com.section01.aop.*Service.*(..))")
    public void logPointcut(){}

//    @Before("execution(* com.section01.aop.*Service.*(..))")
    @Before("LoggingAspect.logPointcut()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("Before Advice 동작");
    }

}
