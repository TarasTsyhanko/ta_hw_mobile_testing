package ui.pages.mobile;

import com.google.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.AbstractPage;
import ui.pages.LoginPage;
import utils.Wait;

public class MobileLoginPage extends AbstractPage implements LoginPage {
    private static final Logger log = LogManager.getLogger(MobileLoginPage.class);

    @Inject
    private SettingGmailPage settingPage;

    @FindBy(className = "android.widget.EditText")
    private WebElement loginInput;
    @FindBy(xpath = "(//android.widget.Button)[3]")
    private WebElement nextButton;

    @Override
    public void inputLoginAndSubmit(String login) {
        log.info("input login'" + login);
        settingPage.goToGoogleAccountLoginForm();
        Wait.forVisibilityOf(loginInput).sendKeys(login);
        log.info("click to element ");
        nextButton.click();
    }
}
