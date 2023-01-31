package com.lec.spring.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/cookie")
public class CookieController {
    @RequestMapping("/list")
    public void list(HttpServletRequest request, Model model){
        // client 안의 쿠키 정보는 request 시에 서버로 전달된다.
        // request.getCookies() 로 쿠키 받아올수 있다.
        Cookie[] cookies = request.getCookies();

        StringBuffer buff = new StringBuffer();

        if(cookies != null){ // cookie 가 하나도 없으면 null return
            for(int i=0; i< cookies.length; i++){
                String name = cookies[i].getName(); // cookie 'name'
                String value = cookies[i].getValue(); // cookie 'value'
                buff.append((i + 1) + "] " + name + " : " + value + "<br>");
            }
        } else{
            buff.append("There is no Cookie.<br>");
        }
        model.addAttribute("result", buff.toString());
    }

    // 쿠키 생성 절차
    //1. 쿠키(Cookie) 클래스로 생성
    //2. 쿠키속성 설정(setter)
    //3. 쿠키의 전송 (response 객체에 탑재:addCookie())
    @RequestMapping("/create")
    // 주의!
    // 만약 핸들러에서 HttpServletResponse 객체를 건드렸으면
    // 해당 핸들러는 반드시 String 을 리턴하여 뷰 나 redirect 가 될수 있도록 하자 -> void 리턴하면 안됨
    public String create(HttpServletResponse response){
        String cookieName1 = "num1";
        String cookieValue1 = "" + (int)(Math.random() * 10);

        Cookie cookie1 = new Cookie(cookieName1, cookieValue1); // name-value 쌍으로 cookie 생성
        cookie1.setMaxAge(60); // 쿠키 파기(expiry) 시간 설정 (생성 시점으로부터 30 초 후)
        response.addCookie(cookie1); // response 에 추가

        // 쿠키는 얼마든지 생성 가능.
        String cookieName2 = "datetime";
        String cookieValue2 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"));   // '-', ':' 등의 문자는 쿠키에 사용 못함
        Cookie cookie2 = new Cookie(cookieName2, cookieValue2);
        cookie2.setMaxAge(40);
        response.addCookie(cookie2);
        return "redirect:/cookie/list";
    }

    @RequestMapping("/delete")
    public String delete(HttpServletResponse response){
        String cookieName = "num1";
        Cookie cookie = new Cookie(cookieName, "xxx");
        cookie.setMaxAge(0); // client 에 도착하자마자 죽어야한다는 의미
        response.addCookie(cookie);

        return "redirect:/cookie/list";
    }

    public static final String ADMIN_ID = "admin";
    public static final String ADMIN_PW = "1234";

    @GetMapping("/login")
    public void login(@CookieValue(name="userid", required = false) String userid, Model model){
        model.addAttribute("userid", userid);
    }

    @PostMapping("/login")
    public String loginOk(String userid, String pw, HttpServletResponse response, Model model){
//        userid 와 pw 일치하면 로그인 성공 + 쿠키 생성
        if(ADMIN_ID.equalsIgnoreCase(userid) && ADMIN_PW.equals(pw)){
            Cookie cookie = new Cookie("userid", userid);
            cookie.setMaxAge(30);
            response.addCookie(cookie);

            model.addAttribute("result", true);
        } else {
            Cookie cookie = new Cookie("userid", userid);
            cookie.setMaxAge(0); // 기존에 있었던 쿠키도 죽인다
            response.addCookie(cookie);
        }
        return "cookie/loginOk";
    }

    @PostMapping("/logout")
    public String logout(HttpServletResponse response){
        Cookie cookie = new Cookie("userid", "");
        cookie.setMaxAge(0); // cookie delete
        response.addCookie(cookie);
        return "cookie/logout";
    }
}
