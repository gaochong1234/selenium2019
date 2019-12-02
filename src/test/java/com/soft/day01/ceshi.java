package com.soft.day01;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ceshi{
@BeforeMethod
public void beforeMehod(){
    System.out.print("1111");
}

@Test
public void testCase1(){
    System.out.print("2222");
    Assert.assertEquals(1,2);
}

@Test
public  void testCase2(){
    System.out.print("33333");
}
}
