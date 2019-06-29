package com.cybertek.tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TagDemo {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement elem = driver.findElement(By.tagName("h2"));
        System.out.println(elem.getText());

        driver.findElement(By.tagName("input")).sendKeys(Faker.instance().name().fullName()+
                Keys.TAB+Faker.instance().internet().emailAddress());

        driver.findElement(By.tagName("button")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(1500);
        driver.quit();


    }
}
