package com.pjy.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import lombok.Getter;

public final class ExtentReportUtils {
    private ExtentReportUtils(){}

    private static ExtentReports extent;
    private static ExtentTest test;



    public static void initExtentReports(){
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
        extent.attachReporter(spark);
    }

    public static void tearReport(){
        extent.flush();
    }

    static ExtentTest createTest(String testname){

        test = extent.createTest(testname);
       return test;
    }

    public static void addAuthors(String[] authors){
        for(String author:authors) {
            ExtentTestManager.getTest().assignAuthor(author);
        }
    }

    public static void addCategory(String[] categorys){
        for(String category:categorys){
            ExtentTestManager.getTest().assignCategory(category);
        }
    }




}
