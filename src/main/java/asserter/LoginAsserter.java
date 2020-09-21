package asserter;

import org.testng.Assert;

public class LoginAsserter {

    public void assertUserLogInToAccount(String expected, String actual) {
        Assert.assertEquals(actual, expected
                , String.format("Expected user [%s], but actual is [%s]", expected, actual));
    }
}
