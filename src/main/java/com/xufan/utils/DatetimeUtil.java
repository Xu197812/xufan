package com.xufan.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author XuFan
 * @create 2023-05-06-9:52
 */
public class DatetimeUtil {
    //时间戳转yyyy-MM-dd HH:mm:ss格式
    public static String dateParse(String startDate) throws ParseException {
        startDate = "2023-01-01";
        startDate = "2023-04-22 11:59:59";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(startDate);
        System.out.println(date.getTime());
        return String.valueOf(date.getTime());
    }
}
