package com.twg.ttools.utils;

import java.util.Date;

/**
 * Created by kehu4 on 2016/3/8.
 */
public class DateUtils {
    int a;

    public static long countDays(Date begin, Date end){
        long diff = end.getTime() - begin.getTime();
        return diff/(1000*3600*24);
    }

}
