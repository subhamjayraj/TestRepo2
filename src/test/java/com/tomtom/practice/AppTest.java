package com.tomtom.practice;

import org.testng.Assert;
import org.testng.annotations.Test;



public class AppTest {
    
    @Test
    public void testApp()
    {
       Assert.assertEquals(1, 1); 
       System.out.println("~~~~~~~~~~~~~~ AppTest.java --- testApp() ~~~~~~~~~~~~~~~");
    }
}
