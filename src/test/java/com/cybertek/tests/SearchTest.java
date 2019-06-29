package com.cybertek.tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTest {
    public static void main(String[] args) throws InterruptedException{
        ebaySearch();
        amazonSearch();
        wikiSearch();
    }

    private static void ebaySearch()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.findElement(By.id("gh-ac")).sendKeys("wooden spoon");
        Thread.sleep(1500);
        driver.findElement(By.id("gh-btn")).click();
        Thread.sleep(1500);
        String actualResults = driver.findElement(By.className("srp-controls__count-heading")).getText();
        System.out.println(actualResults);
        driver.quit();
    }

    private static void amazonSearch()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon");
        Thread.sleep(1500);
        driver.findElement(By.className("nav-input")).click();
        Thread.sleep(1500);
        String actualResults = driver.findElement(By.className("sg-col-inner")).getText();
        System.out.println(actualResults);
        driver.quit();
    }

    private static void wikiSearch()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver");
        Thread.sleep(1500);
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(1500);
        driver.findElement(By.className("searchmatch")).click();
        Thread.sleep(1500);
        System.out.println(driver.getCurrentUrl().endsWith("Selenium_(software)"));
        driver.quit();
    }
}
