package section02.xmlConfig;

import com.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
/**<h1>xml방식 컨테이너</h1>
 * GenericXmlApplicationContext("xml경로") <br>
 * resources파일이 루트이다!!!
 * */
public class Application {

    public static void main(String[] args) {

        ApplicationContext ac = new GenericXmlApplicationContext("section02_xmlconfig/spring-context.xml");
        MemberDTO memberDTO = (MemberDTO) ac.getBean("member");
        System.out.println("memberDTO = " + memberDTO); // 결과. memberDTO = MemberDTO(sequence=1, id=user01, pwd=pass01, name=홍길동)

    }
}
