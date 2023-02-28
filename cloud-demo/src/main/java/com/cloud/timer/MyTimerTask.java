package com.cloud.timer;

import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("this is my timerTask "+System.currentTimeMillis());
    }
}
