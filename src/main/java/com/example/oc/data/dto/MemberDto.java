package com.example.oc.data.dto;

import com.example.oc.data.entity.Member;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MemberDto {
    private Long id; // 유저 아이디
    private String name; // 이름
    private String email; // 이메일
    private String picture; // 사진
    private String age; // 나이
    private String gender; // 성별

    public Member toEntity() {
        return Member.builder()
                .id(id)
                .name(name)
                .email(email)
                .picture(picture)
                .age(age)
                .gender(gender)
                .build();
    }
}
