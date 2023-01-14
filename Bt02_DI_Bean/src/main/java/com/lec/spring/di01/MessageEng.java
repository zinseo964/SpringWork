package com.lec.spring.di01;

import com.lec.spring.beans.MessageBean;

public class MessageEng implements MessageBean {
    String msgEng = "Hello";

    public MessageEng() {
        System.out.println("MessageEng() Create");
    }
    @Override
    public void sayHello() {
        System.out.println(msgEng);
    }
}
