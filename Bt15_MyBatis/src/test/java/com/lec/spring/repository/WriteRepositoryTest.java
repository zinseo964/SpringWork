package com.lec.spring.repository;

import com.lec.spring.service.BoardService;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WriteRepositoryTest {
    @Autowired
    private SqlSession sqlSession;

    @Test
    void test1(){
        WriteRepository writeRepository = sqlSession.getMapper(WriteRepository.class);
        writeRepository.incViewCnt(16L);
        System.out.println(writeRepository.findById((16L)));
        System.out.println("!!!!Test!!!!");
    }

    @Test
    void test2(){
        WriteRepository writeRepository = sqlSession.getMapper(WriteRepository.class);

        System.out.println(writeRepository.findAll());
        System.out.println("!!!!Test!!!!");
    }
}