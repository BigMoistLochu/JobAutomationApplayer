package org.example;

import org.example.models.JobOffertDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        PracujPlJobCrawler pracujPlJobCrawler = new PracujPlJobCrawler();
        List<JobOffertDto> offertDtos =  pracujPlJobCrawler.setPage("https://it.pracuj.pl/praca?sc=0&itth=38").scrapJobOffers();

        PracujPlJobCrawler pracujPlJobCrawler2 = new PracujPlJobCrawler();
        List<JobOffertDto> offertDtos2 =  pracujPlJobCrawler2.setPage("https://it.pracuj.pl/praca?sc=0&itth=38").scrapJobOffers();


        for (JobOffertDto job1: offertDtos)
        {
            ContainerForJobOfferts.addOffertToMap(job1,"Pracuj.pl");
        }

        for (JobOffertDto job1: offertDtos2)
        {
            ContainerForJobOfferts.addOffertToMap(job1,"Pracuj.pl");
        }


        Map<JobOffertDto,String> sds = ContainerForJobOfferts.getAllOfferts();
        System.out.println("elo");

    }
}