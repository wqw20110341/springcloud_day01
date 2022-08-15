package com.lock.reentrantLockTest;

import java.util.concurrent.locks.ReentrantLock;

public class Test01 {
    private static ReentrantLock lock = new ReentrantLock() ;
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                drawMoney();
                lock.unlock();
            }
        },"线程1").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                drawMoney();
                lock.unlock();
            }
        },"线程2").start();
    }

    private static void drawMoney() {
        System.out.println(Thread.currentThread().getName()+"正在取钱……………………");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+"取完钱了……………………");
    }
}
