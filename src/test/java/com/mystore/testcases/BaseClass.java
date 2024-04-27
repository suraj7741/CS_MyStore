package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.mystore.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();
	String url = readConfig.getBaseURL();
	String browser = readConfig.getBrowser();

	public static WebDriver driver;
    @BeforeClass
	public void invokeBrowser() {

		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "msedge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;

		}
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(url);
		
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
	
	public void captureScreenShot(WebDriver driver, String testName) throws IOException {
		//Capture full page screenshot
		  
		  TakesScreenshot sc=((TakesScreenshot)driver);
		//create screenshot image file 
		 File src=sc.getScreenshotAs(OutputType.FILE);
		 
		 //detination to save file 
		  File dest=new File("C:\\Suraj Automation\\Suraj_Automation_Class\\MavenProjectYoutube\\MyStoreV1\\Screenshots\\"+testName+".png");
		 
		 FileUtils.copyFile(src, dest);
	}

}
