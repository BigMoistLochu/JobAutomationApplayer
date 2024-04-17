package org.example;

import org.example.crawlers.PracujPlJobCrawler;
import org.example.models.JobOffertDto;

import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public final class Scheduler {

    private static Scheduler INSTANCE;

    private final Timer scheduler = new Timer();
    private Scheduler() {
        TimerTask firstScrappForPracujPl = getFirstScrappForPracujPl();
        firstScrappForPracujPl.run();

        TimerTask taskForPracujPL = createTaskForPracujPl();

        scheduler.schedule(taskForPracujPL,0,1*60*1000);
    }

    public synchronized static Scheduler getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Scheduler();
        }
        return INSTANCE;
    }
    private TimerTask getFirstScrappForPracujPl()
    {
        return new TimerTask() {
            @Override
            public void run() {
                PracujPlJobCrawler pracujPlJobCrawler = new PracujPlJobCrawler();
                List<JobOffertDto> offertJobs =  pracujPlJobCrawler.setPage("https://it.pracuj.pl/praca?sc=0&itth=38").scrapJobOffers();

                for(JobOffertDto job: offertJobs)
                {
                    ContainerForJobOfferts.addOfferToMapOnce(job,"PracujPl");
                }
            }
        };
    }

    private TimerTask createTaskForPracujPl()
    {
        return new TimerTask() {
            @Override
            public void run() {
                PracujPlJobCrawler pracujPlJobCrawler = new PracujPlJobCrawler();
                List<JobOffertDto> offertJobs =  pracujPlJobCrawler.setPage("https://it.pracuj.pl/praca?sc=0&itth=38").scrapJobOffers();

                for(JobOffertDto job: offertJobs)
                {
                    try {
                        ContainerForJobOfferts.addOffertToMapAndSendToDiscordIfOffertIsNew(job,"PracujPL");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
    }
}
