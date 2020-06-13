package com.system.model;



import lombok.Data;

import java.io.Serializable;
@Data
public class Grade implements Serializable{
    private Student student;
    private Double score;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
