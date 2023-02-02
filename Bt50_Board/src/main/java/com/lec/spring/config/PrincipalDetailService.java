package com.lec.spring.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// UserDetailsService
// 컨테이너에 등록한다.
// 시큐리티 설정에서 loginProcessingUrl(url) 을 설정해 놓았기에
// 로그인시 위 url 로 요청이 오면 자동으로 UserDetailsService 타입으로 IoC 되어 있는
// loadUserByUsername() 가 실행되고
// 인증성공하면 결과를 UserDetails 로 리턴

@Service // UserDetailService Bean 등록
public class PrincipalDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername("+username+")");

        // DB 조회
        // TODO

        // 해당 username 의 user 가 DB 에 있다면 UserDetails 생성해서 return
        // TODO

        // 해당 username 의 user 가 없다면 : UsernameNotFoundException 을 throw 해줘야한다. -> 여기서 Null return 하면 예외발생 !
        // TODO
        throw new UsernameNotFoundException(username);

    }
}
