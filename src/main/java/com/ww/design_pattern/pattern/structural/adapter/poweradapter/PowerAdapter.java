package com.ww.design_pattern.pattern.structural.adapter.poweradapter;

import lombok.extern.java.Log;

@Log
public class PowerAdapter implements IDC5V {
    //组合已有220V交流电类AC220V
    private AC220V ac220V = new AC220V();

    @Override
    public int outputDC5V() {
        int adapterInput = ac220V.outputAC220V();
        //适配层业务逻辑：使用变压器方法将220V交流电转换为5V直流电
        int adapterOutput = adapterInput / 44;

        log.info("【PowerAdapter】：输入交流电" + adapterInput
                + "V ，输出直流电" + adapterOutput + "V");
        return adapterOutput;
    }
}
