package com.cybertek.tests.jse_and_actions;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest {
    WebDriver driver;
    JavascriptExecutor jse;
    Actions actions;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        jse = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void hover() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.tagName("img"));
        // moveToElement() --> move the mouse to given target
        // perform --> triggers the action
        actions.moveToElement(element).perform();
        Assert.assertTrue(VerificationUtils.isElementDisplayed(driver, By.linkText("View profile")));
    }

    @Test
    public void hover2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        Thread.sleep(1000);
        WebElement firstOne = driver.findElement(By.id("ui-id-3"));
        WebElement secondOne = driver.findElement(By.id("ui-id-4"));

        actions.moveToElement(firstOne).perform();
        Thread.sleep(1000);
        actions.moveToElement(secondOne).perform();

    }

    @Test
    public void chainingAction() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        Thread.sleep(1000);
        WebElement firstOne = driver.findElement(By.id("ui-id-3"));
        WebElement secondOne = driver.findElement(By.id("ui-id-4"));

        actions.moveToElement(firstOne).pause(1000).moveToElement(secondOne).build().perform();

    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Thread.sleep(1000);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        actions.dragAndDrop(source,target).perform();

    }

    @Test
    public void dragAndDropChaining() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/");
        Thread.sleep(1000);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));
        // click and hold source
        // move
        // let it go

        actions.clickAndHold(source).pause(2000)
                .moveToElement(target).pause(2000)
                .release().build().perform();
    }

    @Test
    public void scrollAct() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Thread.sleep(1000);

        //arrow down
        actions.sendKeys(Keys.ARROW_DOWN).pause(1000)
                .sendKeys(Keys.ARROW_DOWN).pause(1000)
                .sendKeys(Keys.ARROW_DOWN).pause(1000)
                .sendKeys(Keys.ARROW_DOWN).pause(1000)
                .sendKeys(Keys.ARROW_DOWN).pause(1000)
                .build().perform();
        //arrow up
        actions.sendKeys(Keys.ARROW_UP).pause(1000)
                .sendKeys(Keys.ARROW_UP).pause(1000)
                .sendKeys(Keys.ARROW_UP).pause(1000)
                .sendKeys(Keys.ARROW_UP).pause(1000)
                .sendKeys(Keys.ARROW_UP).pause(1000)
                .build().perform();
        //page down
        actions.sendKeys(Keys.PAGE_DOWN).pause(1000)
                .sendKeys(Keys.PAGE_DOWN).pause(1000)
                .sendKeys(Keys.PAGE_DOWN).pause(1000)
                .sendKeys(Keys.PAGE_DOWN).pause(1000)
                .sendKeys(Keys.PAGE_DOWN).pause(1000)
                .build().perform();
        //page up
        actions.sendKeys(Keys.PAGE_UP).pause(1000)
                .sendKeys(Keys.PAGE_UP).pause(1000)
                .sendKeys(Keys.PAGE_UP).pause(1000)
                .sendKeys(Keys.PAGE_UP).pause(1000)
                .sendKeys(Keys.PAGE_UP).pause(1000)
                .build().perform();
    }
}
