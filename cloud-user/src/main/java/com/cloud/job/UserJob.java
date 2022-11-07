package com.cloud.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UserJob {
    @Scheduled(cron = "0 */5 * * * ? ")
    public void deleteUserJob() {
        System.out.println("delete user job is running");
    }
}
