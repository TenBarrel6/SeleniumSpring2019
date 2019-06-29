package com.cybertek.tests;

import com.cybertek.utilities.StringUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VyTrackLoginTest {
    public static void main(String[] args) throws InterruptedException {
        loginVyTrack();
        logoutVyTrack();
    }

    public static void logoutVyTrack() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String userName = "storemanager94";
        String login = "UserUser123";
        String expectedUrl = "http://qa3.vytrack.com/user/login";
        String expectedTitle = "Login";
        driver.get("http://qa3.vytrack.com/user/login");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.id("prependedInput")).sendKeys(userName + Keys.TAB + login);
        Thread.sleep(1000);
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='user-menu']//*[@class='fa-caret-down']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='last']//*[@class='no-hash']")).click();
        Thread.sleep(1000);
        System.out.println("URL check:");
        StringUtility.verifyEquals(driver.getCurrentUrl(), expectedUrl);
        System.out.println();
        System.out.println("Title check:");
        StringUtility.verifyEquals(driver.getTitle(), expectedTitle);
        driver.quit();
//        driver.findElement(By.id("user-menu")).click(); //dropdown-toggle, fa-caret-down
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//*[@class='dropdown user-menu-dropdown open']//*[@class='dropdown-menu']" +
//                "//*[@class='last']//*[@class='no-hash']")).click(); //dropdown-toggle, fa-caret-down
//        Thread.sleep(1000);

//        List<WebElement> linkList = driver.findElements(By.tagName("a"));
//
//        try {
//            for(int i = 0; i < linkList.size(); i++){
//                System.out.println(linkList.get(i).getAttribute("href"));
//                if(linkList.get(i).getAttribute(("href")).contains("/user/logout") && linkList.get(i).isDisplayed()){
//                    linkList.get(i).click();
//                }
//            }
//        }
//        catch(org.openqa.selenium.StaleElementReferenceException ex)
//        {
//            System.out.println("URL check:");
//            StringUtility.verifyEquals(driver.getCurrentUrl(), expectedUrl);
//            System.out.println("Title check:");
//            StringUtility.verifyEquals(driver.getTitle(), expectedTitle);
//        }
    }

    public static void loginVyTrack() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String userName = "storemanager94";
        String login = "UserUser123";
        String expectedUrl = "http://qa3.vytrack.com/";
        driver.manage().window().maximize();
        String expectedTitle = "Dashboard";
        driver.get("http://qa3.vytrack.com/user/login");
        Thread.sleep(1000);
        driver.findElement(By.id("prependedInput")).sendKeys(userName + Keys.TAB + login);
        Thread.sleep(1000);
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(1000);
        System.out.println("URL check:");
        StringUtility.verifyEquals(driver.getCurrentUrl(), expectedUrl);
        System.out.println("Title check:");
        StringUtility.verifyEquals(driver.getTitle(), expectedTitle);
        driver.quit();
    }
}
