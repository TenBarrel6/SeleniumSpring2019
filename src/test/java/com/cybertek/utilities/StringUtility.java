package com.cybertek.utilities;

public class StringUtility {
    public static void verifyEquals(String actual, String expected){
        System.out.println(actual.equals(expected)?"PASS":"FAIL"+"\nactual: "+actual+"\nexpected: "+expected);
    }
}
