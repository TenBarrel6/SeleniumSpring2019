package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class EuropaPlusTest {
    public static void main(String[] args) throws InterruptedException{
        europaMultiListsTest();
    }

    public static void europaMultiListsTest() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.europaplus.ru/");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        //decline subscription
        driver.findElement(By.id("onesignal-popover-cancel-button")).click();
        Thread.sleep(1500);
        //get to programs > BrigadaU
        WebElement programs = driver.findElement(By.id("nav")); //gets element of menu bar
        programs.findElement(By.cssSelector("#nav > li:nth-child(1) > a")).click();//selecting programs
        Thread.sleep(1500);
        //selecting BrigadaU which opens new tab
        programs.findElement(By.cssSelector("#nav > li:nth-child(1) > div > ul > li:nth-child(1) > div > a")).click();
        Thread.sleep(1500);
        //coming back to previous tab and close it
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));
        Thread.sleep(1500);
        //gets element of menu tab
        WebElement utroMenuTab = driver.findElement(By.cssSelector("body > header > div.header__main > ul"));
        //selecting OnAir
        utroMenuTab.findElement(By.cssSelector("body > header > div.header__main > ul > li:nth-child(2) > a")).click();
        Thread.sleep(1500);
        //selecting Horoscopes
        utroMenuTab.findElement(By.cssSelector("body > header > div.header__main > ul " +
                "> li:nth-child(2) > ul > li:nth-child(2) > a")).click();
        Thread.sleep(1500);
        //clicks horoscope for youre choise
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("window.scrollBy(0,1450)", "");
        Thread.sleep(1500);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("" +
                "/html/body/section/div[3]/div/div/div/div/div/div/ul/li[10]"))).clickAndHold().perform();
        Thread.sleep(8500);

        //quit the browser
        driver.quit();
    }
}
