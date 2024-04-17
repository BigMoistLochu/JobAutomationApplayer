package org.example;

import org.example.models.JobOffertDto;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContainerForJobOfferts {

    private static final Map<JobOffertDto,String> mapOffers =  new ConcurrentHashMap<>();

    public static void addOfferToMapOnce(JobOffertDto jobOffertDto, String nameDomain)
    {
        if(!mapOffers.containsKey(jobOffertDto))
        {
            mapOffers.put(jobOffertDto,nameDomain);
        }
    }

    public static void addOffertToMapAndSendToDiscordIfOffertIsNew(JobOffertDto jobOffertDto,String nameDomain) throws IOException {
            if(!mapOffers.containsKey(jobOffertDto))
            {
                mapOffers.put(jobOffertDto,nameDomain);
                DiscordWeebHookSender.sendOfferToDiscordChannel(jobOffertDto);
            }
    }

    public static Map<JobOffertDto,String> getAllOfferts()
    {
        return mapOffers;
    }






}
