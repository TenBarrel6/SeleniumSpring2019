package com.cybertek.tests;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnterExample {
    public static void main(String[] args) throws InterruptedException {
        // open browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //open web-page
        driver.get("http://practice.cybertekschool.com/forgot_password");
        Thread.sleep(1000);
        //looking for inputBox element
        //enters text there and hits ENTER button
        driver.findElement(By.name("email")).sendKeys("asdf@gmail.com"+ Keys.ENTER);
        Thread.sleep(1000);
        VerificationUtils.verifyEquals(driver.getCurrentUrl(), "http://practice.cybertekschool.com/email_sent");
    }
}
