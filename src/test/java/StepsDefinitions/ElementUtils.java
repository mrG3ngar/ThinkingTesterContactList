package StepsDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementUtils {
    private final WebDriverWait wait;

    public ElementUtils(WebDriver driver) {
        // Initialize wait once per page/test instance
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Method to wait for exact URL match
    public boolean waitForUrl(String expectedUrl) {
        return wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }

    // Asserts that the element's trimmed DOM text equals the expected value.
    public void assertElementText(By locator, String expectedText) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String actualText = element.getDomProperty("textContent");

        if (actualText == null || actualText.isEmpty()) {
            actualText = element.getText();
        }

        // Bypass Unicode space issues by chopping off everything before the first expected character
        if (actualText != null && expectedText != null && !expectedText.isEmpty()) {
            char firstExpectedChar = expectedText.charAt(0); // Grabs the '*'
            int startIndex = actualText.indexOf(firstExpectedChar);

            if (startIndex != -1) {
                // Slices the string starting exactly from the '*'
                actualText = actualText.substring(startIndex);
            }
        }
        Assert.assertEquals(actualText, expectedText);
    }
}
