package com.lock.pojo;

import java.util.concurrent.atomic.AtomicInteger;

public class A {

    public int count = 0;
    AtomicInteger atomicInteger =  new AtomicInteger(2);

    public void increase(){
//        synchronized(this){
//            count ++;
//        }
        atomicInteger.incrementAndGet();
    }


    public  int getCount() {
//        return count;
        return   atomicInteger.get();
    }

}
