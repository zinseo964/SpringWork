package com.lec.spring.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Model 객체 (domain, DTO: Data Transfer Object)

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Write {
    private Long id;    // 글 id (PK)
    private String subject;
    private String content;
    private LocalDateTime regDate;
    private long viewCnt;

    private User user;   // 글 작성자 (FK)

    // 첨부파일, 댓글
    @ToString.Exclude
    @Builder.Default // 아래와 같이 초기값이 있으면 @Builder.Default 처리 (Builder 제공 안한다는 의미)
    private List<FileDTO> files = new ArrayList<>();


}
