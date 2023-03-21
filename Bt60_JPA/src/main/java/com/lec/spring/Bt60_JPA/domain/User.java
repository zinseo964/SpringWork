package com.lec.spring.Bt60_JPA.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

/**
 *     @GeneratedValue 의 strategy 값
 *      1. GenerationType.IDENTITY: MySQL, PostgreSQL, SQL Server, DB2 에서 사용하는 방식
 *                                자동으로 DB 에서 값 입력.  DB 에 값을 저장한 후에 기본키값 얻어올수 있다
 *
 *      2. GenerationType.SEQUENCE: 오라클, H2, DB2, PostgreSQL 에서 사용하는 방식
 *                                시퀀스 객체 사용 <- 유일한 값을 순차적으로 생성하는 객체
 *
 *      3. GenerationType.TABLE : 키 전용 테이블 생성하여 이를 시퀀스처럼 사용
 *                                모든 DB 에 적용 가능
 *
 *      4. GenerationType.AUTO : (디폴트) 위 3가지중 하나를 선택하여 자동 적용.
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity(name = "T_USER")
public class User {
    @Id         // setting PK
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
