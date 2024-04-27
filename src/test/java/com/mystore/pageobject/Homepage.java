package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	//1. Create object of webdriver
	WebDriver driver;
	
	public Homepage(WebDriver d) {
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	//identify webelements
	@FindBy(xpath = "//a[@class='login']")
	WebElement signIn;
	
	
	//identify action on webelement
	
	public void clickOnSignIn() {
		signIn.click();
	}
	

}
