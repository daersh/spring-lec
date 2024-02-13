package section03.annotationconfig.subsection01.java;

import com.common.MemberDAO;
import com.common.MemberDTO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//중요. @Configuration: 이 클래스는 스프링이 참고하는 설정용 클래스임을 나타냄
// 설정용 클래스도 빈으로 설정도 가능하다 -> ("bean id")추가하면 됨
@Configuration("configurationSection03")
// 설명 1.단순히 범위 지정만으로 @Component 계열의 어노테이션들을 모두 빈으로 관리하는 경우
//@ComponentScan(basePackages = "com")  // 이범위 안에 하위 모든 클래스들에 대해서 어노테이션을 체크하여 bean으로 관리한다.
// 설명 2. 범위 및 필터를 적용해서 빈을 관리하는 경우(exclude)
@ComponentScan(basePackages = "com",
                excludeFilters = {
                        @ComponentScan.Filter(
                            /*설명. 2-1. 타입으로 설정*/
//                            type = FilterType.ASSIGNABLE_TYPE,
//                                classes = {MemberDAO.class}
                            /*설명 2-2. 어노테이션 종류로 설정*/
//                            type = FilterType.ANNOTATION,
//                                classes = {org.springframework.stereotype.Repository.class}
//                            /*설명 2-3. 표현식으로 설정(section03에 있는 ContextConfiguration 제외) 이건 왜그런지 안됨 */
//                            type= FilterType.REGEX,
//                                pattern = {"com.section03.annotationconfig.subsection01.*"}
                        )
                })
// 설명 3, 범위 필터 적용하여 빈을 관리하는 경우 (include)
@ComponentScan(basePackages = "com",
        includeFilters ={
                @ComponentScan.Filter(
                    type = FilterType.ASSIGNABLE_TYPE,
                        classes = {MemberDTO.class}
                )
        })

/* 설명.
    * @ComponentScan은 필터의 경우 개념 정도만 알아도 되지만 기본적으로 @Configuration 클래스가 위치한 패키지와
    * 해당 패키지 하위만 스캔하기 때문에 더 상위 범위나 다른 패키지를 스캔하기 위해 주로 사용된다.
* */

public class ContextConfiguration {

}
