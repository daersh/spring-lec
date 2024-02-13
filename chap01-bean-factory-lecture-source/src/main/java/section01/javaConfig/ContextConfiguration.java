package section01.javaConfig;

import com.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {
    //설명. bean 어떻게 관리할지 저장하는 클래스이다.
    @Bean(name="member")
    public MemberDTO getMember(){
        return new MemberDTO(1,"user01","pass01","홍길동");
    }

}
