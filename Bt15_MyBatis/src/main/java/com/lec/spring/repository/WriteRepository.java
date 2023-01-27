package com.lec.spring.repository;

import com.lec.spring.domain.Write;

// Repository layer
// DataSource(DB) 등에 대한 직접적인 접근 수행 -> MyBatis 가 수행하도록
public interface WriteRepository {

    // write new content <- Write
    int save(Write write);
}
