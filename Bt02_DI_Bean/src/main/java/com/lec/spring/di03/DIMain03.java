package com.lec.spring.di03;

import com.lec.spring.beans.Score;
import com.lec.spring.beans.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DIMain03  implements CommandLineRunner {
    @Autowired // 자동주입, 필드타입과 같은 bean이 컨테이너 안에 있으면 자동주입 받는다.
    Score scoreA;
    @Autowired
    Student studentA;
    @Autowired
    ApplicationContext ctx;  // 생성된 스프링 컨테이너

    public DIMain03() {
        System.out.println("DIMain03() Created");
    }

    public static void main(String[] args) {
        System.out.println("Main start!");
        SpringApplication.run(DIMain03.class, args);

        System.out.println("Main end!");
    } // end main

    @Override
    public void run(String... args) throws Exception {
        System.out.println(scoreA);
        System.out.println(studentA);

        System.out.println(scoreA == studentA.getScore()); // true 로 찍힘 ; 즉 동일한 객체라는 뜻, 2번 생성되는게 아니라 한번만 생성 된다는 뜻

        // 컨테이너에 생성된 bean 의 '이름'으로
        // bean 객체를 받아올 수 있다
        System.out.println(ctx.getBean("score1"));
        System.out.println(ctx.getBean("student1"));

    }
}
