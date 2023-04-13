package com.example.oc.service;

import com.example.oc.data.entity.Member;
import com.example.oc.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository userRepository;


    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("hello");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void findUsers() {
    }

    @Test
    void findOne() {
    }
}