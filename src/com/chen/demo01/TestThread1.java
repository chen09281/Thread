package com.chen.demo01;

// 创建线程方式1：继承Thread类，重写run方法，调用start开启线程

// 总结：注意，线程开启不一定立即执行，由CPU调度
public class TestThread1 extends Thread{
    @Override
    public void run() {
        // run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码------"+i);
        }
    }

    public static void main(String[] args) {
        // main线程，主线程

        // 创建一个线程对象
        TestThread1 testThread1 = new TestThread1();

        // 调用start方法开启线程
        testThread1.start();


        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习多线程------"+i);
        }
    }
}
