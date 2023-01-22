package com.lec.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// Model 객체, domain 객체
// DTO : Data Transfer Object

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Write {

    private long id;
    private String name;
    private String subject;
    private String content;
    private LocalDateTime regDate;

    // 사용되지 않는 field 값은 초기화 된 값으로 출력된다
    // 웹 개발시, """ class field 명 = DB Field 명 = form name """ 명은 일치시켜 주는 게 좋다
}
