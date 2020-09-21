package ui.pages.mobile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.AbstractPage;
import ui.pages.desktop.DesktopLoginPage;

import java.util.List;

public class MobileSentLettersPage extends AbstractPage implements ui.pages.GmailSentLettersPage {
    private static final Logger log = LogManager.getLogger(MobileSentLettersPage.class);

    @FindBy(xpath = "//android.support.v7.widget.RecyclerView/android.view.ViewGroup")
    private List<WebElement> sentMessagesListView;

    @Override
    public void openLastSentLetter() {
        log.info("open last sent letter");
        sentMessagesListView.get(0).click();
    }
}
