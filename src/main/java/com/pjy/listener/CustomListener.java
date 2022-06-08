package com.pjy.listener;

import com.pjy.annotations.FrameworkAnnotation;
import com.pjy.reports.ExtentLogger;
import com.pjy.reports.ExtentReportUtils;
import com.pjy.reports.ExtentTestManager;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite iSuite) {
        ExtentReportUtils.initExtentReports();
    }

    @Override
    public void onFinish(ISuite iSuite) {
        ExtentReportUtils.tearReport();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

        ExtentTestManager.createTest(iTestResult.getName());
        ExtentReportUtils.addAuthors(
        iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).autors());
        ExtentReportUtils.addCategory(iTestResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        ExtentLogger.pass(iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
            ExtentLogger.fail(String.valueOf(iTestResult.getThrowable()));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
            ExtentLogger.skip(iTestResult.getName());
    }
}
