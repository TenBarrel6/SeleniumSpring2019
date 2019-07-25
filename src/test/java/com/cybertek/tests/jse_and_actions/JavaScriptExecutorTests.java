package com.cybertek.tests.jse_and_actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorTests {

    WebDriver driver;
    JavascriptExecutor jse;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        jse = (JavascriptExecutor) driver;
    }

//    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void jse1(){
        driver.get("http://practice.cybertekschool.com");
        //jse will execute the command we passing in string
        jse.executeScript("alert('Welcome to MortalKombat');");
    }

    @Test
    public void scroll() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        Thread.sleep(2000);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(1000);

    }

    @Test
    public void scrollToElement() {
        driver.get("http://practice.cybertekschool.com/large");
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        // executeScript is overloaded method and can take string and WebElement params
        jse.executeScript("arguments[0].scrollIntoView(true)", link);

    }

    @Test
    public void click() {
        driver.get("http://practice.cybertekschool.com/large");
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        // executeScript is overloaded method and can take string and WebElement params
        jse.executeScript("arguments[0].click()", link);

    }

    @Test
    public void type() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        Thread.sleep(2000);
        WebElement input = driver.findElement(By.cssSelector("#input-example>input"));
        // executeScript is overloaded method and can take string and WebElement params
        jse.executeScript("arguments[0].setAttribute('value', 'MortalKombat')", input);

    }
}
