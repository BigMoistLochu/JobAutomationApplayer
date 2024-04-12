package org.example;

import java.util.Timer;
import java.util.TimerTask;

public final class Scheduler {

    private static Scheduler INSTANCE;

    private final Timer scheduler = new Timer();
    private Scheduler() {}

    public synchronized static Scheduler getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Scheduler();
        }
        return INSTANCE;
    }

    public void addTaskToQueue(TimerTask task,long delay,long period)
    {
        scheduler.schedule(task,delay,period);
    }


}
