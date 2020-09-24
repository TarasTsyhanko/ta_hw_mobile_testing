package ua.com.epam;

import asserter.LetterAsserter;
import com.google.inject.Inject;
import config.Properties;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.actions.SendLetterAction;
import utils.FileReader;
import utils.Letter;

public class SendLetterTest extends BaseTest {
    @Inject
    private SendLetterAction sendLetterAction;
    @Inject
    private LetterAsserter letterAsserter;

    @Description("log in to gmail and send letter")
    @Test()
    public void sentLetterTestCase() {
        sendLetterAction.openLoginForm();
        sendLetterAction.logInToAccountGmail(Properties.getLogin(), Properties.getPassword());

        Letter letter = FileReader.getLetter();
        sendLetterAction.createAndSendLetter(letter);

        Assert.assertTrue(sendLetterAction.isInformInformMessageDisplayed());

        sendLetterAction.openSentLetterList();
        sendLetterAction.openLastSentLetter();
        letterAsserter.assertLetterTextBody(letter.getTextBody(), sendLetterAction.getLetterTextBody());
    }
}
