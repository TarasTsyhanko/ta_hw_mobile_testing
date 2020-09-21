package factory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DriverContainer {

    private static AppiumDriver<MobileElement>  DRIVER;

    public static AppiumDriver<MobileElement> getDriver() {
        if (DRIVER == null) {
            DRIVER = DriverFactory.createDriver();
        }
        return DRIVER;
    }

    public static void closeApp() {
        if (DRIVER != null) {
            DRIVER.closeApp();
            DRIVER = null;
        }
    }


    private DriverContainer() {

    }
}
