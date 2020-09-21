package ui.actions;

import com.google.inject.Inject;
import io.qameta.allure.Step;
import ui.pages.*;
import utils.Letter;

public class SendLetterAction {

    @Inject
    private AppWelcomePage welcomePage;
    @Inject
    private GmailMainPage mainPage;
    @Inject
    private LoginPage loginPage;
    @Inject
    private PasswordPage passwordPage;
    @Inject
    private GmailCreateLetterPage createLetterPage;
    @Inject
    private GmailSentLettersPage sentLettersPage;
    @Inject
    private GmailLetterPage letterPage;


    @Step("open google account login form")
    public void openLoginForm() {
        welcomePage.openGoogleLoginPage();
    }

    @Step("log in to google [{0},{1}]")
    public void logInToAccountGmail(String login, String password) {
        loginPage.inputLoginAndSubmit(login);
        passwordPage.inputPasswordAndSubmit(password);
    }

    @Step("create letter [{0}], and send it]")
    public void createAndSendLetter(Letter letter) {
        mainPage.openCreateLetterPage();
        createLetterPage.inputRecipientLetter(letter.getRecipient());
        createLetterPage.inputSubjectLetter(letter.getSubject());
        createLetterPage.inputTextBodyLetter(letter.getTextBody());
        createLetterPage.sendLetter();
    }

    @Step("verify is inform message about sending letter displayed")
    public boolean isInformInformMessageDisplayed() {
        return mainPage.isInformMessageDisplayed();
    }

    @Step("open sent letters list")
    public void openSentLetterList() {
        mainPage.openSentLetterList();
    }

    @Step("open last sent letter")
    public void openLastSentLetter() {
        sentLettersPage.openLastSentLetter();
    }

    @Step("get letter text")
    public String getLetterTextBody() {
        return letterPage.getLetterBodyText();
    }
}
