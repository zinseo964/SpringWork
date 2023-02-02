package com.lec.spring.repository;

import com.lec.spring.domain.Authority;
import com.lec.spring.domain.User;

import java.util.List;

public interface AuthorityRepository {
    Authority findByName(String name); // 특정 이름의 권한정보 읽어오기

    List<Authority> findByUser(User user); // 특정 사용자의 권한(들) 읽어오기

    int addAuthority (Long user_id, Long auth_id); // 특정 사용자에 권한 추가


}
