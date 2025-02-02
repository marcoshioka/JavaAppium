package com.example.appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;

public class LoginAndFormTest {
    private static AndroidDriver driver;

    @BeforeEach
    public void restartSession() throws Exception {
        driver.quit(); // Close Appium session
        setup(); // Reinitialize driver (Call your @BeforeAll method)
    }

    @BeforeAll
    public static void setup() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        caps.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/apks/app-debug.apk");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        // Initialize the driver with Appium 2.x server URL
        driver = new AndroidDriver(new URL("http://localhost:4723/"), caps); // Using DesiredCapabilities
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testLogin() {
        driver.findElement(By.id("com.example.loginformapptest:id/etUsername")).sendKeys("admin");
        driver.findElement(By.id("com.example.loginformapptest:id/etPassword")).sendKeys("1234");
        driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.example.loginformapptest:id/btnLogin']"))
                .click();

        String name = driver.findElement(By.id("com.example.loginformapptest:id/etName")).getText();
        Assertions.assertEquals("Name", name);
    }

    @Test
    public void testFormSubmission() {

        this.testLogin();

        // Fill in the form fields
        driver.findElement(By.id("com.example.loginformapptest:id/etName")).sendKeys("John Doe");
        driver.findElement(By.id("com.example.loginformapptest:id/etEmail")).sendKeys("john.doe@example.com");
        driver.findElement(By.id("com.example.loginformapptest:id/etPhone")).sendKeys("1234567890");
        driver.findElement(By.id("com.example.loginformapptest:id/etAddress")).sendKeys("123 Test Street");
        driver.findElement(By.id("com.example.loginformapptest:id/etDateOfBirth")).sendKeys("01/01/1990");

        // Click submit button
        driver.findElement(By.id("com.example.loginformapptest:id/btnSubmit")).click();

        // Validate the success message
        String successMessage = driver
                .findElement(By.xpath("//android.widget.TextView[@text='Thank you for submitting the form!']"))
                .getText();
        Assertions.assertEquals("Thank you for submitting the form!", successMessage);
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
