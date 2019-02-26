package com.ww.design_pattern.pattern.creational.simplefactory;


public class SimpleFactory {
    //由一个工厂对象决定创建出哪一种产品的实例。
    //简单工厂类的职责相对过重，每次增加新产品对象都要修改工厂类判断逻辑，违背了开闭原则。
    public Fridge produceFridge(String fridgeName){
        if("haier".equalsIgnoreCase(fridgeName)){
            return new HaierFridgeImpl();
        }else if("hisense".equalsIgnoreCase(fridgeName)){
            return new HisenseFridgeImpl();
        }
        return null;
    }

    //引入反射，可使得简单工厂在新增产品时不改动，满足开闭原则
    public Fridge produceFridge(Class c){
        Fridge fridge = null;
        try {
            fridge = (Fridge) Class.forName(c.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return fridge;
    }
}
