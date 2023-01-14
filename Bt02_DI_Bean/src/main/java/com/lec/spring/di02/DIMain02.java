package com.lec.spring.di02;

import com.lec.spring.beans.MessageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

// (2) 필요한 객체를 외부에서 만들어서 주입 받는 경우 -> Autowired 사용 !
@SpringBootApplication
public class DIMain02 implements CommandLineRunner {

    public MessageBean msg;
    public DIMain02(){ // 컨테이너가 만들어질때 생성되었다
        System.out.println(getClass().getName() + "() Created");
    }
    @Autowired // 자동주입 , 의존주입 : field injection
    ApplicationContext ctx; // 스프링 컨테이너, 컨텍스트, IoC 컨테이너, Bean Factory 등 지칭하는 용어 다양
    @Autowired // setter injection (constructor injection ; 생성자 주입도 있음)
    public void setMsg(MessageBean msg) {
        System.out.println("Call setMsg()");
        this.msg = msg;
    }

    public static void main(String[] args) {
        System.out.println("Start main()");
        SpringApplication.run(DIMain02.class, args);
        System.out.println("End main()");
    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println("When does it run ?");
        msg.sayHello();
        System.out.println("Count Beans : " + ctx.getBeanDefinitionCount());

//        for( String name : ctx.getBeanDefinitionNames()){
//            System.out.println(name + " : " + ctx.getBean(name));
//        }
    }
}
