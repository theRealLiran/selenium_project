package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.*;

import java.util.Map;

public class TestListener implements ISuiteListener, ITestListener, IInvokedMethodListener, ITestNGListener {

    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");

    /**
     * Suite Listeners
     */

    @Override
    public void onStart(ISuite suite) {
    }

    @Override
    public void onFinish(ISuite suite) {
    }


    /**
     * Test Listeners
     */

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Starting Test: " + getTestMethodName(result));
    }

    @Override
    public void onStart(ITestContext context) {
        extent.attachReporter(spark);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extent.createTest(getTestMethodName(result))
                .log(Status.PASS, getTestMethodName(result) + " passed!");
        System.out.println(getTestMethodName(result) + " Passed! :) ");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extent.createTest(getTestMethodName(result))
                .log(Status.FAIL, getTestMethodName(result) + " failed!");
        System.out.println(getTestMethodName(result) + " Failed! :( ");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(getTestMethodName(result) + " Skipped! :| ");
    }


    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }


    /**
     * Method Listeners
     */

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
//        showMessage("About to run ", method, testResult);
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
//        showMessage("Completed running ", method, testResult);
    }


    private void showMessage(String prefix, IInvokedMethod method, ITestResult testResult) {
        String msg;
        if (getTestXmlParams(method, testResult) != null) {
            msg = prefix + method.getTestMethod().getMethodName() + "() with the parameters " + getTestXmlParams(method, testResult);
        } else {
            msg = prefix + method.getTestMethod().getMethodName();
        }
        System.out.println(msg);
    }

    private Map<String, String> getTestXmlParams(IInvokedMethod method, ITestResult testResult) {
        if (method.getTestMethod().findMethodParameters(testResult.getTestContext().getCurrentXmlTest()).isEmpty()) {
            return null;
        } else {
            return method.getTestMethod().findMethodParameters(testResult.getTestContext().getCurrentXmlTest());
        }
    }

    private String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    private byte[] saveScreenShotAsPNG() {
        return null;
    }

    private String saveTextLog(String message) {
        return message;
    }
}
