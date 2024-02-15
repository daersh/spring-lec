package com.section02.reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class Application {

    /**
     * <h1>Reflection</h1>
     * 컴파일된 자바 코드에서 역으로 클래스를 불러 메소드 및 필드 정보를 구해오는 방법이다. 스프링 프레임워크, Mybatis, 하이버네이트,
     * Jackson 등의 라이브러리에서 사용된다. 스프링에서는 런타임 시 개발자가 등록한 빈을 애플리케이션 내에서 사용할 수 있도록 하는 기술이기도 하다.
     * <br>
     * <br>
     * <h2><b>refleciton은 강력한 도구이지만 무분별하게 사용하면 안된다.</b></h2>
     * <h3>이유</h3>
     * @1.오버헤드발생: 성능 저하를 발생할 수 있기 때문에 민감한 애플리케이션에서는 사용하지 않는다.
     * @2.캡슐화저해: private로 설정한 member(또는 필드)에 접근 가능하기 때문에 코드 기능이 저하되며 여러가지 문제를 야기할 수 있다.
     * */


    public static void main(String[] args) {
        /* 목차 1.Class 타입의 Class 메타 정보 추출해보기        * */
        Class class1 = Account.class;
        System.out.println("class1= "+class1);          // 결과: class1= class com.section02.reflection.Account

        Class class2 =new Account().getClass();
        System.out.println("class2 = " + class2);       //결과: class2 = class com.section02.reflection.Account

        try {
            Class class3 = Class.forName("com.section02.reflection.Account");
            System.out.println("class3 = " + class3);   //결과: class3 = class com.section02.reflection.Account
            Class class4 = Class.forName("[D");
            System.out.println("class4 = " + class4);       //결과: class4 = class [D
            Class class5 = double[].class;
            System.out.println("class5 = " + class5);       //결과: class5 = class [D

            Class class6 = Class.forName("[Ljava.lang.String;");    //참고. " ;"들어가야함.
            Class class7 = String[].class;
            System.out.println("class6 = " + class6);
            System.out.println("class7 = " + class7);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // 목차 2. 필드 정보 추출
        Field[] fileds = Account.class.getDeclaredFields();
        for(Field field : fileds){
            System.out.println("modifiers: "+ Modifier.toString(field.getModifiers())
                                + ", type:" + field.getType()
                                + ", name: "+ field.getName()
                                + ", class: " + field.getClass()
                    );
        }

        // 목차 4. 생성자 정보 추출
        Constructor[] constructors = Account.class.getConstructors();       // 설명. Account 클래스의 생성자들이 배열로 담김
        for (Constructor constructor : constructors){
            System.out.println("name: "+ constructor.getName());
            Class[] params = constructor.getParameterTypes();
            for (Class param: params){
                System.out.println("paramType: "+param.getTypeName());
            }
        }
        try {
            //설명. 저장된 생성자에 새로운 인스턴스(객체)생성해서 전달함
            Account acc = (Account) constructors[0].newInstance("20","110-223-123456","1234",10000);
            System.out.println(acc.getBalance());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // 목차 5. 메소드 정보 추출
        System.out.println("---------------------------chap5-----------------------");
        Method[] methods = Account.class.getMethods();
        Method getBalanceMethod = null;
        for (Method method : methods) {
            System.out.println(Modifier.toString(method.getModifiers()) + " " + method.getReturnType().getSimpleName()+ " "
                                                    + method.getName());
            if("getBalance".equals(method.getName())){
                getBalanceMethod = method;
            }
        }
        try {
            System.out.println(getBalanceMethod.invoke((Account)constructors[2].newInstance()));
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}
