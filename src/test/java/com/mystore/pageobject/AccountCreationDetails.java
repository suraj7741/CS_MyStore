package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationDetails {
	//1. Create object of webdriver
		WebDriver driver;
		
		public AccountCreationDetails(WebDriver d) {
			driver=d;
			PageFactory.initElements(d, this);
		}
		
		//identify webelements
		@FindBy(id = "id_gender1")
		WebElement titleMr;
		@FindBy(id = "customer_firstname")
		WebElement firstName;
		@FindBy(id = "customer_lastname")
		WebElement lastName;
		@FindBy(id = "passwd")
		WebElement password;
		@FindBy(xpath ="//span[text()='Register']")
		WebElement register;
		
		//identify action on webelement
		
		public void selectMr() {
			titleMr.click();
		}
		public void enterFirstName(String fname) {
			firstName.sendKeys(fname);
		}
		public void enterLastName(String lname) {
			lastName.sendKeys(lname);
		}
		public void enterPass(String pass) {
			password.sendKeys(pass);
		}
		public void clickOnRegister() {
			register.click();
		}

}
