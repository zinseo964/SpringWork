package com.lec.spring.Bt60_JPA.repository;

import com.lec.spring.Bt60_JPA.domain.User;
import com.lec.spring.Bt60_JPA.repository.UserRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest    // 스프링 context 를 로딩하여 테스트에 사용
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
//    @Transactional
    void crud(){
        System.out.println("\n-- TEST#crud() ------------------------------------");

//        User user = new User();
//        System.out.println(user);
//
//        userRepository.save(user);   // INSERT, 저장하기
//
//        userRepository.save(new User());
//        userRepository.save(new User());
//        System.out.println(">>> " + userRepository.findAll());  // SELECT  전체 조회

        // 테스트에 사용할 변수들
        List<User> users = null;
        User user1 = null, user2 = null, user3 = null, user4 = null, user5 = null;
        List<Long> ids = null;

        // #002
//        users = userRepository.findAll();
//        users.forEach(System.out::println);

        // #003 findxx() + Sort.by() 사용
        // name 필드의 역순출력
//        users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
//        users.forEach(System.out::println);

        // #004 findxxByxx(Iterable)
        // findAllById(Iterable<Long> ids)
//        ids = new ArrayList<>();
//        ids.add(1L);
//        ids.add(3L);
//        ids.add(5L);
//
//        users = userRepository.findAllById(ids);
//        users.forEach(System.out::println);

        // #005 save(entity) 저장하기
//        user1 = new User("jack", "jack@redknight.com");
//        System.out.println("save() 전: " + user1);
//        userRepository.save(user1);
//        System.out.println("save() 후: " + user1);
//
//        userRepository.findAll().forEach(System.out::println);

        // #006 saveAll(Iterable<entity>)
//        user1 = new User("jack", "jack@redknight.com");
//        user2 = new User("steve", "steve@redknight.com");

//        List<User> list = new ArrayList<User>();
//        list.add(user1);
//        list.add(user2);
//        userRepository.saveAll(list);

//        userRepository.saveAll(Lists.newArrayList(user1, user2));
//        userRepository.findAll().forEach(System.out::println);

        // getOne()  Entity 리턴  Deprecated
        // findById()  Optional<> 리턴
        // 결과는 같은것 같으나 동작이 다릅니다.

        // #007 getOne(id)
//        user1 = userRepository.getOne(1L);   // 기본적으로 Lazy 한 로딩을 한다.
//        System.out.println(user1);      // LazyInitializationException 은 여기서 발생!

        // #008 findById(id)
        // 리턴타입은 java.util.Optional<entity>
//        Optional<User> user;
//        user = userRepository.findById(1L);
//        System.out.println(user);   // Optional
//        System.out.println();
//
//        user = userRepository.findById(10L);  // 없다면?
//        System.out.println(user);  // Optional.empty
//        System.out.println();
//
//        // Optional#orElse() : 찾으면 entity 리턴, 없는 경우 null 리턴하도록 처리.
//        user1 = userRepository.findById(10L).orElse(null);
//        System.out.println(user1);
//        System.out.println();

        // #009 flush()
        // flush() 는 SQL쿼리의 변화를 주는게 아니라 DB 반영 시점을 조정한다. 로그 출력으로는 변화를 확인하기 힘들다

//        userRepository.save(new User("new martin", "newmartin@redknight.com"));
//        userRepository.flush();
//        userRepository.findAll().forEach(System.out::println);
//
//        // saveAndFlush() = save() + flush()
//        userRepository.saveAndFlush(new User("new martin", "newmartin@redknight.com"));
//        userRepository.findAll().forEach(System.out::println);

        // #010 count()
//        Long count = userRepository.count();
//        System.out.println(count);

        // #011 existsById()
//        Boolean exists = userRepository.existsById(1L);
//        System.out.println(exists);

        // #012 delete(entity)
        // 삭제하기
//        userRepository.delete(userRepository.findById(1L).orElse(null));
//        userRepository.findAll().forEach(System.out::println);
//
//        // delete(entity)  에서 null 을 허용하지 않기 때문에.  차라리 예외를 발생시켜 처리할수도 있다.
//        userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));
//        userRepository.findAll().forEach(System.out::println);

        // #013 deleteById(id)
//        userRepository.deleteById(1L);
//        userRepository.findAll().forEach(System.out::println);

        // #014 deleteAll()
//        userRepository.deleteAll();   // -> delete 를 매번 한다???? 헉!?
//        userRepository.findAll().forEach(System.out::println);

        // #015 deleteAll(iterable)
//        userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L, 3L)));
//        userRepository.findAll().forEach(System.out::println);

        // #016 deleteInBatch(Iterable)  # 현재는 Deprecated 됨.
//        userRepository.deleteInBatch(userRepository.findAllById(Lists.newArrayList(1L, 3L)));
//        userRepository.findAll().forEach(System.out::println);

        // #017 deleteAllInBatch()
//        userRepository.deleteAllInBatch();
//        userRepository.findAll().forEach(System.out::println);

        // #018 findXXX(Pageable)  페이징
        // PageRequest 는 Pageable 의 구현체  org.springframework.data.domain.PageRequest
        // 리턴값은 Page<T>  org.springframework.data.domain.Page
        // 주의: page 값은 0-base 다

//        Page<User> userpage = userRepository.findAll(PageRequest.of(0, 2));     // page 1 (두번째 페이지),  size 3
//
//        System.out.println("page: " + userpage);
//        System.out.println("totalElements: " + userpage.getTotalElements());
//        System.out.println("totalPages: " + userpage.getTotalPages());
//        System.out.println("numberOfElements: " + userpage.getNumberOfElements());
//        System.out.println("sort: " + userpage.getSort());
//        System.out.println("size: " + userpage.getSize());
//
//        // 페이징 내부의 User 정보
//        userpage.getContent().forEach(System.out::println);

        // #019 QueryByExample 사용
//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withIgnorePaths("name")      // name 컬럼은 매칭하지 않겠다.
//                .withMatcher("email", endsWith())   // email 컬럼의 뒷 부분 매칭으로 검색
//                ;
//
//        //Example.of(probe, ExampleMatcher)  <-- 여기서 probe 란 실제 Entity 는 아니란 말입니다.  match 를 위해서 쓰인 객체
//        Example<User> example = Example.of(new User("ma", "knight.com"), matcher);
//
//        userRepository.findAll(example).forEach(System.out::println);

        // #020 QueryByExample 사용
        // email 필드에 "blue" 문자열이 있는 것
//        user1 = new User();
//        user1.setEmail("blue");
//        // email 필드에서 주어진 문자열을 담고 있는 것을 검색
//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withMatcher("email", contains())
//                ;
//
//        Example<User> example = Example.of(user1, matcher);
//
//        userRepository.findAll(example).forEach(System.out::println);


        // UPDATE 만들기
        // save() 가 INSERT 뿐 아니라 UPDATE 를 생성하기도 한다
        userRepository.save(new User("david", "david@redknight.com")); // INSERT  (여기서 Id 값은 null 이다)

        user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setEmail("martin@naver.com");
        userRepository.save(user2);   // UPDATE   id=1 인 데이터가 수정.

        userRepository.findAll().forEach(System.out::println);

        System.out.println("-----------------------------------------------------");
    } // end crud()
}
