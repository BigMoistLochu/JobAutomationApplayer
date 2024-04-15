package org.example;

import org.example.models.JobOffertDto;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public final class Scheduler {

    private static Scheduler INSTANCE;

    private final Timer scheduler = new Timer();
    private Scheduler() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                PracujPlJobCrawler pracujPlJobCrawler = new PracujPlJobCrawler();
                List<JobOffertDto> offertDtos =  pracujPlJobCrawler.setPage("https://it.pracuj.pl/praca?sc=0&itth=38").scrapJobOffers();
            }
        };
        scheduler.schedule(timerTask,0,10*60*1000);
    }

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
