package com.lec.spring.di03;

import com.lec.spring.beans.Score;
import com.lec.spring.beans.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.w3c.dom.ls.LSOutput;

//JAVA 를 이용한 DI 설정
//클래스 이름앞에 반드시 어노테이션 명시 필요
//@Configuration --> 이 클래스는 '스프링 설정'에 사용되는 클래스 입니다.
//결국 IOC 컨테이너에 생성되는 bean 들을 기술하는 클래스 --> @Bean 사용

@Configuration
public class Config03{
    public Config03(){
        System.out.println("Config03() Created");
    }
    @Bean
    public Score score1(){ // <- '메소드 이름 score1' 이 getBean(name) 의 name 값이 된다
        return new Score(100, 97, 80, "Good");
    }

    @Bean
    public Student student1(){ // method name == Bean name
        return new Student("Daniel", 21, score1());
    }
}
