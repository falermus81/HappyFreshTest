package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AndroidPageBase {
    private AndroidDriver<AndroidElement> androidDriver;
    private TouchActions touchActions;
    private WebDriverWait webDriverWait;
    private AndroidElement androidElement;

    public void singleTap(By by) {
        try {
            this.webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
            List<AndroidElement> androidElements = this.androidDriver.findElements(by);
            if (androidElements.size() > 0) {
                for (AndroidElement androidElement: androidElements) {
                    // Find the first element of which the identifier is matched
                    this.androidElement = androidElement;
                    if (this.androidElement.isEnabled()) {
                        break;
                    }
                }
                this.touchActions.singleTap(this.androidElement).perform();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void scrollDown() {
        try {
            int height = this.androidDriver.manage().window().getSize().height;
            this.touchActions.scroll(0, height).perform();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void scrollUp() {
        try {
            int height = this.androidDriver.manage().window().getSize().height;
            this.touchActions.scroll(0, -height).perform();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void scrollRight() {
        try {
            int width = this.androidDriver.manage().window().getSize().width;
            this.touchActions.scroll(width, 0).perform();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void scrollLeft() {
        try {
            int width = this.androidDriver.manage().window().getSize().width;
            this.touchActions.scroll(-width, 0).perform();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public AndroidPageBase(AndroidDriver<AndroidElement> androidDriver) {
        this.androidDriver = androidDriver;
        this.touchActions = new TouchActions(this.androidDriver);
        long timeOut = 30;
        this.webDriverWait = new WebDriverWait(this.androidDriver, timeOut);
    }
}
