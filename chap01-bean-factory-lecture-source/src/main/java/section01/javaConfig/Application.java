package section01.javaConfig;

import com.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 목표<br><br>
 *  스프링은 빈 객체를 관리하고 생성하는 컨테이너이다. == IoC
 *  빈 생성 3가지 방식
 *  <ul>
 *  1. @Configuration으로 bean을 만드는 방식<br>
 *  2.
 *  3.
 *
 *  </ul>
 *  <br>
 */
public class Application {
    // 중요. 스프링 컨테이너 구동 원리 면접 준비 해둘 것

    public static void main(String[] args) {
        // 설명. 컨테이너 박스 생성
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

//        String[] beanNames = context.getBeanDefinitionNames();
//        for (String beanName : beanNames) {
//            System.out.println("beanNames:"+ beanName);
//        }


//목차. bean 의 데이터를 가져오는 3가지 방식
        /*목차 1. bean id를 이용하여 bean을 가져오기 */
        MemberDTO members = (MemberDTO) context.getBean("member"); // 참고. 기본 타입이 Object이기 떄문에 다운캐스팅 필요!
        System.out.println("members = " + members);   //결과:  members = MemberDTO(sequence=1, id=user01, pwd=pass01, name=홍길동)

        /*목차 2. bean 클래스 메타 정보를 전달하여 가져오기 (bean 의 타입을 전달하는 방식)*/
        MemberDTO members2 = context.getBean(MemberDTO.class);      //참고. 만약 같은 타입의 빈이 여러개면????
        System.out.println("members2 = " + members2); //결과: members2 = MemberDTO(sequence=1, id=user01, pwd=pass01, name=홍길동)

        /*목차 3. bean id 와 클래스 메타 정보를 전달하여 가져오기 - 완벽하게 꺼내는 방법!*/
        MemberDTO members3 = context.getBean("member", MemberDTO.class);
        System.out.println("members3 = " + members3); //결과: members3 = MemberDTO(sequence=1, id=user01, pwd=pass01, name=홍길동)
    }
}
