package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AssertEqualsTest {

    @Test
    public void test(){
        String exp = "google";
        String actual = "google";
        System.out.println("first assertion");
        Assert.assertEquals(1, 1);
        System.out.println("second assertion");
        Assert.assertEquals(actual, exp);
        System.out.println("End");
    }

    @Test
    public void test2(){
        String exp = "exp";
        String actual = "actu!";
        System.out.println("first assertion");
        Assert.assertEquals(1, 1);
        System.out.println("second assertion");
        Assert.assertEquals(actual, exp);
        System.out.println("End");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("report");
    }
}
