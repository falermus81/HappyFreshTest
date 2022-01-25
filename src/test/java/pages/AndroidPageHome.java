package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class AndroidPageHome extends AndroidPageBase {
    public By buttonWhileUsingTheApp = By.id("permission_allow_foreground_only_button");

    public AndroidPageHome(AndroidDriver<AndroidElement> androidDriver) {
        super(androidDriver);
    }
}
