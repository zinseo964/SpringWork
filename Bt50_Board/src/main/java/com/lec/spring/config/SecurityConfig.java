package com.lec.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // PasswordEncoder 를 bean 으로 IoC 에 등록
    // IoC 에 등록된다, IoC 내에선 '어디서든' 가져다가 사용할수 있다.
    @Bean
    public PasswordEncoder encoder(){
        System.out.println("PasswordEncoder bean 생성");
        return new BCryptPasswordEncoder();
    }

    // Security 를 동작 시키지 않게 하는 것 (아래 코드)
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer(){
//        return web -> web.ignoring().anyRequest();  // 추상 Method 구현; lambda expression 으로
//    }

    // SecurityFilterChain 을 Bean 으로 등록해서 사용
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(csrf -> csrf.disable())
                /**********************************************
                * ① request URL 에 대한 접근 권한 세팅  : authorizeHttpRequests()
                * .authorizeHttpRequests( AuthorizationManagerRequestMatcherRegistry)
                **********************************************/
                .authorizeHttpRequests(auth -> auth
                        // URL 과 접근권한 setting
                        .requestMatchers("/board/detail/**").authenticated() // <- /board/detail/** URL 로 들어오는 요청은
                        // 인증만 필요 (로그인만 되면 여긴 볼 수 있다)
                        .requestMatchers("/board/write/**", "/board/update/**", "/board/delete/**").hasAnyRole(
                                "MEMBER", "ADMIN") // 여긴 인증 뿐만 아니라 ROLE_MEMBER 나 ROLE_ADMIN 권한을 가지고 있어야한다.(인가)
                        .anyRequest().permitAll() // 그밖에 나머지 URL 은 모든 요청 permit
                )

                /********************************************
                 * ② 폼 로그인 설정
                 * .formLogin(HttpSecurityFormLoginConfigurer)
                 *  form 기반 인증 페이지 활성화.
                 *  만약 .loginPage(url) 가 세팅되어 있지 않으면 '디폴트 로그인' form 페이지가 활성화 된다
                 ********************************************/
                .formLogin(form -> form
                        .loginPage("/user/login")  // 로그인이 필요한 상황 발생시 argument 의 url : "/user/login"으로 redirect
                        .loginProcessingUrl("/user/login")
                                                // (위) "/user/login" url 로 POST request 가 들어오면 시큐리티가 낚아채서 처리, 대신 로그인을 진행해준다(인증).
                                                // 이와 같이 하면 Controller 에서 /user/login (POST) 를 굳이 만들지 않아도 된다!
                                                // 위 요청이 오면 자동으로 UserDetails를Service 타입 빈객체의 loadUserByUsername() 가
                        // 실행되어 인증여부 확인진행 <- 이를 제공해주어야 한다.
                        .defaultSuccessUrl("/")  // '직접 /login' → /loginOk 에서 성공하면 "/" 로 이동시키기
                        // 만약 다른 특정페이지에 진입하려다 로그인 하여 성공하면 (원래가고자 하는 그 페이지) 해당 페이지로 이동 (너무 편리!)
                        // 로그인 성공직후 수행할코드
                        //.successHandler(AuthenticationSuccessHandler)  // 로그인 성공후 수행할 코드.
                         .successHandler(new CustomLoginSuccessHandler("/home"))

                        // 로그인 실패하면 수행할 코드
                        // .failureHandler(AuthenticationFailureHandler)
//                        .failureHandler(new CustomLoginFailureHandler())
                )
                .build();
    }
}

