package steps;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.AndroidPagePool;
import pages.AndroidPagePrivacyPolicy;

public class AndroidStepPrivacyPolicy {
    @Given("User opened the app")
    public void userOpenedTheApp() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        /*{
            "appium:automationName": "appium",
            "platformName": "Android",
            "appium:platformVersion": "11.0",
            "appium:deviceName": "emulator-5554",
            "appium:app": "/Users/styletheory/projects/HappyFreshTest/app/app-staging-debug.apk"
        }*/
        desiredCapabilities.setCapability("appium:automationName", "appium");
        desiredCapabilities.setCapability(  "platformName", "Android");
        desiredCapabilities.setCapability(  "appium:platformVersion", "11.0");
        desiredCapabilities.setCapability(  "appium:deviceName", "android emulator");
        desiredCapabilities.setCapability(  "appium:app", "/Users/styletheory/projects/HappyFreshTest/app/app-staging-debug.apk");
        desiredCapabilities.setCapability("fullReset", "true");
        AndroidDriver<AndroidElement> androidDriver = new AndroidDriver<>(desiredCapabilities);
        AndroidPagePool.androidPagePrivacyPolicy = new AndroidPagePrivacyPolicy(androidDriver);
        AndroidPagePool.androidPagePrivacyPolicy.scrollDown();
    }

    @And("User agreed to the policy")
    public void userAgreedToThePolicy() {
        AndroidPagePool.androidPagePrivacyPolicy.waitForClickable(AndroidPagePool.androidPagePrivacyPolicy.buttonAgree);
        AndroidPagePool.androidPagePrivacyPolicy.scrollDown();
        AndroidPagePool.androidPagePrivacyPolicy.singleTap(AndroidPagePool.androidPagePrivacyPolicy.buttonAgree);
        AndroidPagePool.androidPagePrivacyPolicy.goToOnBoarding();
    }
}
