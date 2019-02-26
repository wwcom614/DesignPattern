package com.ww.design_pattern.pattern.creational.builder;

public class ProductBuilder {
    private String cpu;
    private String mem;
    private String harddisk;
    private String mainboard;

    public ProductBuilder(ComputerBuilder computerBuilder){
        this.cpu = computerBuilder.cpu;
        this.mem = computerBuilder.mem;
        this.harddisk = computerBuilder.harddisk;
        this.mainboard = computerBuilder.mainboard;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("【Computer】:{CPU=").append(cpu).
                append(", Mem=").append(mem).
                append(", HardDisk=").append(harddisk).
                append(", MainBoard=").append(mainboard);
        return sb.toString();
    }

    public static class ComputerBuilder{
        private String cpu;
        private String mem;
        private String harddisk;
        private String mainboard;

       //组装各个组件
       public ComputerBuilder buildCPU(String name){
            this.cpu = name;
            return this;
        }

        public ComputerBuilder buildMem(String name){
            this.mem = name;
            return this;
        }

        public ComputerBuilder buildHD(String name){
            this.harddisk = name;
            return this;
        }

        public ComputerBuilder buildMainBoard(String name){
            this.mainboard = name;
            return this;
        }

        //组件组装完成，生成产品
        public ProductBuilder build(){
            return new ProductBuilder(this);
        }
    }


}
