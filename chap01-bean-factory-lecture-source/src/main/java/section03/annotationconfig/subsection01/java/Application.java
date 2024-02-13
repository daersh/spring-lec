package section03.annotationconfig.subsection01.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <h1>Annotation을 사용한 방식</h1><br>
 * ComponentScan 과 관련하여 자바 클래스와 xml 방식으로 사용하는 방법을 확인할 것이다. <br>
 * 이 중에서도 자바 클래스와 @ComponentScan 방식을 자주 사용한다.<br>
 *
 */

public class Application {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        String[] beanNames = ac.getBeanDefinitionNames();
        for(String beanName: beanNames){
            System.out.println("beanName = " + beanName);
            /*  beanName = org.springframework.context.annotation.internalConfigurationAnnotationProcessor
                beanName = org.springframework.context.annotation.internalAutowiredAnnotationProcessor
                beanName = org.springframework.context.event.internalEventListenerProcessor
                beanName = org.springframework.context.event.internalEventListenerFactory
                beanName = contextConfiguration
                beanName = member */
        }
    }
}
