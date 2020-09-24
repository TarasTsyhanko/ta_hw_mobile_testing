package ui.pages.nativepages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.AbstractPage;
import ui.pages.AppWelcomePage;
import utils.Wait;

public class WelcomeGmailPage extends AbstractPage implements AppWelcomePage {
    private static final Logger log = LogManager.getLogger(WelcomeGmailPage.class);

    @FindBy(id = "welcome_tour_got_it")
    private WebElement gotItButton;

    @FindBy(id = "setup_addresses_add_another")
    private WebElement addUserLink;

    @FindBy(id = "account_display_name")
    private WebElement userName;

    @FindBy(id = "action_done")
    private WebElement goToGmailLetter;


   public void openGmailMainPage(){
       log.info("open gmail main page");
       Wait.forVisibilityOf(userName);
       goToGmailLetter.click();
   }

    @Override
    public void openGoogleLoginPage() {
        log.info("open gmail login page");
        gotItButton.click();
        addUserLink.click();
    }
}
