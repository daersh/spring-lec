package com.section01.aop;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberService {

    private final MemberDAO memberDAO;

    public MemberService(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    public List<MemberDTO> findAllMembers() {   // 참고. primary concern 여기에 기능을 추가하려면 프록시로 감싸야한다.
                                                //  이를 통해 기술 추가하면 aspect이다?
        return memberDAO.selectAllMembers();
    }

    public MemberDTO findMemberBy(long id) {
        return memberDAO.selectMemberBy(id);
    }
}
