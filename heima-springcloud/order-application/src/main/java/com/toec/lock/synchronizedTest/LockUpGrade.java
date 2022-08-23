package com.toec.lock.synchronizedTest;

import com.toec.lock.pojo.User;
import org.openjdk.jol.info.ClassLayout;

public class LockUpGrade {
    public static void main(String[] args) throws InterruptedException {
        User user = new User();
        System.out.println("无状态（001）："+ ClassLayout.parseInstance(user).toPrintable());

        /*  jvm默认延时4s自动开启偏向锁，可通过-XX:BiasedLockingStartupDelay=0取消延时;
        如果不要偏向锁，可通过-XX :—UseBiasedLocking = false来设置*/

        Thread.sleep(5000);
        User userTmp = new User();
        System.out.println("启用偏向锁（101）："  + ClassLayout.parseInstance(userTmp).toPrintable());
        for (int i = 0; i < 2; i++) {
            synchronized (userTmp){
                System.out.println("偏向锁（101）线程id：" + ClassLayout.parseInstance(userTmp).toPrintable() );
            }
            System.out.println("偏向锁（101）线程id：" + ClassLayout.parseInstance(userTmp).toPrintable() );
        }

        new Thread(()->{
            synchronized (userTmp){
                System.out.println("轻量级锁（00）："+ClassLayout.parseInstance(userTmp).toPrintable());
                try {
                    System.out.println("睡眠3秒钟……………………===========");
                    Thread.sleep(3000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            System.out.println("轻量级--->重量（10）："+ ClassLayout.parseInstance(userTmp).toPrintable());
        }).start();

        Thread.sleep(1000);
        new Thread(()->{
            synchronized (userTmp){
                System.out.println("重量级锁（10）："+ ClassLayout.parseInstance(userTmp).toPrintable());
            }
        }).start();
    }
}
