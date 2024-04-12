package org.example;

import org.example.models.JobOffertDto;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) throws InterruptedException {

//        PracujPlJobCrawler pracujPlJobCrawler = new PracujPlJobCrawler();
//        List<JobOffertDto> offertDtos =  pracujPlJobCrawler.setPage("https://it.pracuj.pl/praca?sc=0&itth=38").scrapJobOffers();
//
//        PracujPlJobCrawler pracujPlJobCrawler2 = new PracujPlJobCrawler();
//        List<JobOffertDto> offertDtos2 =  pracujPlJobCrawler2.setPage("https://it.pracuj.pl/praca?sc=0&itth=38").scrapJobOffers();
        Scheduler.getInstance();
    }
}