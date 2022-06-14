package com.pjy.tests;

import com.pjy.annotations.FrameworkAnnotation;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class AuthTestCases {

    @Test
    @FrameworkAnnotation(autors = {"Sathish"},category = "Auth")
    public static void oAuthTest(){
        given().header("Autorization", "Basic cG9zdG1hbjpwYXNzd29yZA==")
                //.auth()
                //.basic("postman","password")
                .log()
                .all()
                .get("https://postman-echo.com/basic-auth");
    }



}
