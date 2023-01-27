package com.lec.spring.service;

import com.lec.spring.domain.Write;
import com.lec.spring.repository.WriteRepository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

// Service layer
// transaction 담당
@Service
public class BoardService {

    private WriteRepository writeRepository;

    @Autowired
    public BoardService(SqlSession sqlSession) {  // MyBatis 가 생성한 SqlSession 빈(bean) 객체 주입
        writeRepository = sqlSession.getMapper(WriteRepository.class);
        System.out.println("BoardService() 생성");
    }

    public int write(Write write) {
        return writeRepository.save(write);
    }

    // 특정 id 의 글 조회 , 아래의 2가지 transaction 처리
    // 1. 조회수 증가 (UPDATE)
    // 2. 글 읽어오기 (SELECT)
    @Transactional
    public List<Write> detail(long id) {
        List<Write> list = new ArrayList<>();

        writeRepository.incViewCnt(id);
        Write write = writeRepository.findById(id);

        if (write != null) {
            list.add(write);
        }

        return list;
    }

    public List<Write> list(){
            return writeRepository.findAll();
    }

    // 특정 Id 의 글을 읽어오기
    //조회수 증가 없음
    public List<Write> selectById(long id) {
        List<Write> list = new ArrayList<>();

        Write write = writeRepository.findById(id);

        if (write != null) {
            list.add(write);
        }

        return list;
    }

    public int update(Write write){
        return writeRepository.update(write);
    }
}