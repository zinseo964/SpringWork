package com.lec.spring.Bt60_JPA.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Spring MVC 에서 controller 를 테스트 한다는 건,
// 'request' 처리, 입력값 검사, 요청한 데이터 확인, 비지니스 로직 호출, 다음화면 이동 등을 확인하는 것

// Spring MVC 를 테스트 하려면, 프레임워크가 통합된 상태로 해야한다
// 그래서 MVC 테스트 할 수 있도록 MockMVC 객체를 만들어 준다
// ** mockMVC 는 web application 을 서버에 배포하지 않도록 Spring MVC 의 동작을 재현할 수 있는 객체
@WebMvcTest
class HelloWorldControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloWorld() throws Exception{
        // get 방식 요청의 Test
        mockMvc.perform(MockMvcRequestBuilders.get("/helloworld"))
                .andDo(print()) // request-response 정보 출력
                .andExpect(status().isOk()) // 200 response 만
                .andExpect(content().string("hello-world")) // response 내용은 hello-world 를 기대함
                ;
    }
}