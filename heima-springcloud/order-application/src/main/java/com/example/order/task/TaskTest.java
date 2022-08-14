package com.example.order.task;

import java.util.Timer;

public class TaskTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new DoSomeThingTimerTask("DelayOneDemo"),2000L,1000L);
//        timer.schedule(new DoSomeThingTimerTask("DelayOneDemo"),2000L,1000L);
//        timer.cancel();
    }
}
