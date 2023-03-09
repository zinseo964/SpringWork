package com.lec.spring.Bt60_JPA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
    @GetMapping("/helloworld")
    @ResponseBody
    public String helloworld(){
        return "hello-world";
    }
}
