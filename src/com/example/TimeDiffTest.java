package com.example;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

public class TimeDiffTest {

    static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    static {
        FORMAT.setTimeZone(TimeZone.getTimeZone("Asia/Omsk"));
    }

    static final long TEN_MIN = 10 * 60 * 1000;

    long getTimeDiff(String from, String to) throws ParseException {
        Date dateFrom = FORMAT.parse(from);
        Date dateTo = FORMAT.parse(to);
        return dateTo.getTime() - dateFrom.getTime();
    }

    @Test
    public void testSummerTime() throws ParseException {
        assertEquals(TEN_MIN, getTimeDiff("2014-10-25 01:55", "2014-10-25 02:05"));
    }

    @Test
    public void testWinterTime() throws ParseException {
        assertEquals(TEN_MIN, getTimeDiff("2014-10-27 01:55", "2014-10-27 02:05"));
    }

    @Test
    public void testTimeSwitch() throws ParseException {
//        assertEquals(TEN_MIN * 6 + TEN_MIN, getTimeDiff("2014-10-26 01:55", "2014-10-26 02:05"));
        assertEquals(TEN_MIN * 6 + TEN_MIN, getTimeDiff("2014-10-26 00:55", "2014-10-26 01:05"));
        assertEquals(TEN_MIN, getTimeDiff("2014-10-26 01:55", "2014-10-26 02:05"));
    }

}
