package com.soft.day01;

import org.junit.Test;
import org.testng.annotations.BeforeMethod;

public class ceshi{
@BeforeMethod
public void beforeMehod(){
    System.out.print("1111");
}

@Test

public void testCase1(){
    System.out.print("2222");
}

@Test

public  void testCase2(){
    System.out.print("33333");
}
}
