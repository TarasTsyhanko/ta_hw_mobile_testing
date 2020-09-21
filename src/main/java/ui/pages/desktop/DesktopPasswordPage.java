package ui.pages.desktop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.AbstractPage;
import utils.Wait;

public class DesktopPasswordPage extends AbstractPage implements ui.pages.PasswordPage {

    @FindBy(xpath = "//*[@resource-id='profileIdentifier']")
    private WebElement profileIdentifier;

    @FindBy(className = "android.widget.EditText")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@text='Далі']")
    private WebElement nextButton;

    @Override
    public void inputPasswordAndSubmit(String password) {
        Wait.forVisibilityOf(profileIdentifier);
        Wait.forScrollToElementByText("Далі");
        passwordInput.sendKeys(password);
        nextButton.click();
    }
}
