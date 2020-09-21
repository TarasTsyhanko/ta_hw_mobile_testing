package ui.pages.mobile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.AbstractPage;

public class SettingGmailPage extends AbstractPage {
    @FindBy(xpath = "(//android.widget.LinearLayout)[10]")
    private WebElement useGoogleAccount;

    public void goToGoogleAccountLoginForm() {
        useGoogleAccount.click();
    }
}
