package ui.pages.mobile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.AbstractPage;
import ui.pages.GmailMainPage;
import utils.Wait;

public class MobileMainPage extends AbstractPage implements GmailMainPage {
    private static final Logger log = LogManager.getLogger(MobileMainPage.class);

    @FindBy(id = "compose_button")
    private WebElement composeButton;

    @FindBy(id="description_text")
    private WebElement informMessage;

    @FindBy(className = "android.widget.ImageButton")
    private WebElement menuPanelButton;

    @FindBy(xpath = "//*[@text='Надіслані']")
    private WebElement sentLettersView;

    public String getAccountRegisterMail() {
        menuPanelButton.click();
        return null;
    }

    @Override
    public void openSentLetterList() {
        log.info("open menu by element");
        Wait.forVisibilityOf(menuPanelButton).click();
        log.info("open sent letters list");
        Wait.forVisibilityOf(sentLettersView).click();
    }

    @Override
    public void openCreateLetterPage() {
        log.info("open create letter form");
        composeButton.click();
    }

    @Override
    public boolean isInformMessageDisplayed() {
        log.info("verify is inform message displayed");
        return informMessage.isDisplayed();
    }
}
