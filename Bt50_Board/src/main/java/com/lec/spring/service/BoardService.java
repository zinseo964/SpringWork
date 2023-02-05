package com.lec.spring.service;

import com.lec.spring.common.C;
import com.lec.spring.domain.User;
import com.lec.spring.domain.Write;
import com.lec.spring.repository.UserRepository;
import com.lec.spring.repository.WriteRepository;
import com.lec.spring.util.U;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

// Service layer
// - Transaction 담당

@Service
public class BoardService {

    private WriteRepository writeRepository;
    private UserRepository userRepository;

    @Autowired
    public BoardService(SqlSession sqlSession){  // MyBatis 가 생성한 SqlSession 빈(bean) 객체 주입
        writeRepository = sqlSession.getMapper(WriteRepository.class);
        userRepository = sqlSession.getMapper(UserRepository.class);
        System.out.println("BoardService() 생성");
    }

    public int write(Write write){
        // 현재 로그인한 작성자 정보
        User user = U.getLoggedUser();

        // 위 정보는 session 의 정보이고, 일단 DB 에서 다시 읽어온다
        user = userRepository.findById(user.getId());
        write.setUser(user);  // 글 작성자 세팅

        int cnt = writeRepository.save(write);

        return cnt;
    }

    // 특정 id 의 글 조회
    // 트랜잭션 처리
    // 1. 조회수 증가 (UPDATE)
    // 2. 글 읽어오기 (SELECT)
    @Transactional
    public List<Write> detail(long id) {
        List<Write> list = new ArrayList<>();

        writeRepository.incViewCnt(id);
        Write write = writeRepository.findById(id);

        if(write != null){
            list.add(write);
        }

        return list;
    }

    public List<Write> list(){
        return writeRepository.findAll();
    }

    // 특정 id 의 글 읽어오기
    // 조회수 증가 없음
    public List<Write> selectById(long id) {
        List<Write> list = new ArrayList<>();

        Write write = writeRepository.findById(id);

        if(write != null){
            list.add(write);
        }

        return list;
    }

    // 페이징 리스트
    public List<Write> list(Integer page, Model model){
        // 현재 페이지 param
        if(page == null) page = 1;  // 디폴트는 1page
        if(page < 1) page = 1;

        // 페이징
        // writePages: 한 [페이징] 당 몇개의 페이지가 표시되나
        // pageRows: 한 '페이지'에 몇개의 글을 리스트 할것인가?
        HttpSession session = U.getSession();
        Integer writePages = (Integer)session.getAttribute("writePages");
        if(writePages == null) writePages = C.WRITE_PAGES;   // 만약 session 에 없으면 기본값으로 동작
        Integer pageRows = (Integer)session.getAttribute("pageRows");
        if(pageRows == null) pageRows = C.PAGE_ROWS;   // session 에 없으면 기본값으로
        session.setAttribute("page", page);   // 현재 페이지 번호 -> session 에 저장

        long cnt = writeRepository.countAll();   // 글 목록 전체의 개수
        int totalPage = (int)Math.ceil(cnt / (double)pageRows);  //총 몇 '페이지' 분량인가?

        // page 값 보정
        if(page > totalPage) page = totalPage;

        // 몇번째 데이터부터 fromRow
        int fromRow = (page - 1) * pageRows;

        // [페이징] 에 표시할 '시작페이지' 와 '마지막페이지' 계산
        int startPage = ((int)((page - 1) / writePages) * writePages) + 1;
        int endPage = startPage + writePages - 1;
        if (endPage >= totalPage) endPage = totalPage;

        model.addAttribute("cnt", cnt);  // 전체 글 개수
        model.addAttribute("page", page); // 현재 페이지
        model.addAttribute("totalPage", totalPage);  // 총 '페이지' 수
        model.addAttribute("pageRows", pageRows);  // 한 '페이지' 에 표시할 글 개수

        // [페이징]
        model.addAttribute("url", U.getRequest().getRequestURI());  // 목록 url
        model.addAttribute("writePages", writePages); // [페이징] 에 표시할 숫자 개수
        model.addAttribute("startPage", startPage);  // [페이징] 에 표시할 시작 페이지
        model.addAttribute("endPage", endPage);   // [페이징] 에 표시할 마지막 페이지

        // 해당 페이지의 글 목록 읽어오기
        List<Write> list = writeRepository.selectFromRow(fromRow, pageRows);
        model.addAttribute("list", list);

        return list;
    }



    public int update(Write write){
        return writeRepository.update(write);
    }

    public int deleteById(long id){
        int result = 0;

        Write write = writeRepository.findById(id);
        if(write != null) {
            result = writeRepository.delete(write);
        }

        return result;
    }

}