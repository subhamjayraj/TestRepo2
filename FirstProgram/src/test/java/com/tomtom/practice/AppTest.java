package com.tomtom.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.redbus.base.BaseTest;



public class AppTest extends BaseTest{
    
    @Test
    public void testApp()
    {
       Assert.assertEquals(1, 1); 
       System.out.println("~~~~~~~~~~~~~~ AppTest.java --- testApp() ~~~~~~~~~~~~~~~");
      
    }
}
