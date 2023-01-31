package com.lec.spring.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;

@Controller
@RequestMapping("/session")
public class SessionController {
    @RequestMapping("/list")
    public void list(HttpSession session, Model model){
        // session 에 있는 모든 attr names
        Enumeration<String> enumeration = session.getAttributeNames();

        StringBuffer buff = new StringBuffer();
        int i = 0;
        while(enumeration.hasMoreElements()){
            String sessionName = enumeration.nextElement();
//            session.getAttribute('name') <-- 특정 session attribute value 추출. return type = object. 해당 name의 session 이
//            없으면 Null return
            String sessionValue = session.getAttribute(sessionName).toString();

            buff.append((++i)+"] "+sessionName+" : "+sessionValue+"<br>");
        }
        if(i==0){
            buff.append("There is no attribute in session <br>");
        }
        model.addAttribute("result", buff.toString());
    }

    @RequestMapping("/create")
    public String create(HttpSession session){
        String sessionName, sessionValue;

        sessionName = "num1";
        sessionValue = "" + (int)(Math.random()* 100);

//        create session attribute: name-value
//        setAttribute(String name, Object value) ; 두번째 매개변수는 object type(어떠한 type 도 다 담을 수 있어서)
        session.setAttribute(sessionName, sessionValue);

        sessionName = "datetime";
        sessionValue = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
        session.setAttribute(sessionName, sessionValue);

        return "redirect:/session/list";
    }

    @RequestMapping("/delete")
    public String delete(HttpSession session){
//        session attribute delete
        session.removeAttribute("num1");

        return "redirect:/session/list";
    }

    public static final String ADMIN_ID = "admin";
    public static final String ADMIN_PW = "1234";
    @GetMapping("/login")
    public void login(HttpSession session, Model model){
//        현재 login 상태인지, 즉 login session(name = 'userid'인 seesion 값) 이 있는지 확인
        if(session.getAttribute("userid") != null){
            model.addAttribute("userid", session.getAttribute("userid"));
        }
    }

    @PostMapping("/login")
    public String loginOk(String userid, String pw, HttpSession session, Model model){
//        session name-value 지정
        String sessionName = "userid";
        String sessionValue = userid;

//        제줄된 id/ pw 값이 일치하면 login 성공 + session attr 생성
        if(ADMIN_ID.equalsIgnoreCase(userid) && ADMIN_PW.equals(pw)){
            session.setAttribute(sessionName, sessionValue);
            model.addAttribute("result", true);
        } else {
            session.removeAttribute(sessionName);
        }
        return "session/loginOk";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session){
        String sessionName = "userid";
        session.removeAttribute(sessionName);
        return "session/logout";
    }
}
