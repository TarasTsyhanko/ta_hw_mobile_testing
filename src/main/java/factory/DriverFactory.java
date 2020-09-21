package factory;

import config.Properties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    protected static AppiumDriver<MobileElement> createDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        setCapabilities(capabilities);
        AndroidDriver<MobileElement> driver;
        driver = new AndroidDriver<>(getURL(), capabilities);
        setWait(driver, 30);
        driver.currentActivity();
        return driver;
    }

    private static URL getURL() {
        try {
            return new URL(Properties.getAppiumServer());
        } catch (MalformedURLException e) {
            throw new RuntimeException();
        }
    }

    private static void setCapabilities(DesiredCapabilities capabilities) {
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Properties.getDeviseName());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, Properties.getAndroidVersion());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, Properties.getAppPackage());
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, Properties.getAppActivity());
    }

    public static void setWait(WebDriver driver, int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    private DriverFactory() {

    }
}
