package com.leumit.listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.leumit.ExtentManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ExtentReportListener implements ITestListener {

    private ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        ExtentManager.getInstance();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.flushReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String className = result.getTestClass().getRealClass().getSimpleName();
        String category = getCategoryFromClassName(className);
        test = ExtentManager.createTest(result.getMethod().getMethodName(), category);

        // Log test parameters
        Object[] parameters = result.getParameters();
        if (parameters.length > 0) {
            String paramsStr = Arrays.stream(parameters)
                    .map(Object::toString)
                    .collect(Collectors.joining(", "));
            test.log(Status.INFO, "Test started with parameters: " + paramsStr);
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test failed");
        test.log(Status.FAIL, result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test skipped");
    }

    private static String getCategoryFromClassName(String className) {
        switch (className) {
            case "PositiveGuru99BankHomeTest":
                return "Guru99 - Positive Flows";
            case "NegativeGuru99BankHomeTest":
                return "Guru99 - Negative Flows";
            case "PositiveW3SchoolsHtmlTablesTest":
                return "W3Schools - Positive Flows";
            case "NegativeW3SchoolsHtmlTablesTest":
                return "W3Schools - Negative Flows";
            default:
                return "Uncategorized";
        }
    }
}
