package com.lec.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.Random;

@Controller // Spring MVC -> Controller 역할을 하는 Bean 객체
public class HomeController {

    public HomeController() {
        System.out.println(" ------------------- ");
        System.out.println(getClass().getName() + "Created !");
    }

    // Controller 안에는 request를 처리(handle) 하는 메소드들을 정의한다
    // 이러한 메소드들을 'handler' 라 한다.
    // handler 는
    //  - '어떠한 request' 를 받아서,
    //  - '어떠한 처리 (business logic)' 를 하고
    //  - '어떠한 response' 를 할지를 정의

    @RequestMapping("/") //  "/" 라는 url 로 request 라 오면 아래 메소드가 처리(handle) 한다
    public String now(Model model) {
        LocalDateTime t = LocalDateTime.now();
        model.addAttribute("serverTime", t.toString());
        return "home"; //view return
    }
    @RequestMapping("/aaa")
    public String home(Model model) {
        int a = new Random().nextInt(10);
        int b = new Random().nextInt(5);
        model.addAttribute("first", a);
        model.addAttribute("second",b);
        return "aaa/my";
    }
}
