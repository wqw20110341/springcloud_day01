package com.example.order.task;

import java.util.Date;
import java.util.TimerTask;

public class DoSomeThingTimerTask extends TimerTask {
    private String taskName;

    public DoSomeThingTimerTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(new Date() + " : 任务【" + taskName + "]执行啦" );
    }
}
