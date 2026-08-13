package StepsDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddUserSteps {

    WebDriver driver = null;

    @Given("user is on browser")
    public void user_is_on_browser() {
        System.out.println("Inside Steps: user is on browser");

        String projectPath = System.getProperty("user.dir");
        System.out.println("Project Path: " + projectPath);
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver-win64/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }
    @And("user access thingking-tester-contact-list site")
    public void user_access_thingking_tester_contact_list_site() throws InterruptedException {
        System.out.println("Inside Steps: user access thingking-tester-contact-list site");


        driver.navigate().to("https://thinking-tester-contact-list.herokuapp.com");
        Thread.sleep(3000);
    }
    @And("user clicks sign up button")
    public void user_clicks_sign_up_button() {
        System.out.println("Inside Steps: user clicks sign up button");

        driver.findElement(By.id("signup")).click();

    }
    @Then("user was navigated to Add User page")
    public void user_was_navigated_to_add_user_page() {
        System.out.println("Inside Steps: user was navigated to Add User page");

        // 1. Create a wait that will timeout after 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // 2. Wait UNTIL the specific element is visible on the page
        Boolean successMessage = wait.until(
                ExpectedConditions.urlToBe("https://thinking-tester-contact-list.herokuapp.com/addUser")
        );
        // 3. Assert it is displayed (Optional, but good practice for readability)
        Assert.assertTrue(successMessage);

    }
    @Then("user was able to input data on form")
    public void user_was_able_to_input_data_on_form() {
        System.out.println("Inside Steps: user was able to input data on form");

        driver.findElement(By.id("firstName")).sendKeys("Johntest2");
        driver.findElement(By.id("lastName")).sendKeys("Doelast2");
        driver.findElement(By.id("email")).sendKeys("test9@herokuapp.com");
        driver.findElement(By.id("password")).sendKeys("test12345");

    }
    @And("user clicks submit button")
    public void user_clicks_submit_button() {
        System.out.println("Inside Steps: user clicks submit button");

        driver.findElement(By.id("submit")).click();
    }
    @Then("user was navigated to Contact List page")
    public void user_was_navigated_to_contact_list_page() {
        System.out.println("Inside Steps: user was navigated to Contact List page");

        // 1. Create a wait that will timeout after 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // 2. Wait UNTIL the specific element is visible on the page
        Boolean successMessage = wait.until(
                ExpectedConditions.urlToBe("https://thinking-tester-contact-list.herokuapp.com/contactList")
        );
        // 3. Assert it is displayed (Optional, but good practice for readability)
        Assert.assertTrue(successMessage);

        driver.quit();
    }


}
