package com.lec.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private int no;
    private String id;
    private String pw;
    private String name;
    private LocalDateTime regdate;

    public String getNick(){
        return "zinger";
    }

    public String getRegDateTime(){
        return this.regdate.format(
                DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss")
        );
    }

}
