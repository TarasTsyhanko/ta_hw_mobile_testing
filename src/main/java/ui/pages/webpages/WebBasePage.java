package ui.pages.webpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.AbstractPage;
import ui.pages.GmailMainPage;
import utils.Wait;

public class WebBasePage extends AbstractPage implements GmailMainPage {
    private static final Logger log = LogManager.getLogger(WebBasePage.class);
    @FindBy(xpath = "(//android.widget.Button)[3]")
    private WebElement composeButton;

    @FindBy(xpath = "//*[@text='Надіслано.']")
    private WebElement informMessage;

    @FindBy(xpath = "(//android.widget.Button)[1]")
    private WebElement menuPanelButton;

    @FindBy(xpath = "(//android.view.MenuItem)[5]")
    private WebElement sentLettersView;

    public String getAccountRegisterMail() {
       menuPanelButton.click();
       return null;
    }
    @Override
    public void openSentLetterList() {
        log.info("open menu");
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
