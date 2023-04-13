package com.example.oc.data.entity;

import com.example.oc.data.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 유저 아이디

    @Column
    private String name; // 이름

    @Column
    private String email; // 이메일

    @Column
    private String picture; // 사진

    @Column
    private String age; // 나이

    @Column
    private String gender; // 성별

    @Enumerated(EnumType.STRING)
    @Column
    private Role role; // 역할

    @Builder
    public Member(String name, String email, String picture, Role role) { // 로그인용 생성자
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public MemberDto toDto() {
        return MemberDto.builder()
                .id(id)
                .name(name)
                .email(email)
                .picture(picture)
                .age(age)
                .gender(gender)
                .build();
    }

    public Member update(String name, String picture) { // 업데이트
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey() { // 역할 가져오기
        return this.role.getKey();
    }
}
