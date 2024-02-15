package com.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Pointcut("execution(* com.section01.aop.*Service.*(..))" )
    public void logPointcut(){}

    /*목차 1. Before Advice*/
//    @Before("execution(* com.section01.aop.*Service.*(..))")
    @Before("LoggingAspect.logPointcut()")
    public void logBefore(JoinPoint joinPoint){
//        System.out.println("Before Advice 동작");
        System.out.println("    Before joinPoint.getTarget(): "+ joinPoint.getTarget());        //
        System.out.println("    Before joinPoint.getSignature(): "+ joinPoint.getSignature());  //결과 타겟으로 삼고 있는 메서드 출력

        if(joinPoint.getArgs().length>0){       //설명. 타겟 메소드의 매개변수가 하나 이상이면 실행
            System.out.println("    Before joinPoint.getArgs()[0]: "+joinPoint.getArgs()[0]);
        }
    }


    /*목차 2. After Advice*/
    @After("LoggingAspect.logPointcut()")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("    After joinPoint.getTarget(): "+ joinPoint.getTarget());
        System.out.println("    After joinPoint.getSignature(): "+ joinPoint.getSignature());
        if(joinPoint.getArgs().length>0){
            System.out.println("    After joinPoint.getArgs()[0]: "+joinPoint.getArgs()[0]);
        }
    }

    /*목차 3. AfterReturning Advice*/
    /*필기 1. Pointcut에 해당하는 위치가 담긴 메소드가 같은 클래스에 있으면 클래스 소속을 안적어도 된다! Before, After도 해당
        * 2. returning에 쓰인 이름이 반환값이 넘어오는 매개변수명과 일치해야 한다.(result)
       * 목표
        * findAllMembers 메서드를 뽑아서 프록시로 감싸고 새로운 회원을 추가해보기
        * */
    @AfterReturning(pointcut = "logPointcut()",returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result){
        System.out.println("After Returning result: "+ result);

        /*설명.  AfterReturning Advice를 통한 반환값 가공도 가능하다*/
        if(result!=null && result instanceof List){
            ((List<MemberDTO>)result).add(new MemberDTO(3L,"반환 값 가공"));
        }
    }

    /*목차 4. AfterTrhowing Advice*/
    /*필기. throwing 속성 값과 매개변수명이 일치해야 한다.(exception)*/
    @AfterThrowing(pointcut = "logPointcut()", throwing = "exception")
    public void logAfterThrowing(Throwable exception){
        System.out.println("After Throwing exception: "+ exception);
    }

    /*목차 5. Around*/
    /*필기.
        * 이 어드바이스는 조인포인트를 완전히 장악하기 때문에 앞서 살펴 본 어드바이스 모두 Around 어드바이스로 조립할 수 있다.
        * 심지어 원본 조인 포인트를 언제 싫행할 지, 실행 자체를 안할지, 게속 실행할지 여부까지도 제어한다.
        * AroundAdvice의 조인포인트 매개변수는 ProceedingJoinPoint 로 고정되어 있다.
        * JoinPoint 의 하위 인터페이스로 원본 조인포인트의 진행 시점을 제어할 수 있다.
        * 조인포인틀를 진행하는 호출을 잊는 경우가 자주 발생하기 때문에 주의해야 하며 가능한 최소한의 요건을 충족하면서 가장 기능이 약한 어드바이스를 쓰는게 바람직하다.
            -> Around 남용하지 말자~!
        * 참고. 이걸로 시간 속도 측정을 하는 기능 할 수 있다.!
    * */
    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint)throws Throwable{
        System.out.println("** Around Before: "+joinPoint.getSignature().getName());

        Object result = joinPoint.proceed();    // 설명. 타겟 메소드 동작. reflection에서 invoke 시키는 것과 연관짓는 거 공부

        System.out.println("** Around After: "+joinPoint.getSignature().getName());

        /*설명. 실행된 타겟 메소드 반환(다른 어드바이스가 다시 실행할 수 있도록 반환한다.)*/
        return result;
    }



}
