package com.gaopin.utils;



public class GenerateVerificationCode {
	
	private GenerateVerificationCode() { } // singleton

	  public static String next() {
	   
	     
	     int x=(int)(Math.random()*9000+1000);
	     
	     return String.valueOf(x);
	  }

}