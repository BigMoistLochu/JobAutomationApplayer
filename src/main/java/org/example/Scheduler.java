package org.example;

import org.example.models.JobOffertDto;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public final class Scheduler {

    private static Scheduler INSTANCE;

    private final Timer scheduler = new Timer();
    private Scheduler() {
        TimerTask task_scrap_pracujPL = new TimerTask() {
            @Override
            public void run() {
                PracujPlJobCrawler pracujPlJobCrawler = new PracujPlJobCrawler();
                List<JobOffertDto> offertDtos =  pracujPlJobCrawler.setPage("https://it.pracuj.pl/praca?sc=0&itth=38").scrapJobOffers();

            }
        };
        scheduler.schedule(task_scrap_pracujPL,0,10*60*1000);
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
