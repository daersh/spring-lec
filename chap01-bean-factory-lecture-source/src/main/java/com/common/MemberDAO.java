package com.common;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>DAO CLASS</h1>
 * DAO 란? <br>
 * <ul>
 *     <li>Data Access Object를 줄인 말로 레포지토리 계층과 마찬가지로 자바 애플리케이션과 DB를 연동시켜 주기 위한 계층의 클래스로 활용된다.
 *     <li>DB와 연동하기 위한 객체이다.
 *     <li>DAO와 repository는 같은 거라 생각해도 된다~!
 * </ul>
 */
/*설명. DB와 연동하기 위해 사용되는 클래스에 추가하는 어노테이션으로 bean으로 관리될 수 있게 어노테이션을 추가한다.*/
@Repository //설명. 레포는 @Component 에 추가 기능이 있는 것이다.
//@Component  //설명. 이것만 있어도 콩으로 관리될 수 있다. @Component는 클래스에 계층의 의미가 없이(추가 기능 없이) 단순히 bean으로 관리될 때 사용한다.
public class MemberDAO {

    private final Map<Integer, MemberDTO> memberMap;

    public MemberDAO() {
        memberMap= new HashMap<>();
        memberMap.put(1,new MemberDTO(1,"user01","pass01","홍길동"));
        memberMap.put(2,new MemberDTO(2,"user02","pass02","유관순"));
    }

    /*설명. 회원 조회용 메소드*/
    public MemberDTO selectMember(int sequence){
        return memberMap.get(sequence);
    }
    /*설명. 회원 가입용 메소드*/
    public int insertMember(MemberDTO memberDTO){
        int before = memberMap.size();
        memberMap.put(memberDTO.getSequence(),memberDTO);
        int after = memberMap.size();
        return after - before;
    }

}
