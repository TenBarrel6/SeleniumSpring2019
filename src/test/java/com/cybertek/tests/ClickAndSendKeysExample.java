package com.cybertek.tests;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickAndSendKeysExample {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        Thread.sleep(1000);
        driver.findElement(By.name("email")).sendKeys("asdf@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.id("form_submit")).click();
        Thread.sleep(1000);
        VerificationUtils.verifyEquals(driver.getCurrentUrl(), "http://practice.cybertekschool.com/email_sent");
    }
}
