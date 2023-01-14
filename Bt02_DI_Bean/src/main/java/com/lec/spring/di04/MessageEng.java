package com.lec.spring.di04;

import com.lec.spring.beans.MessageBean;
import org.springframework.stereotype.Component;

@Component("ENG")
public class MessageEng implements MessageBean {
    String msgEng = "Good Morning";

    public MessageEng() {
        System.out.println("MessageEng() Create");
    }
    @Override
    public void sayHello() {
        System.out.println(msgEng);
    }
}
