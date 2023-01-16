package com.lec.spring.di06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public UserService() {
        System.out.println("UserService() Created !");
    }

}
