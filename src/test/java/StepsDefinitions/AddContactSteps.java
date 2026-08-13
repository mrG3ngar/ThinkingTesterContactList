package StepsDefinitions;

import io.cucumber.java.en.*;
import org.example.ContactListPage;
import org.example.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class AddContactSteps {

    WebDriver driver = null;
    private ElementUtils utils;

    @Given("user is on the browser")
    public void user_is_on_the_browser() {
        System.out.println("Inside Step: user is on the browser");

        String projectPath = System.getProperty("user.dir");
        System.out.println("Project Path: " + projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver-win64/chromedriver.exe");

        driver = DriverFactory.createDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }
    @And("user is logged in")
    public void user_is_logged_in() throws InterruptedException {
        System.out.println("Inside Step: user is logged in");

        driver.navigate().to("https://thinking-tester-contact-list.herokuapp.com");
        Thread.sleep(3000);
        driver.findElement(By.id("email")).sendKeys("test@herokuapp.com");
        driver.findElement(By.id("password")).sendKeys("1234567");
        driver.findElement(By.id("submit")).click();
    }
    @And("user is on Contact List page")
    public void user_is_on_contact_list_page() {
        System.out.println("Inside Step: user is on Contact List page");

        // 1. Create a wait that will timeout after 10 seconds
        utils = new ElementUtils(driver);
        // 2. Wait UNTIL the specific element is visible on the page
        boolean isUrlMatched = utils.waitForUrl("https://thinking-tester-contact-list.herokuapp.com/contactList");
        // 3. Assert it is displayed (Optional, but good practice for readability)
        Assert.assertTrue(isUrlMatched);
    }
    @And("user clicks Add a New Contact button")
    public void user_clicks_add_a_new_contact_button() {
        System.out.println("Inside Step: user clicks Add a New Contact button");

        driver.findElement(By.id("add-contact")).click();
    }
    @Then("user was navigated to Add Contact page")
    public void user_was_navigated_to_add_contact_page() {
        System.out.println("Inside Step: user was navigated to Add Contact page");

        // 1. Create a wait that will timeout after 10 seconds
        utils = new ElementUtils(driver);
        // 2. Wait UNTIL the specific element is visible on the page
        boolean isUrlMatched = utils.waitForUrl("https://thinking-tester-contact-list.herokuapp.com/addContact");
        // 3. Assert it is displayed (Optional, but good practice for readability)
        Assert.assertTrue(isUrlMatched);
    }
    @And("^user input (.*) on firstname text field$")
    public void userInputFirstname(String firstname) {
        System.out.println("Inside Step: user input firstname");

        // Explicitly wait for the element to be visible and check if it has correct label
        utils.assertElementText(By.cssSelector("label[for='firstName']"), "* First Name:");
        // Input data
        driver.findElement(By.id("firstName")).sendKeys(firstname);
    }
    @And("^user input (.*) on lastname text field$")
    public void userInputLastname(String lastname) {
        System.out.println("Inside Step: user input lastname");

        // Explicitly wait for the element to be visible and check if it has correct label
        utils.assertElementText(By.cssSelector("label[for='lastName']"), "* Last Name:");

        driver.findElement(By.id("lastName")).sendKeys(lastname);
    }
    @And("^user input (.*) on dateofbirth textfield$")
    public void userInputDateOfBirth(String dateofbirth) {
        System.out.println("Inside Step: user input dateofbirth");

        // Explicitly wait for the element to be visible and check if it has correct label
        utils.assertElementText(By.cssSelector("label[for='birthdate']"), " Date of Birth:");

        driver.findElement(By.id("birthdate")).sendKeys(dateofbirth);
    }
    @And("^user input (.*) on email textfield$")
    public void userInputEmail(String email) {
        System.out.println("Inside Step: user input email");

        // Explicitly wait for the element to be visible and check if it has correct label
        utils.assertElementText(By.cssSelector("label[for='email']"), " Email:");

        driver.findElement(By.id("email")).sendKeys(email);
    }
    @And("^user input (.*) on phone text field$")
    public void userInputPhone(String phone) {
        System.out.println("Inside Step: user input phonenumber");

        // Explicitly wait for the element to be visible and check if it has correct label
        utils.assertElementText(By.cssSelector("label[for='phone']"), " Phone:");

        driver.findElement(By.id("phone")).sendKeys(phone);
    }
    @And("^user input (.*) on street1 text field$")
    public void userInputStreetAddress1(String streetaddress1) {
        System.out.println("Inside Step: user input streetaddress1");

        // Explicitly wait for the element to be visible and check if it has correct label
        utils.assertElementText(By.cssSelector("label[for='street1']"), " Street Address 1:");

        driver.findElement(By.id("street1")).sendKeys(streetaddress1);
    }
    @And("^user input (.*) on street2 text field$")
    public void userInputStreetAddress2(String streetaddress2) {
        System.out.println("Inside Step: user input streetaddress2");

        // Explicitly wait for the element to be visible and check if it has correct label
        utils.assertElementText(By.cssSelector("label[for='street2']"), " Street Address 2:");

        driver.findElement(By.id("street2")).sendKeys(streetaddress2);
    }
    @And("^user input (.*) on city textfield$")
    public void userInputCity(String city) {
        System.out.println("Inside Step: user input city");

        // Explicitly wait for the element to be visible and check if it has correct label
        utils.assertElementText(By.cssSelector("label[for='city']"), " City:");

        driver.findElement(By.id("city")).sendKeys(city);
    }
    @And("^user input (.*) on stateProvince textfield$")
    public void userInputStateOrProvince(String stateOrprovince) {
        System.out.println("Inside Step: user input stateOrProvince");

        // Explicitly wait for the element to be visible and check if it has correct label
        utils.assertElementText(By.cssSelector("label[for='stateProvince']"), " State or Province:");

        driver.findElement(By.id("stateProvince")).sendKeys(stateOrprovince);
    }
    @And("^user input (.*) on postalCode textfield$")
    public void userInputPostalCode(String postalCode) {
        System.out.println("Inside Step: user input postalcode");

        // Explicitly wait for the element to be visible and check if it has correct label
        utils.assertElementText(By.cssSelector("label[for='postalCode']"), " Postal Code:");

        driver.findElement(By.id("postalCode")).sendKeys(postalCode);
    }
    @And("^user input (.*) on Country textfield$")
    public void userInputCountry(String country) {
        System.out.println("Inside Step: user input country");

        // Explicitly wait for the element to be visible and check if it has correct label
        utils.assertElementText(By.cssSelector("label[for='country']"), " Country:");

        driver.findElement(By.id("country")).sendKeys(country);
    }
    @Then("user was navigated to Contact List page after submit")
    public void userWasNavigatedToContactListPageAfterSubmit(){
        System.out.println("Inside Step: user was navigated to Contact List page after submit");

        driver.findElement(By.id("submit")).click();
        // 1. Create a wait that will timeout after 10 seconds
        utils = new ElementUtils(driver);
        // 2. Wait UNTIL the specific element is visible on the page
        boolean isUrlMatched = utils.waitForUrl("https://thinking-tester-contact-list.herokuapp.com/contactList");
        // 3. Assert it is displayed (Optional, but good practice for readability)
        Assert.assertTrue(isUrlMatched);
    }

    @Then("^added contact (.*) was added in contact list$")
    public void added_contact_was_added_in_contact_list(String name) {
        System.out.println("Inside Step: added contact was added in contact list");

        ContactListPage contactListPage = new ContactListPage(driver);
        boolean visible = contactListPage.isContactVisible(name);
        Assert.assertTrue("Expected contact to be visible in list: " + name, visible);

        driver.quit();
    }
}
