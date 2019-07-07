package com.cybertek.tests;

import org.testng.annotations.*;

import java.util.PriorityQueue;

public class TestNGDemo {
    @BeforeClass
    public void setUpClass(){
        System.out.println("setting path");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("reporting everything to HR");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("opening browser");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("closing browser\n");
    }

    @Test
    public void test(){
        System.out.println("\ttesting test case 1");
    }

    @Test
    public void test2() {
        System.out.println("\ttesting test case 2");
    }
}

