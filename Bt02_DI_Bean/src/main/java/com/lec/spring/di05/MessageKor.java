package com.lec.spring.di05;

import com.lec.spring.beans.MessageBean;
import org.springframework.stereotype.Component;

/*
 * org.springframework.stereotype 이하의 annotation 이 붙은 class는
 * 스프링 컨테이너 생성시 bean 으로 생성된다.
 *
 * ex) @Component
 */
public class MessageKor implements MessageBean {
    String msgKor = "안녕하세요";

    public MessageKor(){
        System.out.println("MessageKor() Create!");
    }

    @Override
    public void sayHello() {
        System.out.println(msgKor);
    }
}
