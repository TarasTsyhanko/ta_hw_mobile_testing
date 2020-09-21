package injection;

import com.google.inject.AbstractModule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ui.pages.*;
import ui.pages.desktop.*;
import ui.pages.mobile.*;

public class PageModule extends AbstractModule {
    private static final Logger log = LogManager.getLogger(PageModule.class);

    @Override
    protected void configure() {
        log.warn("---------USING " + System.getProperty("strategy") + " STRATEGY---------");
        if ("mobile".equals(System.getProperty("strategy"))) {
            bind(AppWelcomePage.class).to(WelcomeGmailPage.class);
            bind(GmailMainPage.class).to(MobileMainPage.class);
            bind(LoginPage.class).to(MobileLoginPage.class);
            bind(PasswordPage.class).to(MobilePasswordPage.class);
            bind(GmailCreateLetterPage.class).to(MobileCreateLetterPage.class);
            bind(GmailSentLettersPage.class).to(MobileSentLettersPage.class);
            bind(GmailLetterPage.class).to(MobileLetterPage.class);
        } else {
            bind(AppWelcomePage.class).to(ChromeWelcomePage.class);
            bind(GmailMainPage.class).to(DesktopBasePage.class);
            bind(LoginPage.class).to(DesktopLoginPage.class);
            bind(PasswordPage.class).to(DesktopPasswordPage.class);
            bind(GmailCreateLetterPage.class).to(DesktopCreateLetterPage.class);
            bind(GmailSentLettersPage.class).to(DesktopSentLetterPage.class);
            bind(GmailLetterPage.class).to(DesktopLetterPage.class);
        }
    }
}
