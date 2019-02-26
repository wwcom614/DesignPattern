package com.ww.design_pattern.pattern.structural.proxy.db;


public class DataSourceContextHolder {
    //为保证线程安全，使用ThreadLocal做数据资源隔离
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    public static void setDBSource(String dbType){
        CONTEXT_HOLDER.set(dbType);
    }
    public static String getDBSource(){
        return (String)CONTEXT_HOLDER.get();
    }
    public static void clearDBSource(){
        CONTEXT_HOLDER.remove();
    }


}
