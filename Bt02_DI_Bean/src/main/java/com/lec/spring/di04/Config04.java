package com.lec.spring.di04;

import com.lec.spring.beans.Score;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config04 {
    @Bean
    public Score score1(){
        return new Score(100, 90, 98, "Excellent!");
    }
    @Bean(name="Kim")   // "Kim" 이라는 이름의 Score type bean created.
    public Score score2(){
        return new Score(30, 29,16, "Bad");
    }
}
