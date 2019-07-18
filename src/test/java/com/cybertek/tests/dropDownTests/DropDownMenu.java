package com.cybertek.tests.dropDownTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownMenu {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");
        Thread.sleep(1000);
        WebElement drop1 = driver.findElement(By.id("dropdown"));
        Select drop1Options = new Select(drop1);
        WebElement selectedOption = drop1Options.getFirstSelectedOption();
        System.out.println(selectedOption.getText());
        // GET ALL AVAILABLE OPTIONS
        // getOptions  --> returns all avaiable options
        List<WebElement> allOptions = drop1Options.getOptions();
        System.out.println("Number of options: " + allOptions.size());

        for (WebElement option : allOptions) {
            System.out.println(option.getText());
        }
        Thread.sleep(1000);
        drop1.click();
        Thread.sleep(1000);
        drop1.findElement(By.cssSelector("#dropdown > option:nth-child(2)")).click();
        Thread.sleep(1000);
        driver.quit();
    }
}
