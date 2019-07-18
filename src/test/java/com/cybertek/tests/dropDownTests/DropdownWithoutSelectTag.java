package com.cybertek.tests.dropDownTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class DropdownWithoutSelectTag {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");
        Thread.sleep(100);

        WebElement dropDownLink = driver.findElement(By.cssSelector("#dropdownMenuLink"));
        dropDownLink.getText();
        dropDownLink.click();

        List<WebElement> allOptions = driver.findElements(By.className("dropdown-item"));

        System.out.println(allOptions.size());
        for( WebElement option:allOptions){
            System.out.println(option.getText());
        }
        WebElement yahoo = driver.findElement(By.linkText("Yahoo"));
        yahoo.click();
//        Thread.sleep(1500);
//        dropDownLink.findElement(By.cssSelector("#content > div > div > a:nth-child(1)")).click();
//        Thread.sleep(1500);

        driver.quit();
    }
}
