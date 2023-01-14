package com.lec.spring.di06;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
* container 에 bean 으로 생성하는 annotation 들 (stereotype)
*
* @Component        <- 일반적인 bean
*   ↳ @Controller   <- Spring MVC 에서 Controller 로 사용
*   ↳ @Repository   <- DAO, Persistence 로 사용
*   ↳ @Service      <- Service 단으로 사용
*/

@SpringBootApplication
public class DIMain06 implements CommandLineRunner {
    public DIMain06(){
        System.out.println("DIMain06 Created!");
    }

    public static void main(String[] args) {
        System.out.println("Main() Start! ");
        SpringApplication.run(DIMain06.class, args);
        System.out.println("Main() End! ");
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
