package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerificationUtils {
    public static void verifyEquals(String actual, String expected){
        System.out.println(actual.equals(expected)?"PASS":"FAIL"+"\nactual: "+actual+"\nexpected: "+expected);
    }

    public static int resultsNumber(String actual){
        String temp = "";
        for(int i = 0; i<actual.length(); i++){
            if(Character.isDigit(actual.charAt(i))){
                temp+=actual.charAt(i)+"";
            }
        }
        int result = Integer.parseInt(temp);
        return result;
    }

    public static void verifySelected(WebElement element, boolean checked){
        if(checked){
            if(element.isSelected()){
                System.out.println("PASS");
            }else{
                System.out.println("FAIL");
                System.out.println("Element must be selected!");
            }
        }

        if(!checked){
            if(element.isSelected()){
                System.out.println("FAIL");
                System.out.println("Element must be selected!");
            }else{
                System.out.println("PASS");
            }
        }
    }

    public static boolean isElementDisplayed (WebDriver driver, By by) {
        try {
            driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

        return true;

    }}