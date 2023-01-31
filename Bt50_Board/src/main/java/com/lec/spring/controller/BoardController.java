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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String writeOk(@Valid Write write
            , BindingResult result              // validator 가 유효성 검사를 한 결과가 담긴 객체
            , Model model                       // Parameter 선언시 , Binding Result 보다 Model 을 뒤에 둬야 한다
            , RedirectAttributes redirectAttrs  // redirect 시 넘겨줄 값들
    ){
        // validation error 가 있다면 redirect 한다 !
        if(result.hasErrors()){
            // Redirect 시, 기존 입력값들은 보이게 한다
            redirectAttrs.addFlashAttribute("user", write.getUser());
            redirectAttrs.addFlashAttribute("subject", write.getSubject());
            redirectAttrs.addFlashAttribute("content", write.getContent());

            List<FieldError> errList = result.getFieldErrors();
            for(FieldError err : errList){
                // addFlashAttribute() <- post 방식으로 redirect 발생할때
                redirectAttrs.addFlashAttribute("error", err.getCode()); // post 방식으로
                break;
            }

            return "redirect:/board/write";
        }
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
