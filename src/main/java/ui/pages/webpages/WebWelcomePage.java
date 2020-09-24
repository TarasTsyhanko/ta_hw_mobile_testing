package ui.pages.webpages;

import factory.DriverContainer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.AbstractPage;
import ui.pages.AppWelcomePage;
import utils.Wait;

import static constant.Constants.GMAIL_URL;

public class WebWelcomePage extends AbstractPage implements AppWelcomePage {

    @FindBy(id = "terms_accept")
    private WebElement acceptButton;

    @FindBy(id = "negative_button")
    private WebElement addNewAccountButton;

    @FindBy(id = "search_provider_logo")
    private WebElement searchLogo;


    @Override
    public void openGoogleLoginPage() {
        acceptButton.click();
        addNewAccountButton.click();
        Wait.forVisibilityOf(searchLogo);
        DriverContainer.getDriver().get(GMAIL_URL);
    }
}
