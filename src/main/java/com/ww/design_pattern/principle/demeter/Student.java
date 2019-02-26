package com.ww.design_pattern.principle.demeter;

import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

@Log
public class Student {
    public void countCourse() {

        List<Course> courseList = new ArrayList<>();
        for(int i = 0 ;i < 20;i++){
            courseList.add(new Course());
        }
        log.info("【Student】：我学过的课程的数量是："+courseList.size());
    }
}
