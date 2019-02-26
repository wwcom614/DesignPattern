package com.ww.design_pattern.pattern.structural.adapter.classadapter;

import com.ww.design_pattern.pattern.structural.adapter.classadapter.ClassAdapter;
import com.ww.design_pattern.pattern.structural.adapter.classadapter.ITarget;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassAdapterTest {
    @Test
    public void testClassAdapter() throws Exception {
        ITarget classAdapter = new ClassAdapter();
        //调用方使用适配器的目标方法，无感知的使用Adaptee被适配者的方法，实现ITarget目标方法。
        classAdapter.targetMethod();
        //【Adaptee】：被适配者的方法
    }
}