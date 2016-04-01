package com.example.chaitanya.floatview;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by chaitanya on 01/04/16.
 */
public class ProcessService extends Service {


    private static final int IS_FOREGROUND = 100;
    private TimerTask timerTask;
    private Timer timer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        startTimer();
    }

    private void startTimer() {
        timer = new Timer();
        initTimerTask();
        timer.schedule(timerTask, 1000, 2000);
    }

    private void initTimerTask() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                getRunningProcess();
            }
        };
    }

    private void getRunningProcess() {
        List<ActivityManager.RunningAppProcessInfo> tasks = ((ActivityManager) getSystemService(ACTIVITY_SERVICE)).getRunningAppProcesses();
        if (tasks == null) {
            return;
        }

//        List<ActivityManager.RunningAppProcessInfo> taskList = tasks.subList(0, tasks.size() - 1);
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : tasks) {
            if (runningAppProcessInfo.importance == IS_FOREGROUND) {
                Log.i("Running Process", runningAppProcessInfo.processName);
            }
            Calendar.
        }
    }
}
