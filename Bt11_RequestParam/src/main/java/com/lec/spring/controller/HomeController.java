package com.lec.spring.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class HomeController {
    @RequestMapping("/member/delete")
    public void delMember(HttpServletRequest request, Model model){ // 전통적인 방법 !
        String id = request.getParameter("id"); // "id" 란 이름의 parameter 값 return
        System.out.println("id : " + id);

        String age = request.getParameter("age"); // getParameter 값이 없을때는 null return
        System.out.println("age : " + age);

        model.addAttribute("mdId", id); // parameter 값이 없으면 null, error 는 아님
        model.addAttribute("mdAge", age);

        String num = request.getParameter("num");
        System.out.println("num : "+ num); // parameter 여러개 올 수 있지만 입력 받는 것은 첫번째 값 !

        // 동일한 name parameter 가 여러개인 경우
        String[] arrNum = request.getParameterValues("num"); // String 형 배열을 return
        System.out.println("arrNum : "+ Arrays.toString(arrNum));
    }

    @GetMapping("/member/register")
    public void registerMember(){

    }

    @RequestMapping("/member/regOk") // 어떤 방식의 request 든지간에 url mapping 가능
    public void regOk(HttpServletRequest request){
        System.out.println("member/regOk : "+ request.getMethod());
        String name = request.getParameter("name"); // input name 의 name 을 의미
    }
}
