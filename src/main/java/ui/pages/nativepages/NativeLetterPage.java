package ui.pages.nativepages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.AbstractPage;
import ui.pages.GmailLetterPage;

public class NativeLetterPage extends AbstractPage implements GmailLetterPage {
    private static final Logger log = LogManager.getLogger(NativeLetterPage.class);

    @FindBy(xpath = "//android.view.View/android.view.View")
    private WebElement letterTextBody;

    @Override
    public String getLetterBodyText() {
        log.info("get letter text from element ");
        return letterTextBody.getText();
    }
}
