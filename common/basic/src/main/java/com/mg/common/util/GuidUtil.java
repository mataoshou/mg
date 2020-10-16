package com.mg.common.util;

import java.util.UUID;


public class GuidUtil {

    public static String gen()
    {
        String s = UUID.randomUUID().toString();
        String s2 = s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
        return s2.toUpperCase();
    }
}
