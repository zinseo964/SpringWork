package com.lec.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    public HomeController(){
        System.out.println(getClass().getName() + "() Created ");
    }

    @RequestMapping("/home")
    public void home(){

    }
}
