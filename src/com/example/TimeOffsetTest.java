package com.example;

import org.junit.Test;

import java.util.Calendar;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

public class TimeOffsetTest {

    static final TimeZone TIME_ZONE = TimeZone.getTimeZone("Asia/Omsk");

    static final long HOUR = 60 * 60 * 1000;

    @Test
    public void testSummerTime() {
        Calendar calendar = Calendar.getInstance(TIME_ZONE);
        calendar.set(2014, Calendar.OCTOBER, 25, 1, 55);
        assertEquals(7 * HOUR, calendar.get(Calendar.ZONE_OFFSET));
    }

    @Test
    public void testWinterTime() {
        Calendar calendar = Calendar.getInstance(TIME_ZONE);
        calendar.set(2014, Calendar.OCTOBER, 27, 1, 55);
        assertEquals(6 * HOUR, calendar.get(Calendar.ZONE_OFFSET));
    }

    @Test
    public void testTimeSwitch() {
        Calendar calendar = Calendar.getInstance(TIME_ZONE);
        calendar.set(2014, Calendar.OCTOBER, 26, 0, 55);
        assertEquals(7 * HOUR, calendar.get(Calendar.ZONE_OFFSET));
        calendar.set(2014, Calendar.OCTOBER, 26, 1, 55);
//        assertEquals(7 * HOUR, calendar.get(Calendar.ZONE_OFFSET));
        assertEquals(6 * HOUR, calendar.get(Calendar.ZONE_OFFSET));
        calendar.set(2014, Calendar.OCTOBER, 26, 2, 05);
        assertEquals(6 * HOUR, calendar.get(Calendar.ZONE_OFFSET));
    }

}
