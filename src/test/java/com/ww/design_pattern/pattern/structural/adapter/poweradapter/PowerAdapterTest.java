package com.ww.design_pattern.pattern.structural.adapter.poweradapter;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class PowerAdapterTest {
    //使用适配器的目标方法outputDC5V，用户作为调用方，无感知的实现了输入交流电到直流电的适配转换。
    @Test
    public void testPowerAdapter() throws Exception {
        IDC5V dc5V = new PowerAdapter();
        dc5V.outputDC5V();
        //【AC220V】：输出交流电220V
        //【PowerAdapter】：输入交流电220V ，输出直流电5V
    }
}