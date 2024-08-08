package com.firewind.basic.boundedContext.member.service;

import com.firewind.basic.boundedContext.base.rsData.RsData;

public class MemberService {
    public RsData tryLogin(String username, String password) {
        if (!username.equals("user1")) {
            return RsData.of("F-1", "%s(은)는 존재하지 않은 회원입니다.".formatted(username));
        }
        else if (!password.equals("1234")) {
            return RsData.of("F-2", "비밀번호가 일치하지 않습니다.".formatted(username));
        }

        return RsData.of("S-1", "%s님 환영합니다.".formatted(username));
    }
}
