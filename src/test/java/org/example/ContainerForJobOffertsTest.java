package org.example;

import org.example.models.JobOffertDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.*;

class ContainerForJobOffertsTest {

    Map<JobOffertDto,String> testMapOfferts = ContainerForJobOfferts.getAllOfferts();

    @BeforeEach
    public void clearMapBeforeEachTest()
    {
        testMapOfferts.clear();
    }


    @Test
    void Add_Two_Equals_Objects_With_The_Same_Time_To_The_ContainerMap_Is_Not_Possible() {
        LocalDateTime TimeForOffer = LocalDateTime.now();
        JobOffertDto offert1 = new JobOffertDto("TheSameTitle","TheSameRandomLink", TimeForOffer);
        JobOffertDto offert2 = new JobOffertDto("TheSameTitle","TheSameRandomLink", TimeForOffer);
        JobOffertDto offert3 = new JobOffertDto("DiffTitle","DiffRandomLink", TimeForOffer);

        assertTrue(offert1.equals(offert2));
        assertEquals(offert1.hashCode(),offert2.hashCode());

        testMapOfferts.put(offert1,"PracujPL");
        assertEquals(testMapOfferts.size(),1);
        //if the object is the same (hashcode and equals return the same value) then addOffertToMap don't add to Map
        ContainerForJobOfferts.addOffertToMap(offert2,"PracujPL");
        assertEquals(testMapOfferts.size(),1);

        ContainerForJobOfferts.addOffertToMap(offert3,"PracujPL");
        assertEquals(testMapOfferts.size(),2);
    }

    @Test
    void Add_Two_Equals_Objects_With_Different_Time_To_The_ContainerMap_Is_Not_Possible() {

        LocalDateTime TimeForOffer = LocalDateTime.now();
        JobOffertDto offert1 = new JobOffertDto("TheSameTitle","TheSameRandomLink", TimeForOffer.plusSeconds(5));
        JobOffertDto offert2 = new JobOffertDto("TheSameTitle","TheSameRandomLink", TimeForOffer.plusSeconds(10));
        JobOffertDto offert3 = new JobOffertDto("DiffTitle","DiffRandomLink", TimeForOffer);

        assertTrue(offert1.equals(offert2));
        assertEquals(offert1.hashCode(),offert2.hashCode());

        testMapOfferts.put(offert1,"PracujPL");
        assertEquals(testMapOfferts.size(),1);
        //if the object is the same (hashcode and equals return the same value) then addOffertToMap don't add to Map
        ContainerForJobOfferts.addOffertToMap(offert2,"PracujPL");
        assertEquals(testMapOfferts.size(),1);

        ContainerForJobOfferts.addOffertToMap(offert3,"PracujPL");
        assertEquals(testMapOfferts.size(),2);
    }


}