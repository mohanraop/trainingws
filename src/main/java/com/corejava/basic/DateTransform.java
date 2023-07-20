package com.corejava.basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class DateTransform {

    public static List<String> transformDateFormat(List<String> dates) {
        SimpleDateFormat sd1 = new SimpleDateFormat("YYYY/MM/DD");
        SimpleDateFormat sd2 = new SimpleDateFormat("DD/MM/YYYY");
        SimpleDateFormat sd3 = new SimpleDateFormat("MM-DD-YYYY");
        SimpleDateFormat outFormat = new SimpleDateFormat("YYYYMMDD");

        return dates.stream()
                .map(st->{
                    Date dt = parseDate(st,sd1)  ;
                    if(dt == null)
                        dt = parseDate(st,sd2)  ;
                    if(dt == null)
                        dt = parseDate(st,sd3)  ;
                    return dt;
                }).filter(dt-> dt !=null).map(dt->outFormat.format(dt))
                .collect(Collectors.toList());

    }

    public static Date parseDate(String input,SimpleDateFormat simpleDateFormat)  {
        Date returnDate = null;
        try {
            returnDate =  simpleDateFormat.parse(input);
        } catch (ParseException e) {
            return returnDate;
        }
        return returnDate;
    }
    public static void main(String[] args) {
        List<String> dates = transformDateFormat(Arrays.asList("2010/02/20", "19/12/2016", "11-18-2012", "20130720"));
        for(String date : dates) {
            System.out.println(date);
        }
    }
}