package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class ReusableMethods extends BaseDriver {
    private static final Logger log = LoggerFactory.getLogger(ReusableMethods.class);
    public static void threadWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void myClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void mySendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    public void verifyContainsText(WebElement element, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        Assert.assertTrue(element.getText().toLowerCase().contains(text.toLowerCase()));
    }

    public String getElementText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
}
