package com.lec.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("board")
public class BoardController {
    @RequestMapping("list")
    public void listBoard(){

    }
    @RequestMapping("write")
    public void writeBoard(){

    }

    @RequestMapping("detail")
    public void detailBoard(){

    }
    @RequestMapping("update")
    public void updateBoard(){

    }
    @RequestMapping("delete")
    public void deleteBoard(){

    }
}
