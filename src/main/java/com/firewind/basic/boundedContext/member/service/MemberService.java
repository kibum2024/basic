package com.firewind.basic.boundedContext.member.service;

import com.firewind.basic.boundedContext.base.rsData.RsData;
import com.firewind.basic.boundedContext.member.entity.Member;
import com.firewind.basic.boundedContext.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//Component : 아래 클래스는 Ioc 컨테이너에 의해 생사소멸관리된다.
//Service : Component와 같은 의미, 가독성을 위해서 사용 MemberService가 service 클래스이므로 직관적으로 알 수 있다.
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    //@Autowired 스프링부트 3버전부터 생략가능
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    public RsData tryLogin(String username, String password) {
        Member member = memberRepository.findByUserName(username);

        if (member == null) {
            return RsData.of("F-1", "%s(은)는 존재하지 않은 회원입니다.".formatted(username));
        }

        if (!member.getPassword().equals(password)) {
            return RsData.of("F-2", "비밀번호가 일치하지 않습니다.".formatted(username));
        }

        return RsData.of("S-1", "%s님 환영합니다.".formatted(username));
    }
}
