package com.cybertek.tests.verificationUtils;

import com.cybertek.utilities.VerificationUtils;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextVerification {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        Thread.sleep(1000);
        //looking for inputBox element
        //enters text there and hits ENTER button
        System.out.println(driver.findElement(By.name("email")).getAttribute("outerHTML"));
        driver.findElement(By.name("email")).sendKeys(Faker.instance().internet().emailAddress() + Keys.ENTER);
        Thread.sleep(1000);
        VerificationUtils.verifyEquals(driver.findElement(By.name("confirmation_message")).getText(), "Your e-mail's been sent!");

        //Your e-mail's been sent! name confirmation_message

    }
}
