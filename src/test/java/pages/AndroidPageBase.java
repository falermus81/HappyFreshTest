package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AndroidPageBase {
    protected AndroidDriver<AndroidElement> androidDriver;
    private WebDriverWait webDriverWait;
    private AndroidElement androidElement;
    private Actions actions;

    public void waitForPresence(By by) {
        this.webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void waitForClickable(By by) {
        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void singleTap(By by) {
        try {
            this.waitForPresence(by);
            this.waitForClickable(by);
            List<AndroidElement> androidElements = this.androidDriver.findElements(by);
            if (androidElements.size() > 0) {
                for (AndroidElement androidElement: androidElements) {
                    // Find the first element of which the identifier is matched
                    this.androidElement = androidElement;
                    break;
                }
                //this.touchActions.singleTap(this.androidElement).perform();
            }
            this.actions.click(this.androidElement).perform();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void scrollDown() {
        try {
            int height = this.androidDriver.manage().window().getSize().height;
            int width = this.androidDriver.manage().window().getSize().width;
            //this.touchActions.scroll(0, height).perform();
            this.actions.clickAndHold().moveByOffset(0, height).perform();
            new TouchAction<>(this.androidDriver).press(new PointOption<>().withCoordinates(width, height)).moveTo(new PointOption<>().withCoordinates(width, 0)).perform();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void scrollUp() {
        try {
            int height = this.androidDriver.manage().window().getSize().height;
            //this.touchActions.scroll(0, -height).perform();
            this.actions.moveByOffset(0, -height).perform();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void scrollRight() {
        try {
            int width = this.androidDriver.manage().window().getSize().width;
            //this.touchActions.scroll(width, 0).perform();
            this.actions.moveByOffset(width, 0).perform();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void scrollLeft() {
        try {
            int width = this.androidDriver.manage().window().getSize().width;
            //this.touchActions.scroll(-width, 0).perform();
            this.actions.moveByOffset(-width, 0).perform();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public AndroidPageBase(AndroidDriver<AndroidElement> androidDriver) {
        this.androidDriver = androidDriver;
        this.actions = new Actions(this.androidDriver);
        long timeOut = 60;
        this.webDriverWait = new WebDriverWait(this.androidDriver, Duration.ofSeconds(timeOut));
        List<Map<String, Object>> sessionDetails = this.androidDriver.getAllSessionDetails();
        for (Map<String, Object> i: sessionDetails) {
            Set<String> keys = i.keySet();
            for (String j: keys) {
                System.out.println(j + ": " + i.get(j).toString());
            }
        }
    }
}
