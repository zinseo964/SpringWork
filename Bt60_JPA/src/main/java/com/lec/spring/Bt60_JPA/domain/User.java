package com.lec.spring.Bt60_JPA.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity(name = "T_USER")
public class User {
    @Id         // setting PK
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
