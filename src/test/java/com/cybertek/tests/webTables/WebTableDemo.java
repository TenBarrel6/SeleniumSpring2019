package com.cybertek.tests.webTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTableDemo {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod
    public void tearDown(){driver.quit();}

    @Test
    public void printTable(){
        WebElement table = driver.findElement(By.id("table1"));
        System.out.println(table.getText());
    }

    // headers
//    @Test
    public void headersTest(){
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        headers.forEach((cell-> System.out.println(cell.getText())));
        System.out.println("headers.size() = "+headers.size());
    }

    //get table size
    @Test
    public void tableSizeTest(){
        // TODO number of columns
        List<WebElement> cols = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("Number of columns = "+cols.size());
        // TODO number of rows including headers
        List<WebElement> rowsWithHeaders = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("Number of rows including headers = "+rowsWithHeaders.size());
        // TODO number row without headers
        List<WebElement> rowsWithOutHeaders = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println("Number of rows without headers = "+rowsWithOutHeaders.size());
    }

    // get whole row
    @Test
    public void wholeRowTest(){
        WebElement wholeRow = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]"));
        System.out.println("whole row = "+wholeRow.getText());
        int index = 2;
        String rowXpath = "//table[@id='table1']/tbody/tr["+index+"]";
        wholeRow = driver.findElement(By.xpath(rowXpath));
        System.out.println("whole row 2 = "+wholeRow.getText());
    }

    // get all cells from certain row
    @Test
    public void getCellsInRow(){
        List<WebElement> cellsInRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));
        cellsInRow.forEach(cell-> System.out.println(cell.getText()));
        int index = 3;
        String cellInRowXpath = "//table[@id='table1']/tbody/tr["+index+"]/td";
        cellsInRow = driver.findElements(By.xpath(cellInRowXpath));
        cellsInRow.forEach(cell-> System.out.println(cell.getText()));
    }

    // get certain cell
    @Test
    public void certainCellTest(){
        WebElement cell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td[1]"));
        System.out.println(cell.getText());
    }

    // get a value from a cell base on its coordinates/index?
    public WebElement getCell(int row, int col){
        String xpath = "//table[@id='table1']/tbody/tr["+row+"]/td["+col+"]";
        return driver.findElement(By.xpath(xpath));
    }

    @Test
    public void getCellCoordinates(){
        WebElement cell = getCell(3, 4);
        Assert.assertEquals(cell.getText(), "$100.00");

        cell = getCell(4, 5);
        Assert.assertEquals(cell.getText(), "http://www.timconway.com");
    }

    // go to the page
    // click on email
    // verify email column is sorted in ascending order
    @Test
    public void columnSortTest(){
        // click on column email
        // get all column names
        // click on col email
        List<WebElement> colNames = getAllColumnsNames();
        for(WebElement colName : colNames){
            if(colName.getText().equals("Email")){
                colName.click();
            }
        }

        //get all the data under the Email col
        //get teh index of the Email
        int colIndex = getColumnIndex("Email");
        System.out.println(colIndex);

        // generate the xpath all cells under the email col
        String xpath = "//table[@id='table1']/tbody/tr/td["+colIndex+"]";
        List<WebElement> allEmails = driver.findElements(By.xpath(xpath));
        allEmails.forEach(email-> System.out.println(email.getText()));

    }

    private List<WebElement> getAllColumnsNames() {
        List<WebElement> cols = driver.findElements(By.xpath("//table[@id='table1']//th"));
        return cols;
    }

    private int getColumnIndex(String col){
        List<WebElement> cols = getAllColumnsNames();
        for(int i = 0; i<cols.size(); i++){
            if(cols.get(i).getText().equals(col)){
                return i+1;
            }
        }
        return 0;
    }
}
