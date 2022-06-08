package com.pjy.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentTestManager {

    private ExtentTestManager(){}
    private static ThreadLocal<ExtentTest> exTest = new ThreadLocal<>();

    public static void createTest(String testname){
        exTest.set(ExtentReportUtils.createTest(testname));
    }

    static ExtentTest getTest() {
        return exTest.get();
    }
}
