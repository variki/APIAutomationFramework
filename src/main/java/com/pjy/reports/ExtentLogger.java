package com.pjy.reports;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public final class ExtentLogger {

    private  ExtentLogger(){}

    public static void pass(String details){

        ExtentTestManager.getTest().pass(MarkupHelper.createLabel(details, ExtentColor.GREEN));
    }

    public static void info(String details){
        ExtentTestManager.getTest().info(details);
    }

    public static void fail(String details){
        ExtentTestManager.getTest().fail(MarkupHelper.createLabel(details,ExtentColor.RED));
    }

    public static void passWithJSON(String jsonasString){
        ExtentTestManager.getTest().log(Status.PASS, MarkupHelper.createCodeBlock(jsonasString, CodeLanguage.JSON));
    }

    public static void skip(String details){
        ExtentTestManager.getTest().skip(MarkupHelper.createLabel(details,ExtentColor.AMBER));
    }
    public static void inforWithJSON(String jsonString){
        ExtentTestManager.getTest().log(Status.INFO, MarkupHelper.createCodeBlock(jsonString, CodeLanguage.JSON));
    }

    public static void logRequest(RequestSpecification requestSpecification){
        QueryableRequestSpecification query = SpecificationQuerier.query(requestSpecification);
        info("Request Details below:");
        inforWithJSON(query.getBody());
        for(Header header: query.getHeaders()){
            info(header.getName()+" : "+header.getValue());
        }
    }
}
