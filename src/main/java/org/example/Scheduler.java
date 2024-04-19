package org.example;

import org.example.crawlers.JobsCrawler;
import org.example.models.JobOffertDto;

import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public final class Scheduler {

    private static Scheduler INSTANCE;

    private Scheduler() {

        Thread threadForPracujPlForScanJobsOnce = new Thread(createJobScraperRunnable("PracujPl"));
        Thread threadForJustJoinItForScanJobsOnce = new Thread(createJobScraperRunnable("JustJoinIt"));
        threadForPracujPlForScanJobsOnce.start();
        threadForJustJoinItForScanJobsOnce.start();


//      below is repeatable task for scheduler
        TimerTask taskForPracujPL = createTaskForPracujPl();
        TimerTask taskForJustJoinIt = createTaskForJustJoinIt();
//
        Timer scheduler = new Timer();
//      every 10 minutes scrappers will work
        scheduler.schedule(taskForPracujPL,0,10*60*1000);
        scheduler.schedule(taskForJustJoinIt,0,10*60*1000);
    }

    public synchronized static Scheduler getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Scheduler();
        }
        return INSTANCE;
    }

    private Runnable createJobScraperRunnable(String website)
    {
        return ()->{

            if(website.equals("PracujPl"))
            {
                JobsCrawler jobsCrawlerForPracujPl = new JobsCrawler();
                List<JobOffertDto> offertJobsPracujPL = jobsCrawlerForPracujPl.scrapJobsFromPracujPLWebsite("https://it.pracuj.pl/praca?sc=0&itth=38");
                for(JobOffertDto job: offertJobsPracujPL)
                {
                    ContainerForJobOfferts.addOfferToMapOnce(job,"PracujPl");
                }
            }

            if(website.equals("JustJoinIt"))
            {
                JobsCrawler jobsCrawlerForJustJointIt = new JobsCrawler();
                List<JobOffertDto> offertJobsPracujPL = jobsCrawlerForJustJointIt.scrapJobsFromJustJoinItWebsite("https://justjoin.it/all-locations/java?orderBy=DESC&sortBy=newest");
                for(JobOffertDto job: offertJobsPracujPL)
                {
                    ContainerForJobOfferts.addOfferToMapOnce(job,"JustJoinIt");
                }
            }
        };
    }

    private TimerTask createTaskForJustJoinIt()
    {
        return new TimerTask() {
            @Override
            public void run() {
                JobsCrawler jobsCrawler = new JobsCrawler();
                List<JobOffertDto> offertJobs = jobsCrawler.scrapJobsFromJustJoinItWebsite("https://justjoin.it/all-locations/java?orderBy=DESC&sortBy=newest");
                for(JobOffertDto job: offertJobs)
                {
                    try {
                        ContainerForJobOfferts.sendLatestOfferToDiscord(job,"JustJoinIT");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        };
    }

    private TimerTask createTaskForPracujPl()
    {
        return new TimerTask() {
            @Override
            public void run() {
                JobsCrawler jobsCrawler = new JobsCrawler();
                List<JobOffertDto> offertJobs =  jobsCrawler.scrapJobsFromPracujPLWebsite("https://it.pracuj.pl/praca?sc=0&itth=38");

                for(JobOffertDto job: offertJobs)
                {
                    try {
                        ContainerForJobOfferts.sendLatestOfferToDiscord(job,"PracujPL");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
    }
}
