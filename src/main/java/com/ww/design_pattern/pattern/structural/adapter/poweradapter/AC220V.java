package com.ww.design_pattern.pattern.structural.adapter.poweradapter;

import lombok.extern.java.Log;

//家里已有的墙上交流电。
@Log
public class AC220V {
    public int outputAC220V(){
        int output = 220;
        log.info("【AC220V】：输出交流电"+output+"V");
        return output;
    }
}
