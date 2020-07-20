package com.dasun.desingpattern;

/**
 * The DBManager - Singleton pattern
 */
public class SingletonDemo {

    private static volatile SingletonDemo singletonDemo;

    private SingletonDemo() {
        if (singletonDemo != null) {
            throw new RuntimeException("please use get db manager method");
        }
    }


    /**
     * Global access point
     * @return :SingletonDemo
     */
    public SingletonDemo getDbManager() {
        if (singletonDemo == null) {
            synchronized (SingletonDemo.class) {
                if (singletonDemo == null) {
                    singletonDemo = new SingletonDemo();
                }
            }
        }
        return singletonDemo;
    }


}
