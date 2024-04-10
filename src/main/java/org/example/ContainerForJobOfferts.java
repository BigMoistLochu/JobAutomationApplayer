package org.example;

import org.example.models.JobOffertDto;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContainerForJobOfferts {


    private final Map<JobOffertDto,String> mapOffers =  new ConcurrentHashMap<>();

    private final Map<JobOffertDto,String> mapOffersShit = new HashMap<>();


    public Map<JobOffertDto, String> getMapOffers() {
        return mapOffers;
    }

    public Map<JobOffertDto, String> getMapOffersShit() {
        return mapOffersShit;
    }
}
