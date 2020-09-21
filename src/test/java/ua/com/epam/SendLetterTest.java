package ua.com.epam;

import asserter.LetterAsserter;
import com.google.inject.Inject;
import config.Properties;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.actions.SendLetterAction;
import utils.FileReader;

import java.time.LocalTime;

public class SendLetterTest extends BaseTest {
    @Inject
    private SendLetterAction sendLetterAction;
    @Inject
    private LetterAsserter letterAsserter;

    @Description("log in to gmail and send letter")
    @Test
    public void sentLetterTestCase() {
        sendLetterAction.openLoginForm();
        sendLetterAction.logInToAccountGmail(Properties.getLogin(), Properties.getPassword());
        String textBody = LocalTime.now().toString();
        sendLetterAction.createAndSendLetter(FileReader.getLetter());

        Assert.assertTrue(sendLetterAction.isInformInformMessageDisplayed());

        sendLetterAction.openSentLetterList();
        sendLetterAction.openLastSentLetter();
        letterAsserter.assertLetterTextBody(textBody, sendLetterAction.getLetterTextBody());
    }
}
