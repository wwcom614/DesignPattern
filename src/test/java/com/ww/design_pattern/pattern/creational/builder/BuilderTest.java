package com.ww.design_pattern.pattern.creational.builder;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class BuilderTest {
    @Test
    public void testBuilder1() throws Exception {
        //小明找到一家组装电脑店，找到老板
        Director director = new Director();
        //老板根据小明诉求，确定了小明的具体装机方案ConcreteBuilder1
        Builder builder = new ConcreteBuilder1();
        //老板实施装机方案
        director.ConstructComputer(builder);

        //根据方案ConcreteBuilder1完成装机，得到组装好的电脑
        Computer computer = builder.GetComputer();
        //展示组装电脑给小明看
        computer.show();
    }
    //【组件】Intel i7 CPU安装完成!
    //【组件】SamSung 8GB Memory安装完成!
    //【组件】14TB Seagate harddisk安装完成!
    //【组件】ASUS mainboard安装完成!
    //【组件】Logitech keyboard and mouse安装完成!
    // 电脑组装完成，请验收!


    @Test
    public void testBuilder2() throws Exception {
        //小明找到一家组装电脑店，找到老板
        Director director = new Director();
        //老板根据小明诉求，确定了小明的具体装机方案ConcreteBuilder2
        Builder builder = new ConcreteBuilder2();
        //老板实施装机方案
        director.ConstructComputer(builder);

        //根据方案ConcreteBuilder2完成装机，得到组装好的电脑
        Computer computer = builder.GetComputer();
        //展示组装电脑给小明看
        computer.show();
    }
    //【组件】AMD CPU安装完成!!
    //【组件】King 16GB Memory安装完成!
    //【组件】8TB WestData harddisk安装完成!
    //【组件】GIGA mainboard安装完成!
    //【组件】Razer keyboard and mouse安装完成!
    // 电脑组装完成，请验收!

    @Test
    public void testBuilderProduct() throws Exception {
        ProductBuilder computer = new ProductBuilder.ComputerBuilder().
                buildCPU("intel").buildMem("kingston").
                buildHD("WestData").buildMainBoard("microStar").build();
        log.info(String.valueOf(computer));
        //【Computer】:{CPU=intel, Mem=kingston, HardDisk=WestData, MainBoard=microStar
    }


}