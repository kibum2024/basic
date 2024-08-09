package com.firewind.basic.boundedContext.member.repository;

import com.firewind.basic.boundedContext.member.entity.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository //@Component와 같음
public class MemberRepository {
    private List<Member> members;

    public MemberRepository() {
        members = new ArrayList<>();
        members.add(new Member("user1", "1231"));
        members.add(new Member("user2", "1232"));
        members.add(new Member("user3", "1233"));
        members.add(new Member("user4", "1234"));
        members.add(new Member("user5", "1235"));
        members.add(new Member("user6", "1236"));
        members.add(new Member("user7", "1237"));
    }

    public Member findByUserName(String username) {
        return members.stream()
                .filter(member -> member.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }
}
