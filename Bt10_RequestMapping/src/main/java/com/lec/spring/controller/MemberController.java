package com.lec.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member") // 이 이하는 /member 이하로 붙여짐 ; 앞부분 경로를 공통적으로 붙여줄 수 있다
public class MemberController {

    @RequestMapping("/save") //-> /member/save (URL)
    public String saveMember(){
        return "member/save";
    }

    // handler return type = void
    // mapping 되는 url 에 해당하는 view 파일이 리턴
    @RequestMapping("/load")
    public void loadMember(){ // 일반적으로 많이 사용 !
        // return "/member/load" ; 와 동일
    }

//    @RequestMapping("/search")
//    public void searchMember(){
//
//    } -> HomeController 에 searchMember 가 존재 -> 동일한 url 존재 -> url mapping 이 중복되면 error !

    // handler return type : String, ModelAndView, void

}
