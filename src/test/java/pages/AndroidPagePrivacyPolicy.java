package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class AndroidPagePrivacyPolicy extends AndroidPageBase {
    public By buttonAgree = By.id("ui_view_privacy_policy_button_agree");

    public void goToOnBoarding() {
        AndroidPagePool.androidPageOnBoarding = new AndroidPageOnBoarding(this.androidDriver);
    }

    public AndroidPagePrivacyPolicy(AndroidDriver<AndroidElement> androidDriver) {
        super(androidDriver);
    }
}
