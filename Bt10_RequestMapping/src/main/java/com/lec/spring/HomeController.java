package com.lec.spring;

import jakarta.servlet.http.HttpServletRequest; // jakarta ? java 를 쓸 수 없어서 다른 이름 .. 을 .. 사용 ..
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    // URL -> Handler mapping,
    // url, handler 이름, 뷰 이름  ← 꼭 같은 필요는 없다.
    //      (그러나, 일반적으로는 같거나 동일한 맥락으로 작명한다)


    // HttpServletRequest 객체 (request 객체)
    // request -> url, parameter, cookie, header ,...
    @RequestMapping("/common")
    public String pathCommon(HttpServletRequest request, Model model){
        String uri = request.getRequestURI();
        String conPath = request.getContextPath();

        model.addAttribute("uri", uri);
        model.addAttribute("conPath", conPath);

        return "common"; // templates/views/common.html
    }
}
