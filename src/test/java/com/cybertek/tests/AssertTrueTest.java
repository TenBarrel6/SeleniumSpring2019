package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertTrueTest {

    @Test
    public void test(){
        System.out.println(1==1);
        String url = "https://google.com";
        String exp = ".com";
//        Assert.assertTrue(1==1);
        Assert.assertTrue(url.endsWith(exp));
    }

    @Test
    public void test2(){
        // verify url does not end with .com
        String url = "https://google.com";
        String exp = ".com";
        // expected condition is false
        // if the result is false, it will pass
        Assert.assertFalse(url.endsWith(exp));
    }
}
