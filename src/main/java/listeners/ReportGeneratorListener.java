package listeners;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.LogStatus;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportGeneratorListener implements ITestListener {

    protected static ExtentReports reports;
    protected static ExtentTest test;

    @Override
    public void onTestStart(ITestResult iTestResult) {
        test = reports.startTest(iTestResult.getMethod().getMethodName());
        test.log(LogStatus.INFO, iTestResult.getMethod().getMethodName() + "test is started");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        test.log(LogStatus.PASS, iTestResult.getMethod().getMethodName() + "test is passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        test.log(LogStatus.FAIL, iTestResult.getMethod().getMethodName() + "test is failed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        test.log(LogStatus.SKIP, iTestResult.getMethod().getMethodName() + "test is skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        reports = new ExtentReports("build/reports/TestReport.html", true);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        reports.endTest(test);
        reports.flush();
    }
}
