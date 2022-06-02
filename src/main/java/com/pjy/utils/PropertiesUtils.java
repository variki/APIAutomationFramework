package com.pjy.utils;

import com.pjy.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class PropertiesUtils {

    private static final Properties properties= new Properties();
    private static final Map<String,String> MAP = new HashMap<>();

    static{
        try(FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.getFrameworkConfigFilePath())) {
            properties.load(fileInputStream);
        } catch (IOException e) {
           e.printStackTrace();
           System.exit(0);
        }
        properties.entrySet().forEach(e->MAP.put(String.valueOf(e.getKey()),String.valueOf(e.getValue())));
    }

    public static String getValue(String key){
       return MAP.get(key);
    }


}
