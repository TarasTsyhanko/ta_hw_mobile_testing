package listener;

import factory.DriverContainer;
import injection.PageModule;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GmailTestListener implements ITestListener {
    private static final Logger log = LogManager.getLogger(GmailTestListener.class);

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        log.info("I am in onStart method " + iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        log.info("I am in onFinish method " + iTestContext.getName());
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
        getTestOutput(iTestResult);
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        addScreenToAllure();
        getTestOutput(tr);
        log.info("saved screenshot");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.info("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] addScreenToAllure() {
        return ((TakesScreenshot) DriverContainer.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "logs", type = "text/plain", fileExtension = ".log")
    public static byte[] addFileToAllure(String path) throws IOException {
        File file = new File(path);
        return Files.readAllBytes(Paths.get(file.getPath()));
    }

    @Attachment
    public String getTestOutput(ITestResult result) {
        List<String> list = Reporter.getOutput(result);
        StringBuilder builder = new StringBuilder("------Test OutPut Logging:------\n");
        for (String s : list) {
            builder.append(s).append("\n");
        }
        return builder.toString();
    }

    @Step("Test logs")
    public static void addTestLog(String path) throws IOException {
        addFileToAllure(path);
    }

}
