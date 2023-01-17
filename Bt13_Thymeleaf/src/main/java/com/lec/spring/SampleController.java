package com.lec.spring;

import com.lec.spring.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
public class SampleController {

    @RequestMapping("/sample1")
    public void sample1(Model model){
        model.addAttribute("greeting", "Hello Thymeleaf");
    }

    @RequestMapping("/sample2")
    public void sample2(Model model){
        Member member = new Member(123, "u00", "p00", "Daniel", LocalDateTime.now());

        model.addAttribute("m",member);
        System.out.println(model.getAttribute("m"));
        System.out.println(model.getAttribute("aaa")); // 없는 attribute 를 꺼내려 하면 null return
    }

}
