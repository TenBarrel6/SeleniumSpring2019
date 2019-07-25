package com.cybertek.tests.brightERPtests;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BrightERP {
    WebDriver driver = null;
    @BeforeMethod
    public void SetUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://54.148.96.210/");
        Thread.sleep(1500);
        driver.findElement(By.xpath("/html/body/div/header/div/div/div[2]/ul/li[10]/a")).click();
        Thread.sleep(1500);
        driver.findElement(By.id("login")).sendKeys("inm4@info.com");
        driver.findElement(By.id("password")).sendKeys("alsfuh7we70");
        driver.findElement(By.xpath("/html/body/div/main/div/form/div[3]/button")).click();
    }

    @Test
    public void testTC04() throws InterruptedException {
        /*
        Inventory manager has to have access to products. And be able to reorder products.
        6.Find and click on inventory on the top of the website
        7.click on Products
        8. Click on any products
        8. Click on reorder
         */
        Thread.sleep(2500);
        //find and click Inventory button
        driver.findElement(By.xpath("/html/body/nav/div[2]/ul[1]/li[6]/a/span")).click();
        Thread.sleep(2500);
        //find and click Master Data Products
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[6]/ul[2]/li[1]/a")).click();
        Thread.sleep(2500);
        //list of All the products
        List<WebElement> products = driver.findElements(By.className("o_kanban_record_title"));
        Thread.sleep(2500);
        //getting random product
        products.get((int)(Math.random() * products.size())).click();
        Thread.sleep(2500);
        //if reordering is possible go and click, if not - done
        if(driver.findElement(By.name("nbr_reordering_rules")).getText().contains("Reordering Rules")){
            driver.findElement(By.name("nbr_reordering_rules")).click();
            Thread.sleep(2500);
            //breadcrumb
            List<WebElement> lis = driver.findElements(By.tagName("li"));
            for(WebElement li:lis){
                if(li.getText().contains("Reordering Rules")){
                    System.out.println("PASS");
                }
            }
        }else{
            System.out.println("Product reordering is not available. No such button");
        }
        Thread.sleep(2500);
    }

    @Test
    public void testTC05() throws InterruptedException {
        /*
        Inventory manager has to have access to inventory Reports
        1.Go to BriteERP website
        2.Press log in button
        3.Enter the user name in box
        4.Enter the password in box
        5.Press Log in button
        6.Find inventory on the top of the website
        7.click on inventory
         */
        Thread.sleep(2500);
        driver.findElement(By.xpath("/html/body/nav/div[2]/ul[1]/li[6]/a/span")).click();
        Thread.sleep(2500);
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[6]/ul[3]/li[1]/a")).click();
        Thread.sleep(2500);
        driver.findElement(By.name("open_table")).click();
        Thread.sleep(2500);
        List<WebElement> sorted = driver.findElements(By.className("o_column_sortable"));
        VerificationUtils.verifyEquals(sorted.get(3).getText(), "On Hand");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
