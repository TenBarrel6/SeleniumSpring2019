package com.cybertek.tests.xPathDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class XPathTests {
    WebDriver driver = null;
    @BeforeMethod
    public void SetUp() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/signup_confirmation");
        Thread.sleep(1000);

    }

    @Test
    public void absoluteXpath(){
        System.out.println("Printing the first link");
        System.out.println(driver.findElement(By.xpath("/html/body/nav/ul/li/a")).getText());

        System.out.println("Print the second link");
        System.out.println(driver.findElement(By.xpath("/html/body/div/div/div/div/a/i")).getText());
    }

    @Test
    public void relativeXpathUsingParentChild(){
        System.out.println("Printing the first link");
        System.out.println(driver.findElement(By.xpath("//body/nav//a")).getText());
    }

    @Test
    public void relativeXpathUsingAtributeValue() throws InterruptedException{
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        System.out.println("click on button: don't click");
        driver.findElement(By.xpath("//button[@id='disappearing_button']")).click();
        Thread.sleep(1500);

        // ANY TAG WITH ATTRIBUTE VALUE COMBO
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@id='disappearing_button']")).click();
        Thread.sleep(1500);

        // CONTAINS CERTAIN STRING IN VALUE OF SOME ATTRIBUTE
        System.out.println(driver.findElement(By.xpath("//button[contains(@id, 'button_')]")).getText());
    }

    @Test
    public void relativeXpathUsingText() throws InterruptedException{
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        System.out.println("ExactText");
        System.out.println(driver.findElement(By.xpath("//button[.='Button 3']")).getText());
        System.out.println(driver.findElement(By.xpath("//*[.='Button 3']")).getText());

        System.out.println("Using PartialText");
        System.out.println(driver.findElement(By.xpath("//button[contains(text(), 'click')]")).getText());

    }

    @Test
    public void relativeXpathByIndex() throws InterruptedException{
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        System.out.println("NTH Child");
        System.out.println(driver.findElement(By.xpath("//button[2]")).getText());
        System.out.println(driver.findElement(By.xpath("//button[6]")).getText());
        driver.findElement(By.xpath("//button[6]")).click();
        System.out.println(driver.findElement(By.xpath("//body/div/div[2]/div/div/div/div/p")));

        System.out.println("");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
