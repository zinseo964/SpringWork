package com.lec.spring;

import com.lec.spring.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.util.*;

@Controller
public class SampleController {

    String [] arr1 = new String[]{"AAA", "BBB", "CCC", "DDD", "EEE"};
    Member [] arr2;
    List<Integer> list1 = new ArrayList<>();
    List<Member> list2 = new ArrayList<>();

    Map<Integer, String> map1 = new HashMap<>();
    Map<String, Member> map2 = new HashMap<>();

    public SampleController(){
        System.out.println("SampleController() Created !");

        Member member;
        for(int i = 0; i < 5; i++){
            list1.add(i*1000);
            member = new Member(100+i, "u0"+i, "p0"+i, arr1[i], LocalDateTime.now());
            list2.add(member);
            map1.put(i, arr1[i]);
            map2.put(arr1[i], member);
        }

        arr2 = list2.toArray(new Member[5]);

        System.out.println("arr1 : " + Arrays.toString(arr1));
        System.out.println("arr2 : " + Arrays.toString(arr2));

        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);

        System.out.println("map1: " + map1);
        System.out.println("map2: " + map2);
    }

    @RequestMapping("/sample1")
    public void sample1(Model model){
        model.addAttribute("greeting", "Hello Thymeleaf");
    }

    @RequestMapping("/sample2")
    public void sample2(Model model){
        Member member = new Member(123, "u00", "p00", "Daniel", LocalDateTime.now());

        model.addAttribute("m",member);
        System.out.println(model.getAttribute("m"));
        System.out.println(model.getAttribute("aaa")); // 없는 attribute 를 꺼내려 하면 null return

        System.out.println(model.addAttribute("arr1", arr1));
        System.out.println(model.addAttribute("arr2", arr2));
        System.out.println(model.addAttribute("list1", list1));
        System.out.println(model.addAttribute("list2", list2));
        System.out.println(model.addAttribute("map1", map1));
        System.out.println(model.addAttribute("map2", map2));
    }

    @RequestMapping("/sample3")
    public void sample3(Model model){
        model.addAttribute("list", list2);
    }

    @RequestMapping(value = "/sample4", method=RequestMethod.GET) // GET 방식으로 /sample4 request 에 대해 동작하는
    public void sample4(Model model){
        list2.get(3).setId(null);
        model.addAttribute("list", list2);

        // th:if 에서 판정되는 형식 알아보기
        model.addAttribute("test1", "aaa");
        model.addAttribute("test2", "");
        model.addAttribute("test3", null);
        model.addAttribute("test4", false);
    }
    @GetMapping("/sample5") // GET 방식으로 /sample5 request 에 대해 동작하는 handler
    public void sample5(Model model){
        String result = "SUCCESS";
        model.addAttribute("result", result);
    }

    @GetMapping("/sample6")
    public void sample6(Model model){
        model.addAttribute("list", list2);
        String result = "Success";
        model.addAttribute("result", result);
    }

    @GetMapping("/sample7")
    public void sample7(Model model){
        model.addAttribute("now1", LocalDateTime.now()); // java.time.LocalDateTime
        model.addAttribute("now2", new Date()); //java.util.Date 역시 현재 시간을 담는다
        model.addAttribute("price", 123456789);
        model.addAttribute("title", "This is sample");
        model.addAttribute("options", Arrays.asList("AAA", "BBB", "CCC", "DDD")); // <List>

    }

    @GetMapping("/sample8")
    public void sample8(Model model){
        model.addAttribute("value1", "John");
        model.addAttribute("url1","sample1");
    }
}
