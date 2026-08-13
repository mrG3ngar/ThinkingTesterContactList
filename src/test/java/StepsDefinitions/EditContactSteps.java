package StepsDefinitions;

import io.cucumber.java.en.*;
import org.example.ContactListPage;
import org.example.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditContactSteps {

    WebDriver driver = null;
    private ElementUtils utils;

    @Given("user access the site and login")
    public void user_access_the_site_and_login(){
        System.out.println("Test Initialization: Accessing Browser > Signing In");

        String projectPath = System.getProperty("user.dir");
        System.out.println("Project Path: " + projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver-win64/chromedriver.exe");

        //Opening Browser
        driver = DriverFactory.createDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        //Logging In
        driver.navigate().to("https://thinking-tester-contact-list.herokuapp.com");
        driver.findElement(By.id("email")).sendKeys("test@herokuapp.com");
        driver.findElement(By.id("password")).sendKeys("1234567");
        driver.findElement(By.id("submit")).click();
    }
    @And("user navigates to Contact List page")
    public void user_navigates_to_contact_list_page() {
        System.out.println("Inside Step: user was navigated to Contact list page");

        // 1. Create a wait that will timeout after 10 seconds
        utils = new ElementUtils(driver);
        // 2. Wait UNTIL the specific element is visible on the page
        boolean isUrlMatched = utils.waitForUrl("https://thinking-tester-contact-list.herokuapp.com/contactList");
        // 3. Assert it is displayed (Optional, but good practice for readability)
        Assert.assertTrue(isUrlMatched);
    }
    @And("^click on a cell with (.*)$")
    public void clickOnACellOfASpecificName(String fullname) {
        System.out.println("Inside Step: click on a cell with "+fullname+" name");

        ContactListPage contactListPage = new ContactListPage(driver);
        // The 'name' variable (e.g., "John01 Doelast01") is passed dynamically
        boolean visible = contactListPage.isContactVisible(fullname);
        Assert.assertTrue("Expected contact to be visible in list: " + fullname, visible);

        contactListPage.clickContact(fullname);
    }
    @Then("user was navigated to Contact Details page")
    public void user_was_navigated_to_contact_details_page() {
        System.out.println("Inside Step: user was navigated to Contact Details page");

        // Wait UNTIL the specific element is visible on the page
        boolean isUrlMatched = utils.waitForUrl("https://thinking-tester-contact-list.herokuapp.com/contactDetails");
        // Assert it is displayed (Optional, but good practice for readability)
        Assert.assertTrue(isUrlMatched);
    }
    @And("user click Edit Contact button")
    public void user_click_edit_contact_button() {
        System.out.println("Inside Step: user click Edit Contact button");

        driver.findElement(By.id("edit-contact")).click();
    }
    @Then("user was navigated to Edit Contact page")
    public void user_was_navigated_to_edit_contact_page() {
        System.out.println("Inside Step: user was navigated to Edit Contact page");

        // Wait UNTIL the specific element is visible on the page
        boolean isUrlMatched = utils.waitForUrl("https://thinking-tester-contact-list.herokuapp.com/editContact");
        // Assert it is displayed (Optional, but good practice for readability)
        Assert.assertTrue(isUrlMatched);
    }
    @And("user updated first name")
    public void user_updated_first_name() throws InterruptedException {
        System.out.println("Inside Step: user updated first name");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstNameField = driver.findElement(By.id("firstName"));

        // 1. CRITICAL: Wait until existing data finishes populating from the API
        wait.until(d -> {
            String lastNameVal = d.findElement(By.id("lastName")).getDomProperty("value");
            return lastNameVal != null && !lastNameVal.trim().isEmpty();
        });

        // 2. Locate the firstName field once the form is populated
        firstNameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("firstName")));

        // 3. Highlight all text, delete, and type new value
        firstNameField.click();
        firstNameField.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
        firstNameField.sendKeys("test999");

        // 4. Tab out to trigger blur/change event so React saves the state
        firstNameField.sendKeys(Keys.TAB);

        /**
        // Select all and clear
        firstNameField.click();
        firstNameField.sendKeys(Keys.CONTROL + "a");
        firstNameField.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(3000);

        // Wait until empty
        wait.until(d -> firstNameField.getDomProperty("value").isEmpty());

        // Type new value AND send TAB to fire blur/change event
        firstNameField.sendKeys("test333" + Keys.TAB);
        Thread.sleep(3000);

         **/


    }
    @And("user clicks edit-submit button")
    public void user_clicks_edit_submit_button() {
        System.out.println("Inside Step: user clicks edit-submit button");

        driver.findElement(By.id("submit")).click();
    }
    @And("user was navigated back to Contact Details page")
    public void user_was_navigated_back_to_contact_details_page() {
        System.out.println("Inside Step: user was navigated back to Contact Details page");

        // Wait UNTIL the specific element is visible on the page
        boolean isUrlMatched = utils.waitForUrl("https://thinking-tester-contact-list.herokuapp.com/contactDetails");
        // Assert it is displayed (Optional, but good practice for readability)
        Assert.assertTrue(isUrlMatched);

        driver.quit();
    }


}
