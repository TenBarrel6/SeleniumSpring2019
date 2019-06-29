package com.cybertek.tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class xPathDemo {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/sign_up");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys(Faker.instance().name().fullName());
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(Faker.instance().internet().emailAddress()+
                Keys.ENTER);
        driver.quit();

    }
}
