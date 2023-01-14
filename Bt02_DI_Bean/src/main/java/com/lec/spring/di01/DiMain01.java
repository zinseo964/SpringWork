package com.lec.spring.di01;

import com.lec.spring.beans.MessageBean;

/*
    Dependency Injection (DI 의존주입)
    필요한 객체는 누가 만들어 사용 ?
           1. 직접 생성 -> 사용
           2. 외부에서 주입
 */
public class DiMain01 {
    public MessageBean msg; // 필요한 객체 직접적으로 의존 (1)

    public void setMsg(MessageBean msg) {
        this.msg = msg;
    }

    public static void main(String[] args){
        System.out.println("Main Start");
        DiMain01 app = new DiMain01();
        app.test();
        System.out.println("Main Stop");
    }

    public void test() {
        // 필요한 MessageBean 객체 만들기 (1)
//        msg = new MessageKor(); // 직접 new 명령어 사용해서 만들어 사용 (1)
//        msg.sayHello();
        msg = new MessageEng(); // -> 이것 역시 직접 명령어 입력해서 사용 (1) -> 결국 의존하는 측의 생성 코드가 수정되어야 하며, 재컴파일 필요
        msg.sayHello();

    }
}