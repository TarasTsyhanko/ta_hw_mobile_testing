package ui.pages.desktop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.AbstractPage;
import ui.pages.GmailLetterPage;
import ui.pages.mobile.MobileLetterPage;

public class DesktopLetterPage extends AbstractPage implements GmailLetterPage {
    private static final Logger log = LogManager.getLogger(DesktopLetterPage.class);

    @FindBy(xpath = "(//*[@resource-id='cv_']//android.view.View[@resource-id]/android.widget.TextView[@text])[4]")
    private WebElement letterTextBody;

    @Override
    public String getLetterBodyText() {
        log.info("get letter text from element");
        return letterTextBody.getText();
    }
}
