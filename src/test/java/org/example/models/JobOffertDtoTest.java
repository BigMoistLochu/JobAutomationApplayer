package org.example.models;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class JobOffertDtoTest {

    @Test
    void twoObjectWithTheSameCredentialsShouldBeEquals() {

        LocalDateTime theSameTimeForTwoObject = LocalDateTime.now();
        JobOffertDto jobOffert1 = new JobOffertDto("RandomTitle","RandomLink",theSameTimeForTwoObject);
        JobOffertDto jobOffert2 = new JobOffertDto("RandomTitle","RandomLink",theSameTimeForTwoObject);
        assertEquals(jobOffert1,jobOffert2);
        assertEquals(jobOffert2,jobOffert1);
        assertTrue(jobOffert1.equals(jobOffert2));
        assertTrue(jobOffert2.equals(jobOffert1));
        assertEquals(jobOffert1.hashCode(),jobOffert2.hashCode());
        assertEquals(jobOffert2.hashCode(),jobOffert1.hashCode());
    }

    @Test
    void twoObjectWithDifferentCredentialsShouldBeNotEquals() {

        LocalDateTime theSameTimeForTwoObject = LocalDateTime.now();
        JobOffertDto jobOffert1 = new JobOffertDto("RandomTitle","RandomLink",theSameTimeForTwoObject);
        JobOffertDto jobOffert2 = new JobOffertDto("RandomDiffTitle","RandomDiffLink",theSameTimeForTwoObject);

        assertNotEquals(jobOffert1,jobOffert2);
        assertNotEquals(jobOffert2,jobOffert1);
        assertFalse(jobOffert1.equals(jobOffert2));
        assertFalse(jobOffert2.equals(jobOffert1));
        assertNotEquals(jobOffert1.hashCode(),jobOffert2.hashCode());
        assertNotEquals(jobOffert2.hashCode(),jobOffert1.hashCode());
    }
}