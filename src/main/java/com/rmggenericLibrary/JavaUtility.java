package com.rmggenericLibrary;

import java.util.Random;

public class JavaUtility {
	
	public int generateRandomNumber()
	{
		Random r=new Random();
		int randomNumber = r.nextInt(3000);
		return randomNumber;
		
	}

}
