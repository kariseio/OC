package com.example.oc.service;

import com.example.oc.data.entity.Member;
import com.example.oc.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {
    private final MemberRepository userRepository;

    @Autowired
    public MemberService(MemberRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long join(Member member) {
        validateDuplicateUser(member);
        userRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateUser(Member member) {
        userRepository.findByName(member.getName())
                .ifPresent(u -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findUsers() {
        return userRepository.findAll();
    }

    public Optional<Member> findOne(Long userId) {
        return userRepository.findById(userId);
    }
}
