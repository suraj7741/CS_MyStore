package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.AccountCreationDetails;
import com.mystore.pageobject.Homepage;
import com.mystore.pageobject.RegisteredUserAccount;
import com.mystore.pageobject.myAccount;
import com.mystore.utilities.ReadExcelFile;

public class TC_MyAccountPageTest extends BaseClass {
	
	@Test
	public void verifyRegistrationAndLogIn() {
		//open Url
	
		
		Homepage homepage=new Homepage(driver);
		homepage.clickOnSignIn();
		
		myAccount myAcc=new myAccount(driver);
		myAcc.createAccount("suraj7741@gmail.com");
		
		AccountCreationDetails accCreation=new AccountCreationDetails(driver);
		accCreation.selectMr();
		accCreation.enterFirstName("Suraj");
		accCreation.enterLastName("Dev");
		accCreation.enterPass("Suraj@123");
		accCreation.clickOnRegister();
		
		RegisteredUserAccount regUser=new RegisteredUserAccount(driver);
		String username=regUser.getUserName();
		Assert.assertEquals("Suraj Dev", username);
		
	}
	@Test
	public void verifyLogIn() {
		Homepage homepage=new Homepage(driver);
		homepage.clickOnSignIn();
		
		myAccount myAcc=new myAccount(driver);
		myAcc.enterRegisteredAccountDetails("suraj7741@gmail.com","Suraj@123");
		
		RegisteredUserAccount regUser=new RegisteredUserAccount(driver);
		String username=regUser.getUserName();
		Assert.assertEquals("Suraj De", username);
		
		regUser.clickOnSignOut();
		
	}
	

}
