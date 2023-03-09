package com.lec.spring.Bt60_JPA.repository;

import com.lec.spring.Bt60_JPA.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest     // Spring context 를 loading 하여 test 에 사용
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void crud(){
        System.out.println("\n -- TEST # crud() ----------------------------------");
        User user = new User();
        System.out.println(user);
        userRepository.save(user);
        System.out.println(">>> " + userRepository.findAll());
        System.out.println("-------------------------------------------------------");
    }
}