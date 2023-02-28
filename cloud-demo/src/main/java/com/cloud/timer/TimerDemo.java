package com.cloud.timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        // 指定5秒后执行任务
        timer.schedule(new Task(), 5000);
        // 指定1秒后开始，每隔3秒执行一次任务
        timer.schedule(new MyTimerTask(), 1000, 3000);
    }

    private static class Task extends TimerTask {
        @Override
        public void run() {
            System.out.println("Task executed at " + System.currentTimeMillis());
        }
    }
}
