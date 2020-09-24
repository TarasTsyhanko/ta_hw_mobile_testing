package ui.pages.webpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.AbstractPage;
import ui.pages.GmailSentLettersPage;

import java.util.List;

public class WebSentLetterPage extends AbstractPage implements GmailSentLettersPage {
    private static final Logger log = LogManager.getLogger(WebSentLetterPage.class);

    @FindBy(xpath = "//android.widget.ListView/android.view.View")
    private List<WebElement> sentMessagesListView;

    @Override
    public void openLastSentLetter() {
        log.info("open last sent letter");
        sentMessagesListView.get(0).click();
    }
}
