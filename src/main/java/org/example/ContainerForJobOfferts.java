package org.example;

import org.example.models.JobOffertDto;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContainerForJobOfferts {

    private static final Map<JobOffertDto,String> mapOffers =  new ConcurrentHashMap<>();

    public static void addOffertToMap(JobOffertDto jobOffertDto,String nameDomain)
    {
        if(!mapOffers.containsKey(jobOffertDto))
        {
            mapOffers.put(jobOffertDto,nameDomain);
        }
    }

    public static Map<JobOffertDto,String> getAllOfferts()
    {
        return mapOffers;
    }






}
