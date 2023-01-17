package com.lec.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private int no;
    private String id;
    private String pw;
    private String name;
    private LocalDateTime regdate;

}
