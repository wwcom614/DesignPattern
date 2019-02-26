package com.ww.design_pattern.principle.openclose;

import java.math.BigDecimal;

//新需求是获取打折商品。
//对修改关闭抽象框架：不改接口和现有实现类，
//对功能实现扩展开放：增加一个子类继承现有实现类完成功能
public class DiscountItemInfoImpl extends ItemInfoImpl {
    public DiscountItemInfoImpl(Integer id, String name, BigDecimal price) {
        super(id, name, price);
    }

    public BigDecimal getDiscountPrice(){
        return super.getPrice().multiply(BigDecimal.valueOf(0.8));
    }


}
