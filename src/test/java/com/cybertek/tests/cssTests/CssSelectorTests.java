package com.cybertek.tests.cssTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CssSelectorTests {
    WebDriver driver = null;
    @BeforeMethod
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void test1() throws InterruptedException{
        System.out.println("Test 1");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(1500);
        // certain element with attribute and value combo
        System.out.println(driver.findElement(By.cssSelector("button[name='button6']")).getText());
        // any element with attr and value combo
        System.out.println(driver.findElement(By.cssSelector("[name='button6']")).getText());
        // multiple attribute and value
        System.out.println(driver.findElement(By.cssSelector("button[class='btn btn-primary'][name='button2']")).getText());
    }

    @Test
    public void test2() throws InterruptedException{
        System.out.println("Test 2 dynamic elements");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(1500);
        // starts with
        System.out.println(driver.findElement(By.cssSelector("button[id^='button_']")).getText());

        // ends with
        System.out.println(driver.findElement(By.cssSelector("button[id$='_button']")).getText());

        //contains
        System.out.println(driver.findElement(By.cssSelector("button[id*='disappear']")).getText());
    }

    @Test
    public void test3() throws InterruptedException{
        System.out.println("Test 3 Id & Class");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(1500);
        // ID
        System.out.println(driver.findElement(By.cssSelector("#disappearing_button")).getText());
        // ONE CLASS
        System.out.println(driver.findElement(By.cssSelector(".nav-link")).getText());
        // two classes
        System.out.println(driver.findElement(By.cssSelector("btn.btn-primary")).getText());
        // CERTAIN ELEMENT WITH CLASS
        System.out.println(driver.findElement(By.cssSelector("a.nav-link")).getText());

    }

    @AfterMethod
    public void rollDown(){
        driver.quit();
    }
}
