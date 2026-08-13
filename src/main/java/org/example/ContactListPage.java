package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ContactListPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Dynamic locator for any table cell containing the contact name
    private By contactNameCell(String name) {
        return By.xpath("//table//td[contains(text(), '" + name + "')]");
    }

    public ContactListPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isContactVisible(String name) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(contactNameCell(name)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //Dynamic Locator Method Returns the 'By' locator for the exact Name cell based on the variable provided.
    private By dynamicContactNameLocator(String contactName) {
        // Injects the variable into the XPath
        return By.xpath("//table[@id='myTable']//tr[td[2][text()='" + contactName + "']]/td[2]");
    }

    //Action to click cell with specified name in the variable
    public void clickContact(String contactName) {
        WebElement contactCell = wait.until(ExpectedConditions.elementToBeClickable(dynamicContactNameLocator(contactName)));
        contactCell.click();
    }

}
