package com.example.water_fee.util;

import java.util.Random;

public class KeyUtil {
    public static synchronized String createUniqueKey() {
        Random random = new Random();
        Integer key = random.nextInt(900) + 100;
        return System.currentTimeMillis() + String.valueOf(key);
    }
}
