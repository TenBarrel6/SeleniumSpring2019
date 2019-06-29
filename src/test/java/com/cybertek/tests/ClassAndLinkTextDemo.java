package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassAndLinkTextDemo {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com");
        Thread.sleep(1000);
        driver.findElement(By.linkText("Dynamic Loading")).click();
        Thread.sleep(1000);

        driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
        Thread.sleep(1500);
        driver.quit();
    }
}
