package com.lec.spring.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Long id;

    private String username;   // 회원 아이디
    private String password;   // 회원 비밀번호

    @ToString.Exclude
    private String re_password;  // 비밀번호 확인 입력

    private String name;   // 회원 이름
    private LocalDateTime regDate;

    @ToString.Exclude
    @Builder.Default
    private List<Authority> authorities = new ArrayList<>();

    public void addAuthority(Authority... authorities){
        if(authorities != null){
            Collections.addAll(this.authorities, authorities);
        }
    }
}








