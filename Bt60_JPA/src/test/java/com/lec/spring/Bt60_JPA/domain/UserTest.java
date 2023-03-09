package com.lec.spring.Bt60_JPA.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void test(){
        User user = new User();
        user.setEmail("martin@gmail.com");
        user.setName("martin");
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        User user2 = new User("martin", "martin@gmail.com");

        User user3 = User.builder()
                .name("martin")
                .email("martin@gmail.com")
                .build();

        System.out.println(">>> " + user.toString());
    }

}