package factory;

import config.Properties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static final Logger log = LogManager.getLogger(DriverFactory.class);

    protected static AppiumDriver<MobileElement> createDriver() {
        AndroidDriver<MobileElement> driver;
        driver = new AndroidDriver<>(getURL(), CapabilitiesFactory.getCapabilities());
        setWait(driver, 30);
        driver.currentActivity();
        return driver;
    }

    private static URL getURL() {
        try {
            return new URL(Properties.getAppiumServer());
        } catch (MalformedURLException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void setWait(WebDriver driver, int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    private DriverFactory() {

    }
}
