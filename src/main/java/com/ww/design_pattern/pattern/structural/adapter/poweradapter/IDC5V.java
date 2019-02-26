package com.ww.design_pattern.pattern.structural.adapter.poweradapter;

//目标转换为5V直流电，才能给手机充电
public interface IDC5V {
    int outputDC5V();
}
