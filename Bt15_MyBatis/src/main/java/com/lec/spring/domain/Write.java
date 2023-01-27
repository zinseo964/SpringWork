package com.lec.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// Model object (domain, DTO: Data Transfer Object)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Write {
    private long id;
    private String user;
    private String subject;
    private String content;
    private LocalDateTime regDate;
    private long viewCnt;

    // when you develop web service, you should match these three names..
    // class field name == DB field name == form name
}
