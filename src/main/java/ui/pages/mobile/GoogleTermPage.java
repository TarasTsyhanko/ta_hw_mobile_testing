package ui.pages.mobile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.AbstractPage;
import utils.Wait;

public class GoogleTermPage extends AbstractPage {
    private static final Logger log = LogManager.getLogger(GoogleTermPage.class);

    @FindBy(xpath = "//*[@text='Політиці конфіденційності']")
    private WebElement label;

    @FindBy(xpath = "//*[@text='Прийняти']")
    private WebElement acceptButton;

    @FindBy(xpath = "//*[@text='Більше']")
    private WebElement moreButton;

    @FindBy(id = "google_services_tos")
    private WebElement googleBla;

    public void acceptGoogleTerms() {
        log.info("accept google term");
        Wait.forVisibilityOf(label);
        acceptButton.click();
        Wait.forVisibilityOf(moreButton).click();
        Wait.forVisibilityOf(acceptButton).click();
    }
}
