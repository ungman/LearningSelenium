package io.github.ungman.learnig.seleniumwithtestng;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName()+" test case started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("The name of the testcase success is :" + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("The name of the testcase failed is :" + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("The name of the testcase Skipped is :"+result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("The name of the testcase failed within Success Percentage is :" + result.getName());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("The name of the testcase failed with Timeout is :" + result.getName());

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
