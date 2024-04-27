package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUserAccount {
	// 1. Create object of webdriver
	WebDriver driver;

	public RegisteredUserAccount(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}

	// identify webelements
	@FindBy(xpath = "//a[@title='View my customer account']")
	WebElement userName;
	@FindBy(linkText  = "Sign out")
	WebElement signOut;
	
	public void clickOnSignOut() {
		signOut.click();
	}
	
	public String getUserName() {
		String text=userName.getText();
		return  text;
	}

}
