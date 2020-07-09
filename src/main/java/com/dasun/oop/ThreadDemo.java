package com.dasun.oop;

public class ThreadDemo extends Thread {

    @Override
    public void run() {
        System.out.println("Thread demo is running");
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();
    }



}
