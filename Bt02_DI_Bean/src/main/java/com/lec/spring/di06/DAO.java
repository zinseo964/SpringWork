package com.lec.spring.di06;

public interface DAO {
}

//DAO 구현 클래스
class DAOImpl implements DAO {
    String uid;

    public DAOImpl() {
        System.out.println("DAOImpl() Created !");
    }

    public DAOImpl(String uid) {
        System.out.printf("DAOImpl(%s) Created! \n", uid);
        this.uid = uid;
    }

    @Override
    public String toString() {
        return String.format("[DAOImpl: %s]", this.uid);
    }
}
