package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    public static WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();

        // 1. Create HashMap for Chrome preferences
        Map<String, Object> prefs = new HashMap<>();

        // Disable "Save password" prompts
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        // Disable "Save contact / address" and autofill prompts
        prefs.put("autofill.profile_enabled", false);
        prefs.put("autofill.credit_card_enabled", false);

        // Apply preferences to ChromeOptions
        options.setExperimentalOption("prefs", prefs);

        // 2. Add Chrome arguments to disable popup bubbles & notifications
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-autofill");

        // 1. Force Chrome UI and system theme to Dark Mode
        options.addArguments("--force-dark-mode");

        return new ChromeDriver(options);
    }
}
