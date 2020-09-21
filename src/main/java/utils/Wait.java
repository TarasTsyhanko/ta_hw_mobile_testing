package utils;

import factory.DriverContainer;
import factory.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.function.Function;
import java.util.function.Supplier;


public class Wait {
    private static final int EXPLICITLY_TIME = 30;

    private static <T> T runWithZeroImplicitly(Supplier<T> supplier) {
        DriverFactory.setWait(DriverContainer.getDriver(), 0);
        T element = supplier.get();
        DriverFactory.setWait(DriverContainer.getDriver(), 30);
        return element;
    }

    public static <T> T until(Function<? super WebDriver, T> isTrue) {
        return runWithZeroImplicitly(() ->
                new WebDriverWait(DriverContainer.getDriver(), EXPLICITLY_TIME)
                        .ignoring(WebDriverException.class)
                        .pollingEvery(Duration.of(1, ChronoUnit.SECONDS))
                        .until(isTrue));
    }


    public static void untilPageToBeToBeRefreshed() {
        DriverContainer.getDriver().navigate().refresh();
    }

    public static WebElement forVisibilityOf(WebElement element) {
        return until(ExpectedConditions.visibilityOf(element));
    }

    public static boolean untilTextToBe(WebElement element, String expectedText) {
        return until(ExpectedConditions.textToBePresentInElement(element, expectedText));
    }

    public static boolean forUrlContains(String text) {
        return until(ExpectedConditions.urlContains(text));
    }

    public static boolean forUrlToRe(String url) {
        return until(ExpectedConditions.urlToBe(url));
    }


    public static void forScrollToElementByText(String visibleText) {
        ((AndroidDriver<MobileElement>)DriverContainer.getDriver())
                .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()" +
                        ".scrollable(true).instance(0))" +
                        ".scrollIntoView(new UiSelector()" +
                        ".textContains(\""+visibleText+"\").instance(0))");
    }
}
