package com.ww.design_pattern.principle.demeter;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeMeterTest {

    //迪米特原则。
    @Test
    public void testDeMeter() throws Exception {
        Teacher teacher = new Teacher();
        Student student = new Student();
        teacher.commandCountCourse(student);
    }
    //【Student】：我学过的课程的数量是：20

}