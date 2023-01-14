package com.lec.spring.beans;

import lombok.Data;

@Data
public class Score {
    int kor;
    int eng;
    int math;
    String comment;

    public Score(){
        super();
        System.out.println("Score() Created");
    }

    public Score(int kor, int eng, int math, String comment) {
        super();
        System.out.printf("Score(%d, %d, %d, %s) Created ! \n", kor, eng, math, comment);
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.comment = comment;
    }


}
