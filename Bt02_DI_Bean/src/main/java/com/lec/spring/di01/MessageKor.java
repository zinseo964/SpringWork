package com.lec.spring.di01;

import com.lec.spring.beans.MessageBean;

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
