package com.lec.spring;

import jakarta.servlet.http.HttpServletRequest; // jakarta ? java 를 쓸 수 없어서 다른 이름 .. 을 .. 사용 ..
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class HomeController {

    // URL -> Handler mapping,
    // url, handler 이름, 뷰 이름  ← 꼭 같은 필요는 없다.
    //      (그러나, 일반적으로는 같거나 동일한 맥락으로 작명한다)


    // HttpServletRequest 객체 (request 객체)
    // request -> url, parameter, cookie, header ,...
    @RequestMapping("/common")
    public String pathCommon(HttpServletRequest request, Model model){
        System.out.println("pathCommon() Called ! ");
        String uri = request.getRequestURI();
        String conPath = request.getContextPath();

        // WAS Path : http://domain/context-path/ ...

        model.addAttribute("uri", uri);
        model.addAttribute("conPath", conPath);

        return "common"; // templates/views/common.html
    }

    @RequestMapping("/member/search")
    public String searchMember(){
        System.out.println("searchMember() Called!");

        return "member/search";
    }

    // 뷰에 데이터 전달 ModelAndView 객체 사용
    // '뷰' 와 '데이터(Model)' 을 둘다 -> ModelAndView 에 세팅
    @RequestMapping(value = "/member/find") // value 생략 가능
    public ModelAndView findMember(){
        ModelAndView mv = new ModelAndView();

        mv.addObject("mbName","monbebe");
        mv.addObject("mbDate", LocalDateTime.now());
        mv.setViewName("member/find");

        return mv;
    }

    // 확장자 패턴 사용
    @RequestMapping("/member/*.do") // http://localhost:8081/ReqMapping/member/~~~.do ~~~ 에 뭐가 들어가던지간에 동작함
    // ("/member/**/*.do") spring boot 2.6.0 부터 ** 동작 안함
    public String doMember(HttpServletRequest request, Model model){ // 매개변수 순서 바뀌어도 상관 없음 !
        System.out.println("doMember() Called ! ");
        String uri = request.getRequestURI();
        model.addAttribute("uri", uri);

        return "member/doMember";
    }


}
