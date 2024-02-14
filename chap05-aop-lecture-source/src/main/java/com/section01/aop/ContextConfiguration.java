package com.section01.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)    //결과. 이를 통해 Aspect 적용 가능해짐
public class ContextConfiguration {

}
