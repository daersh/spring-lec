package section03.annotationconfig.subsection02.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext ac = new GenericXmlApplicationContext("section03/annotationconfig/subsection02/xml/spring-context.xml");
        String[] beanNames = ac.getBeanDefinitionNames();
        for(String beanName: beanNames){
            System.out.println("beanName = " + beanName);
        }
    }
}
