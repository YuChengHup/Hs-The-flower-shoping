package com.hs.util;

public class IDUtil {

    private static final Long LIMIT = 10000000000L;
    private static long last = 0;


    public static int getID() {
        // 10 digits.
        long id = System.currentTimeMillis() % LIMIT;
        if (id <= last) {
            id = (last + 1) % LIMIT;
        }
        last = id;
        return (int) id;
    }
}
