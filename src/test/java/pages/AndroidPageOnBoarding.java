package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class AndroidPageOnBoarding extends AndroidPageBase {
    public By buttonNext = By.id("ui_view_next_on_boarding_button");
    public By buttonLetsGo = By.id("ui_view_letsgo_on_boarding_button");

    public void goToHome(AndroidPageHome androidPageHome) {
        androidPageHome = new AndroidPageHome(this.androidDriver);
    }

    public AndroidPageOnBoarding(AndroidDriver<AndroidElement> androidDriver) {
        super(androidDriver);
    }
}
