package ui.pages.mobile;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.AbstractPage;
import ui.pages.GmailCreateLetterPage;

public class MobileCreateLetterPage extends AbstractPage implements GmailCreateLetterPage {
    private static final Logger log = LogManager.getLogger(MobileCreateLetterPage.class);

    @FindBy(id = "to")
    private WebElement recipientInput;
    @FindBy(id = "subject")
    private WebElement subjectInput;
    @FindBy(xpath = "(//android.widget.EditText)[2]")
    private WebElement letterBodyInput;

    @FindBy(id = "send")
    private WebElement sentLetter;

    @Override
    public void inputRecipientLetter(String recipient) {
        log.info("input recipient '+" + recipient);
        recipientInput.sendKeys(recipient);
    }

    @Override
    public void inputSubjectLetter(String subject) {
        log.info("input subject '+" + subject);
        subjectInput.sendKeys(subject);
    }

    @Override
    public void inputTextBodyLetter(String textBody) {
        log.info("input textBody '+" + textBody);
        letterBodyInput.sendKeys(textBody);
    }

    @Override
    public void sendLetter() {
        log.info("send letter by click element");
        sentLetter.click();
    }
}
