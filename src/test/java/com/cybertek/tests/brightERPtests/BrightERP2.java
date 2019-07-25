package com.cybertek.tests.brightERPtests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrightERP2 {
    WebDriver driver;
    @BeforeMethod
    public void SetUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String log = "eventscrmmanager57@info.com";
        String pass = "eventscrmmanager";
        driver.get("http://54.148.96.210/");
        driver.findElement(By.xpath("/html/body/div/header/div/div/div[2]/ul/li[10]/a")).click();
        driver.findElement(By.id("login")).sendKeys(log);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.xpath("/html/body/div/main/div/form/div[3]/button")).click();
    }

    @AfterMethod
    public void tearDown(){ driver.quit(); }

    @Test(priority = 1)
    public void testCRM() throws InterruptedException {
        /**
         * As a user, when I already created an opportunity in
         * CRM module of Bribe ERP application, I want to be able to delete it.
         * Acceptance Criteria :
         * 1.
         * Verify that user should be able to see the list view.
         * 2.
         * Verify that user should be able to delete the opportunity from action drop down list .
         */
        driver.findElement(By.xpath("//a[@data-menu='261']")).click();
        driver.findElement(By.xpath("//button[@accesskey=\"l\"]")).click();
        Thread.sleep(3000);
        List<WebElement> chekBoxs = driver.findElements(By.xpath("//input[@type='checkbox']"));
        chekBoxs.get(3).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div[2]/div/div[2]/button")).click();
        driver.findElement(By.xpath("//a[@data-index=\"3\"]")).click();
        driver.findElement(By.xpath("//span[text()='Ok']")).click();
    }
    @Test(priority = 0)
    public void testCreateOppo() {
        /**
         * Create opportunity for crm list
         */
        driver.findElement(By.xpath("//a[@data-menu='261']")).click();
        driver.findElement(By.xpath("//button[@accesskey=\"c\"]")).click();
        driver.findElement(By.xpath("//input[@placeholder=\"e.g. Customer Deal\"]"))
                .sendKeys(Faker.instance().name().fullName());
        driver.findElement(By.xpath("//button[@name=\"close_dialog\"]")).click();
    }
}
