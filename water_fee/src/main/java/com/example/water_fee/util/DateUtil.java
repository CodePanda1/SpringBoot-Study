package com.example.water_fee.util;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static ArrayList<String> getMonthBetween() throws Exception {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -4);
        StringBuilder sb = new StringBuilder();
        sb.append(c.get(Calendar.YEAR)).append("-").append(c.get(Calendar.MONTH));
        String before_six = sb.toString();

        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

//        min.setTime(sdf.parse(minDate));
        min.setTime(sdf.parse(before_six));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

//        max.setTime(sdf.parse(maxDate));
        max.setTime(sdf.parse(sdf.format(new Date())));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar current = min;
        while (current.before(max)) {
            result.add(sdf.format(current.getTime()));
            current.add(Calendar.MONTH, 1);
        }

        return result;
    }
}
