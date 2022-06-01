package com.pjy.utils;

import com.github.javafaker.Faker;

public final class FakerUtils {
    private FakerUtils(){}

    private static final Faker faker = new Faker();

    static int getNumberBetween(int start,int end){
        return faker.number().numberBetween(start,end);
    }

    static String getFirstname(){
        return faker.name().firstName();
    }

    static String getLastname(){
        return faker.name().lastName();
    }
}
