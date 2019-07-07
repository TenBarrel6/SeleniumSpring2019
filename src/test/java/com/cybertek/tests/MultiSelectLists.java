package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectLists {
    public static void main(String[] args) throws  InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");
        Thread.sleep(100);

        Select list = new Select(driver.findElement(By.name("Languages")));

        list.selectByVisibleText("Java");
        list.selectByVisibleText("Python");
        Thread.sleep(1000);

        // getAllSelectedOptions() --> returns all the selected options
        for(WebElement selectedOption: list.getAllSelectedOptions()){
            System.out.println(selectedOption.getText());
        }

        // deselectByValue --> unselects selected option
        list.deselectByVisibleText("Java");
        Thread.sleep(1000);



        driver.quit();
    }
}
