package com.ww.design_pattern.principle.demeter;

public class Teacher {

    public void commandCountCourse(Student student){
        student.countCourse();
    }

}
