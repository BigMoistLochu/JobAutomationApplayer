package org.example.crawlers;

import com.microsoft.playwright.*;
import org.example.models.JobOffertDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JobsCrawler {
    private final Playwright playwright = Playwright.create();
    private final Page page =  playwright.firefox().launch().newPage(); //new BrowserType.LaunchOptions().setHeadless(false) if you wanna see a browser



    public List<JobOffertDto> scrapJobsFromPracujPLWebsite(String url)
    {
        page.navigate(url);
        page.waitForLoadState();
        List<JobOffertDto> allJobsFromWebsite = new ArrayList<>();

        //to 50 offer bcs this is one page
        for (int i = 1; i <= 50; i++)
        {
            try
            {
                String increaseJobOfferNumberInLocator = ".core_c1sbal7t > div:nth-child(3) > div:nth-child("+ i +")";
                String restOfCorrectLocator = " > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > h2:nth-child(3) > a:nth-child(1)";
                Locator actualLocator = page.locator(increaseJobOfferNumberInLocator + restOfCorrectLocator);
                boolean checkLocator = actualLocator.isVisible();

                if(checkLocator)
                {
                    String title = actualLocator.textContent();
                    //.split("&searchId=")[0] is for remomving unique id from the browser for analyze customer
                    String link = actualLocator.getAttribute("href").split("&searchId=")[0];
                    allJobsFromWebsite.add(new JobOffertDto(title,link, LocalDateTime.now()));
                }
            }
            catch (RuntimeException e)
            {
                System.out.println("wystapil blad: " + e.getMessage());
            }

        }


        playwright.close();
        System.out.println("Scrapper skonczyl zbierac dane z : " + url);
        return allJobsFromWebsite;
    }


    public List<JobOffertDto> scrapJobsFromJustJoinItWebsite(String url)
    {
        List<JobOffertDto> allJobsFromWebsite = new ArrayList<>();
        return allJobsFromWebsite;
    }



}
