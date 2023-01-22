package com.lec.spring.controller;

import com.lec.spring.domain.Write;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HomeController {
    @RequestMapping("/member/delete")
    public void delMember(HttpServletRequest request, Model model){ // 전통적인 방법 !
        String id = request.getParameter("id"); // "id" 란 이름의 parameter 값 return
        System.out.println("id : " + id);

        String age = request.getParameter("age"); // getParameter 값이 없을때는 null return
        System.out.println("age : " + age);

        model.addAttribute("mdId", id); // parameter 값이 없으면 null, error 는 아님
        model.addAttribute("mdAge", age);

        String num = request.getParameter("num");
        System.out.println("num : "+ num); // parameter 여러개 올 수 있지만 입력 받는 것은 첫번째 값 !

        // 동일한 name parameter 가 여러개인 경우
        String[] arrNum = request.getParameterValues("num"); // String 형 배열을 return
        System.out.println("arrNum : "+ Arrays.toString(arrNum));
    }

    @GetMapping("/member/register")
    public void registerMember(){

    }

    @RequestMapping("/member/regOk") // 어떤 방식의 request 든지간에 url mapping 가능, 어떠한 request Method 에서도 동작 (get, post
    // 뿐만아니라 put, delete 모두 가능)
    public void regOk(HttpServletRequest request, Model model){
        System.out.println("member/regOk : "+ request.getMethod());
        String name = request.getParameter("name"); // input name 의 name 을 의미

        model.addAttribute("name", name);
    }

    // 특정 request method 에서만 동작하는 url mapping (get 방식과 put 방식에서만 동작; 다른 method 방식 시도시 405error 발생)
    @RequestMapping(value = "/member/regOk2", method = {RequestMethod.GET, RequestMethod.PUT})
    public String regOk2(HttpServletRequest request, Model model){
        System.out.println("member/regOk2 : "+ request.getMethod());
        String name = request.getParameter("name"); // input name 의 name 을 의미

        model.addAttribute("name", name);

        return "member/regOk2";
    }

    // 단일 request method 에서만 동작하는 핸들러는
    // @GetMapping(..), @PostMapping(..), @PutMapping(...)  등을 사용하는게 간편하다
    // parameter name 값과 동일한 이름의 변수를 handler 에 지정해서 받아오기 (여기서는 id 와 name)
    @RequestMapping("/member/find1")
    public void find1(String id, String name, Model model){ // parameter 순서 상관 없음
        System.out.println("member/find1 : id=" + id + ", name=" + name); // 빈문자열로 넘어가는것과 null 로 넘어가는 것은 다르다
//        model.addAttribute("id", id);
//        model.addAttribute("name", name);
    }
    // 숫자 타입은 바로 parsing 해서 받을 수 있다

    @RequestMapping("/member/find2")
    public void find2(Double id, String name, Model model){ // wrapper double 형식인 Double 로 선언해서 Null 값은 받을 수 있다
        // (double id 로 선언했으면 null 값 못받음)
        System.out.println("member/find2 : id=" + id + ", name=" + name);
        model.addAttribute("id", id); // -> null 이 등록되면 primitive type 으로 변환할 수 없으므로 wrapper 사용하길 권함
        // primitive type 인데 parameter 에 없는 경우, 즉 parameter 부분에서 double id 로 선언한 경우, 혹은 parsing 불가능하면 error 발생 !
        model.addAttribute("name", name);
    }
    // 위 과정을 binding 한다 라고 한다.
    // => parameter "name"-value  -->  Java 변수, 객체

    // 동일한 name 의 parameter(들) --> '배열' 매개변수로 받을수 있다.
    @RequestMapping("/member/find3")
    public void find3(int[] id, String [] name, Model model){
        System.out.println("member/find3 : id=" + Arrays.toString((id)) + ", name=" + Arrays.toString(name));
    }

    // 만약 request parameter 의 name 과 매개변수가 같을수 없는 상황이면
    // @RequestParam 애노테이션 사용
    @RequestMapping("member/find4")
    public void find4(@RequestParam("id") String userid, // id 란 name 의 parameter 값을 userid parameter 에 binding 해준다 +
                      // id 값이 없으면 null 이 찍히는 것이 아니라 error 가 난다
                      @RequestParam("name") String username){
        System.out.println("member/find4 : id=" + userid + ", name=" + username);
    }
    // 위의 경우 id 값이 없거나 변환 불가능하면 error 발생 (왜냐, required = true 이기 때문)
    // RequestParam(value="test", required=false, defaultValue="0") 을 이용하면 가능하긴 함
    // 또한, @RequestParam 과 Map<name, value> 를 사용하면 된다

    @RequestMapping("member/find5")
    public void find5(@RequestParam Map<String, String> map){
        System.out.println("member/find5 : " + map);
    }

    //------------------------------------------------------------------------------------
    // 커맨드 객체 (Command Object) 사용

    // 게시글 등록 form
    @GetMapping("/board/write")
    public void writeBoard() {
    }

    @PostMapping("/board/writeOk")
//    public void writeOkBoard(String name, String subject, String content){} -> 기존 방식대로라면 이런식으롲 작동해야하는데, 모든
//    parameter 를 작성해주기는 힘들다
    public void writeOkBoard(Write write){ // command 객체를 사용, 코드 작업량이 매우 줄어든다 .
        System.out.println("/board/writeOk : "+ write);
    }
}
