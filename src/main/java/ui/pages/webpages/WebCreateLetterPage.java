package ui.pages.webpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.AbstractPage;
import ui.pages.GmailCreateLetterPage;

public class WebCreateLetterPage extends AbstractPage implements GmailCreateLetterPage {
    private static final Logger log = LogManager.getLogger(WebCreateLetterPage.class);

    @FindBy(xpath = "//*[@resource-id='composeto']")
    private WebElement recipientInput;
    @FindBy(xpath = "//*[@resource-id='cmcsubj']")
    private WebElement subjectInput;
    @FindBy(xpath = "//*[@resource-id='cmcbody']")
    private WebElement letterBodyInput;

    @FindBy(xpath = " (//*[@resource-id='cvtbt']//android.widget.Button)[2]")
    private WebElement sendLetter;


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
        sendLetter.click();
    }
}
