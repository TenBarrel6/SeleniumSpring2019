package com.cybertek.tests;

import com.cybertek.utilities.StringUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class LocatorsTesting {
    public static void main(String[] args) throws InterruptedException{
        googleResultsTitle();
        etsySearchTest();
        vyTrackTitleTest();
        vyTrackShortCutTest();

    }

    public static void googleResultsTitle() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        List<String> searchStrs = Arrays.asList("Java", "JUnit", "REST Assured");

        driver.get("https://google.com");
        driver.manage().window().maximize();


        for(String item:searchStrs) {
            driver.findElement(By.name("q")).
                    sendKeys(item+ Keys.ENTER);
            Thread.sleep(1500);
            String expected = driver.findElement(By.xpath("//*[@class='TbwUpd']//*[@class='iUh30']")).getText();
            driver.findElement(By.xpath("//*[@class='rc']//*[@class='r']")).click();
            Thread.sleep(1500);
            String actual = driver.getCurrentUrl();
            StringUtility.verifyEquals(actual,expected);
            Thread.sleep(1500);
            driver.navigate().to("https://google.com");
            Thread.sleep(1500);
        }
        driver.quit();
    }

    public static void etsySearchTest() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://etsy.com");
        driver.manage().window().maximize();
        Thread.sleep(1500);
        driver.findElement(By.id("global-enhancements-search-query")).
                sendKeys("wooden spoon"+Keys.ENTER);
        String expected = driver.findElement(By.xpath("//span[@class=' text-smaller']")).getText();
        driver.findElement(By.xpath("//a[@title='All categories']")).click();
        Thread.sleep(1500);
        String actual = driver.findElement(By.xpath("//span[@class=' text-smaller']")).getText();
        System.out.println("Number of results is bigger then previous:");
        System.out.println(StringUtility.resultsNumber(actual)>StringUtility.resultsNumber(expected)?"YES":"NO");
        Thread.sleep(1500);
        driver.navigate().back();
        Thread.sleep(1500);
        actual = driver.findElement(By.id("global-enhancements-search-query")).getAttribute("value");
        System.out.println("Search box content test:");
        StringUtility.verifyEquals(actual, "wooden spoon");
        driver.navigate().back();
        actual = driver.findElement(By.id("global-enhancements-search-query")).getAttribute("value");
        System.out.println("Search box on a homepage is blank:");
        System.out.println(actual.isEmpty()?"YES":"NO");
        driver.quit();
    }

    public static void vyTrackTitleTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // open VyTrack login page
        driver.get("http://qa3.vytrack.com/user/login");
        driver.manage().window().maximize();
        // Login to the VyTrack
        String userName = "storemanager94";
        String login = "UserUser123";
        Thread.sleep(1500);
        driver.findElement(By.id("prependedInput")).sendKeys(userName + Keys.TAB + login);
        Thread.sleep(1500);
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(1500);
        //Taking user name from user menu and navigating to "My Configuration" from user menu list
        String expectedUserName = driver.findElement(By.id("user-menu")).getText();
        driver.findElement(By.xpath("//*[@id='user-menu']//*[@class='fa-caret-down']")).click();
        Thread.sleep(1500);
        driver.findElement(By.linkText("My Configuration")).click();
        Thread.sleep(1500);
        //Taking "My Configuration" title and comparing with user name
        String title = driver.getTitle();
        System.out.println("Title of the page starts with userName:");
        System.out.println(title.startsWith(expectedUserName)?"YES":"NO");

        //Quit browser
        driver.quit();

    }

    public static void vyTrackShortCutTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // open VyTrack login page
        driver.get("http://qa3.vytrack.com/user/login");
        driver.manage().window().maximize();
        // Login to the VyTrack
        String userName = "storemanager94";
        String login = "UserUser123";
        Thread.sleep(1500);
        driver.findElement(By.id("prependedInput")).sendKeys(userName + Keys.TAB + login);
        Thread.sleep(1500);
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(1500);
        //Open dashboard page and verify that it's open
        System.out.println("Dashboard page is open:");
        System.out.println(driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).
                getText().equalsIgnoreCase("dashboard")?"YES":"NO");
        Thread.sleep(1500);
        //Opens shortCut menu
        driver.findElement(By.xpath("//div[@class='dropdown header-dropdown-shortcut header-utility-dropdown']")).click();
        Thread.sleep(1500);
        //Opens full list
        driver.findElement(By.linkText("See full list")).click();
        Thread.sleep(1500);
        //Opens Opportunities
        //Verify that Opportunities page is open
        driver.findElement(By.linkText("Opportunities")).click();
        Thread.sleep(1500);
        System.out.println("Opportunities page is open:");
        System.out.println(driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).
                getText().equalsIgnoreCase("Open Opportunities")?"YES":"NO");
        Thread.sleep(1500);
        //Clicking on shortCut icon and choose Vehicle Servise Logs
        driver.findElement(By.xpath("//div[@class='dropdown header-dropdown-shortcut header-utility-dropdown']")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@placeholder='Enter shortcut action']"))
                .sendKeys("Vehicle Services Logs");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@placeholder='Enter shortcut action']")).sendKeys(Keys.ENTER);
        Thread.sleep(1500);
        //Verify that expected error message pop's up
        String expected = "You do not have permission to perform this action.";
        String actual = driver.findElement(By.xpath("//div[@class='alert alert-error fade in top-messages ']" +
                "//div[@class='message']")).getText();
        System.out.println("Error message is displayed and equals:");
        StringUtility.verifyEquals(actual, expected);
        Thread.sleep(1500);
        //Verify that user still on the Opportunities page
        System.out.println("Opportunities page is still open:");
        System.out.println(driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).
                getText().equalsIgnoreCase("Open Opportunities")?"YES":"NO");

        //Quit browser
        driver.quit();

    }

}
