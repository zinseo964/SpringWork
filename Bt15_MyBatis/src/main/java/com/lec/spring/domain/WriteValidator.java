package com.lec.spring.domain;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

// Validator 는 Controller 에 등록되어 동작하게 해야한다.
public class WriteValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) { // 해당 validator 가 제공된 class 의 instance(class)를 유효성 검사 할 수 있는가 ?
        System.out.println("supports(" + clazz.getName()+")");

        // 검증할 객체의 클래스 탗입인지 확인 : Write = clazz 가능 여부 확인
        boolean result = Write.class.isAssignableFrom(clazz);
        System.out.println(result);
        return result;
    }

    // 주어진 객체(target) 에 유효성 검사를 하고
    // 유효성 검사에 오류가 있는 경우 -> 주어진 객체에 있는 오류들을 errors 에 등록

    // 아래 validate()는 Spring 이 기본적인 binding 을 수행한 이후에 호출

    // 따라서 errors 에는 Spring 이 수행한 기본적인 binding errors 담겨있고, target 에는 binding 이 완료한 커맨드 객체가 전달된다.
    @Override
    public void validate(Object target, Errors errors) {
        Write write = (Write) target;
        System.out.println("validate() Called : "+ write);

        // Binding 한 객체에 대한 다양한 검증 수행
        String user = write.getUser();
        if(user == null || user.trim().isEmpty()){
            errors.rejectValue("user", "User must be filled ! ");
        }

//        String subject = write.getSubject();
//        if(subject == null || subject.trim().isEmpty()){
//            errors.rejectValue("subject", "Subject must be filled ! ");
//        }

        // ValidationUtils 사용 (위의 코드를 밑에와 같이 한줄로 사용할 수 있다 )
        // 단순히 빈 (Empty) form 데이터를 처리할 때에는 아래와 같이 사용 가능
        //  -> 두번째 매개변수 "subject"는 반드시 target class 의 field name 이어야한다
        //  -> 게다가 errors 에 등록될때도 동일한 field 명으로 등록된다.

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject", "Subject must be filled ! ");
    }
}
