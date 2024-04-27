package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccount {
	//1. Create object of webdriver
		WebDriver driver;
		
		public myAccount(WebDriver d) {
			driver=d;
			PageFactory.initElements(d, this);
		}
		
		//identify webelements
		@FindBy(id = "email_create")
		WebElement createEmail;
		@FindBy(id = "SubmitCreate")
		WebElement submitEmail;
		@FindBy(xpath  = "//input[@id='email']")
		WebElement enterRegisteredEmail;
		@FindBy(xpath = "//input[@id='passwd']")
		WebElement enterRegisteredPass;
		@FindBy(id = "SubmitLogin")
		WebElement clickSignIn;
		
		//identify action on webelement
		
		public void createAccount(String emailAdd) {
			createEmail.sendKeys(emailAdd);
			submitEmail.click();
		}
		
		//Enter details of already registered user
		public void enterRegisteredAccountDetails(String email,String pass) {
			enterRegisteredEmail.sendKeys(email);
			enterRegisteredPass.sendKeys(pass);
			clickSignIn.click();
		}
		

}
