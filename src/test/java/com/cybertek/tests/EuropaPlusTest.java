package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

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
        //clicks horoscope for twins
        WebElement horoscopeList = driver.findElement(By.cssSelector("#content > div > ul"));
        horoscopeList.click();
        horoscopeList.findElement(By.cssSelector("#content > div > ul > li:nth-child(3) > div")).click();
        Thread.sleep(8500);

//        try {
//            horoscopeList.findElement(By.cssSelector("#content > div > ul > li:nth-child(3) > div")).click();
//            Thread.sleep(8500);
//        }catch (Exception e){
//            e.printStackTrace();
//            System.out.println("Exception catched");
//            driver.quit();
//        }


        //quit the browser
        driver.quit();
    }
}
