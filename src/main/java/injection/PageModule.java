package injection;

import com.google.inject.AbstractModule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ui.pages.*;
import ui.pages.webpages.*;
import ui.pages.nativepages.*;

public class PageModule extends AbstractModule {
    private static final Logger log = LogManager.getLogger(PageModule.class);

    @Override
    protected void configure() {
        log.warn("---------USING " + System.getProperty("strategy") + " STRATEGY---------");
        if ("native".equals(System.getProperty("strategy"))) {
            bind(AppWelcomePage.class).to(WelcomeGmailPage.class);
            bind(GmailMainPage.class).to(NativeMainPage.class);
            bind(LoginPage.class).to(NativeLoginPage.class);
            bind(PasswordPage.class).to(NativePasswordPage.class);
            bind(GmailCreateLetterPage.class).to(NativeCreateLetterPage.class);
            bind(GmailSentLettersPage.class).to(NativeSentLettersPage.class);
            bind(GmailLetterPage.class).to(NativeLetterPage.class);
        } else {
            bind(AppWelcomePage.class).to(WebWelcomePage.class);
            bind(GmailMainPage.class).to(WebBasePage.class);
            bind(LoginPage.class).to(WebLoginPage.class);
            bind(PasswordPage.class).to(WebPasswordPage.class);
            bind(GmailCreateLetterPage.class).to(WebCreateLetterPage.class);
            bind(GmailSentLettersPage.class).to(WebSentLetterPage.class);
            bind(GmailLetterPage.class).to(WebLetterPage.class);
        }
    }
}
