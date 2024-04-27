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

public class DataDrivenTesting extends BaseClass {
	@Test(dataProvider = "LoginDataProvider")
	public void verifyRegistrationAndLogIn(String userName,String userPass,String expectedUserName) {
		//open Url
	
		
		Homepage homepage=new Homepage(driver);
		homepage.clickOnSignIn();
		
		myAccount myAcc=new myAccount(driver);
		myAcc.createAccount(userName);
		
		AccountCreationDetails accCreation=new AccountCreationDetails(driver);
		accCreation.selectMr();
		accCreation.enterFirstName("Suraj");
		accCreation.enterLastName("Dev");
		accCreation.enterPass(userPass);
		accCreation.clickOnRegister();
		
		RegisteredUserAccount regUser=new RegisteredUserAccount(driver);
		String username=regUser.getUserName();
		Assert.assertEquals(expectedUserName, username);
		
	}
	@Test(dataProvider = "LoginDataProvider")
	public void verifyLogIn(String userName,String userPass,String expectedUserName) {
		Homepage homepage=new Homepage(driver);
		homepage.clickOnSignIn();
		
		myAccount myAcc=new myAccount(driver);
		myAcc.enterRegisteredAccountDetails(userName,userPass);
		
		RegisteredUserAccount regUser=new RegisteredUserAccount(driver);
		String username=regUser.getUserName();
		Assert.assertEquals(expectedUserName, username);
		regUser.clickOnSignOut();
		
	}
	@DataProvider(name="LoginDataProvider")
	public String[][]LoginDataProvider() throws IOException{
		String fileName="C:\\Suraj Automation\\Suraj_Automation_Class\\MavenProjectYoutube\\MyStoreV1\\TestData\\MyStoreData.xlsx";
		
		int totalRows=ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int totalCell=ReadExcelFile.getCellCount(fileName,"LoginTestData");
		
		String[][]data=new String[totalRows-1][totalCell];
		
		for(int i=1;i<totalRows;i++) {
			for(int j=0;j<totalCell;j++) {
				data[i-1][j]=ReadExcelFile.getvalue(fileName, "LoginTestData", i, j);
			}
		}
		return data;
	}

}
