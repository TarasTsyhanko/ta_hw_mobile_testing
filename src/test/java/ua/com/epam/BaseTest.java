package ua.com.epam;


import factory.DriverContainer;
import injection.PageModule;
import listener.GmailTestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Guice;
import org.testng.annotations.Listeners;

@Guice(modules = {PageModule.class})
@Listeners(GmailTestListener.class)
public class BaseTest {

    @AfterMethod(alwaysRun = true)
    public void closeApp() {
        DriverContainer.closeApp();
    }
}
