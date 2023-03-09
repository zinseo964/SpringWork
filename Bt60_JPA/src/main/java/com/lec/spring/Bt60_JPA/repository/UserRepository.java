package com.lec.spring.Bt60_JPA.repository;

import com.lec.spring.Bt60_JPA.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository 생성
// JpaRepository<Entity type, Id type> 상속 (Spring Data JPA 가 지원해주는 영역)
// 상속받은 것 만으로도 많은 JPA method 를 편리하게 사용 가능하게 된다
// 상속받은 것 만으로도 이미 Spring Context 에 생성된다 -> Annotation 사용하지 않아도 container 에 생성됨
// 언제든 주입받은 것 만으로 사용할 수 있다
public interface UserRepository extends JpaRepository<User,Long> {
}
