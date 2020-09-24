package ui.pages.nativepages;

import com.google.inject.Inject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.AbstractPage;
import ui.pages.PasswordPage;
import utils.Wait;

public class NativePasswordPage extends AbstractPage implements PasswordPage {
    @Inject
    private WelcomeGmailPage welcomeGmailPage;
    @Inject
    private GoogleTermPage googleTermPage;

    @FindBy(xpath = "//*[@resource-id='profileIdentifier']")
    private WebElement profileIdentifier;
    @FindBy(className = "android.widget.EditText")
    private WebElement passwordInput;

    @FindBy(xpath = "(//android.widget.Button)[3]")
    private WebElement nextButton;

    @Override
    public void inputPasswordAndSubmit(String password) {
        Wait.forVisibilityOf(profileIdentifier);
        passwordInput.sendKeys(password);
        nextButton.click();
        googleTermPage.acceptGoogleTerms();
        welcomeGmailPage.openGmailMainPage();
    }
}
