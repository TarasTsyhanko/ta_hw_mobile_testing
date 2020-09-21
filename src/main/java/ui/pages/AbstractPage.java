package ui.pages;

import factory.DriverContainer;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {

    public AbstractPage() {
        PageFactory.initElements(DriverContainer.getDriver(), this);
    }
}
