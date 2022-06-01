package com.pjy.utils;

import static com.pjy.utils.FakerUtils.*;

public final class RandomValuesUtils {
    private RandomValuesUtils(){
    }

    public static int getId(){
        return getNumberBetween(100,1000);
    }

    public static String getFirstName(){
        return getFirstname();
    }

    public static String getLastName(){
        return getLastname();
    }
}
