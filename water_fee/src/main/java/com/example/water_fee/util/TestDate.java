package com.example.water_fee.util;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

public class TestDate {

    public static void main(String[] args) throws Exception {

        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -4);
        StringBuilder sb = new StringBuilder();
        sb.append(c.get(Calendar.YEAR)).append(c.get(Calendar.MONTH));
        String before_six = sb.toString();
        ArrayList<String> result = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");// 格式化为年月
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        min.setTime(sdf.parse(before_six));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
        max.setTime(sdf.parse(sdf.format(new Date())));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }
        System.out.println(result);
        //倒序
        Collections.reverse(result);
        System.out.println(result);

    }
}
