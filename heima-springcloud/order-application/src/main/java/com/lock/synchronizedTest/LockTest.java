package com.lock.synchronizedTest;

import com.lock.pojo.A;

public class LockTest {
    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        long start = System.currentTimeMillis();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                a.increase();
            }
        });
        thread1.start();

        for (int i = 0; i < 10000000; i++) {
            a.increase();
        }
        thread1.join();
        long end = System.currentTimeMillis();
        System.out.println(String.format("%sms",end-start));
        System.out.println(a.getCount());
    }
}
