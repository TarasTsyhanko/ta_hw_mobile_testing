package ui.pages.desktop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.AbstractPage;
import utils.Wait;

public class DesktopLoginPage extends AbstractPage implements ui.pages.LoginPage {
    private static final Logger log = LogManager.getLogger(DesktopLoginPage.class);

    @FindBy(xpath = "//*[@resource-id='identifierId']")
    private WebElement loginInput;

    @FindBy(xpath = "//*[@text='Далі']")
    private WebElement nextButton;


    @Override
    public void inputLoginAndSubmit(String login) {
        log.info("input login'" + login);
        Wait.forVisibilityOf(loginInput).sendKeys(login);
        log.info("click to element ");
        nextButton.click();
    }
}
