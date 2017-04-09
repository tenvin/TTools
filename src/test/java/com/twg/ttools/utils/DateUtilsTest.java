package com.twg.ttools.utils;


import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtilsTest {

    /**
     * Method: countDays(Date begin, Date end)
     */
    @Test
    public void testCountDays() throws Exception {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date begin= myFormatter.parse("2016-02-01");
        Date end= myFormatter.parse("2016-03-01");

        System.out.println(DateUtil.countDays(begin,end));
    }


} 
