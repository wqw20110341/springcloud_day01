package com.example.order.quartzTest;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class quartzMainTest {
    public static void main(String[] args) throws SchedulerException {
        //1、创建任务调度器
        StdSchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        //2、创建JobDetail实例，并与PrintJob类绑定(Job执行内容)
        JobDetail jobDetail = JobBuilder.newJob(PrintJob.class).withIdentity("job", "group").build();
        // 3、构建Trigger实例，每隔1s执行一次
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger", "triggerGroup")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(1).repeatForever()).build();
        //4、Scheduler绑定Job和Trigger，并执行
        scheduler.scheduleJob(jobDetail,trigger);
        System.out.println("---------------scheduler start ! -------------------");
        scheduler.start();
    }
}
