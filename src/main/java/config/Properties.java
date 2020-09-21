package config;

public class Properties {
    public static String getAppiumServer() {
        return PropertyFile.getProperty("appium.server");
    }

    public static String getAndroidVersion() {
        return PropertyFile.getProperty("android.version");
    }

    public static String getDeviseName() {
        return PropertyFile.getProperty("devise.name");
    }

    public static String getLogin() {
        return PropertyFile.getProperty("google.account.login");
    }

    public static String getPassword() {
        return PropertyFile.getProperty("google.account.password");
    }

    public static String getLetterFilePath() {
        return PropertyFile.getProperty("letter.file.path");
    }

    public static String getAppPackage() {
        if ("mobile".equals(System.getProperty("strategy"))) {
            return PropertyFile.getProperty("gmail.app.package");
        }
        return PropertyFile.getProperty("chrome.app.package");
    }

    public static String getAppActivity() {
        if ("mobile".equals(System.getProperty("strategy"))) {
            return PropertyFile.getProperty("gmail.app.activity");
        }
        return PropertyFile.getProperty("chrome.app.activity");
    }

}
