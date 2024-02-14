package com.section03.properties.subsection02.i18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.Locale;

/*
* Globalization: 세계화
* internationalization: i n 사이 18글자 국제화. 외국에 대한 처리를 미리 고려한 것
* Localization: 현지화. 나라에 맞춰 프론트 빽까지 다 한 것
* */
public class Application {
    public static void main(String[] args) {
        /*설명.
            * i18n 소프트웨어의 국제화(International에서 첫 글자인 I와 마지막 글자인 n 사이 알파벳 개숫가 18개)란?
                * 1. 언어, 지역별 번역
                * 2. OS/Platform별 인코딩
                * 3. 문자열 치환 방법
                * 4. 국제화 UI(문자열 크기 변화, 폰트, 아이콘 )
                * 5. 쓰기 방향의 차이
                * 6. 숫자, 공백, 화폐, 날짜, 주소, 측정 단위 등
                * 7. 타임존, 섬머타임 등 시각
                * 8. 문자열 정렬 방법
            * 우리가 다뤄본 예제는 그 중에서 1번에 대한 다국어 메시지 처리만 살펴본 것이다.
            *
        * */
        ApplicationContext ac = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        String error404MessageKR = ac.getMessage("error.404",null, Locale.KOREA);
        String error500MessageKR = ac.getMessage("error.500",new Object[]{"여러분",new Date()},Locale.KOREA);

        System.out.println("error404MessageKR = " + error404MessageKR);
        System.out.println("error500MessageKr = " + error500MessageKR);
    }

}
