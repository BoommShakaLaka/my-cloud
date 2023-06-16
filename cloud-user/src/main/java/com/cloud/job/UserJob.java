package com.cloud.job;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UserJob {
    @Scheduled(cron = "${job.cron.redisScheduledJob:0 0/5 * * * ?}")
    @SchedulerLock(name = "redisScheduledJob",lockAtMostFor = "100s",lockAtLeastFor = "5s")
    public void redisScheduledJob() {
        System.out.println("delete user job is running");

    }
}
