package asserter;

import org.testng.Assert;

public class LetterAsserter {

    public void assertLetterTextBody(String expected, String actual) {
        Assert.assertEquals(actual, expected
                , String.format("Expected textBody [%s], but actual is [%s]", expected, actual));
    }
}
