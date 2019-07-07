package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownDefaultValuesTest {
    WebDriver driver = null;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void dropdown1Test(){
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        String expected = "Please select an option";
        String actual = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void dropdown2Test(){

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
