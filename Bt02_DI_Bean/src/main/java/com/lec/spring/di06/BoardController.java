package com.lec.spring.di06;

import org.springframework.stereotype.Controller;

@Controller
public class BoardController {
    DoService service;

    // DoService 주입받아 생성
    public BoardController (DoService service) {
        System.out.println("BoardController(" + service + ") Created !");
        this.service = service;
    }
}
