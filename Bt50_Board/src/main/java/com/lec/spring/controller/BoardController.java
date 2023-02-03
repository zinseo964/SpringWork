package com.lec.spring.controller;

import com.lec.spring.domain.Write;
import com.lec.spring.domain.WriteValidator;
import com.lec.spring.service.BoardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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
    public String writeOk( @ModelAttribute("dto") Write write , Model model){
        model.addAttribute("result", boardService.write(write));
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
    public String deleteOk(long id, Model model){
        model.addAttribute("result", boardService.deleteById(id));
        return "board/deleteOk";
    }

    // Controller class 의 핸들러에서 폼 데이터를 바인딩 할때 검증하는 Validator 객체 지정
    @InitBinder
    public void initBinder(WebDataBinder binder){
        System.out.println("initBinder() Called");
        binder.setValidator(new WriteValidator());
    }
}
