package com.lec.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member") // 이 이하는 /member 이하로 붙여짐 ; 앞부분 경로를 공통적으로 붙여줄 수 있다
public class MemberController {

//    @RequestMapping("/save") -> /member/save (URL)
}
