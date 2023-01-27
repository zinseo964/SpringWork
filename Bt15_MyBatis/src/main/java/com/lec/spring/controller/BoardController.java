package com.lec.spring.controller;

import com.lec.spring.domain.Write;
import com.lec.spring.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Controller layer
// request 처리 ~ response
@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    public BoardController(){
        System.out.println("Created BoardController() !");
    }

    @GetMapping("/write")
    public void write(){}

    @PostMapping("/write")
    public String writeOk(Write write, Model model){
        model.addAttribute("result", boardService.write(write));
        model.addAttribute("dto", write); // auto-generated key 가 필요해서
        return "board/writeOk";
    }

    @GetMapping("/detail")
    public void detail(long id, Model model){
        model.addAttribute("list", boardService.detail(id));
    }

    @GetMapping("/list")
    public void list(Model model){
        model.addAttribute("list", boardService.list());
    }

    @GetMapping("/update")
    public void update(long id, Model model){
        model.addAttribute("list", boardService.selectById(id));
    }

    @PostMapping("/update")
    public String updateOk(Write write, Model model){
        model.addAttribute("result", boardService.update(write));
        model.addAttribute("dto", write);
        return "board/updateOk";
    }

    @PostMapping("/delete")
    public void deleteOk(){}



}
