package com.test;

import java.nio.channels.InterruptedByTimeoutException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import com.object.GoogleSearch;

public class TestScenario {
	      WebDriver driver;
           GoogleSearch signupobj; //declare variable
	@BeforeTest
	public void beforeTest() {
		//write code that should execute before every test method execution
		System.setProperty("webdriver.chrome.driver","D://Driver//chromedriver.exe");
		

		//instance of chromedriver 
		 driver=new ChromeDriver();
		//implicitly managing
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();//maxmize the window
		driver.get("https://www.demoblaze.com/");
	}
		
		@Test(priority = 1)
		public void signupTest() throws InterruptedException {
			//create an object of SignupPage to get the locators from that class
			signupobj=new GoogleSearch(driver); 
			signupobj.clickSignupLandingBtn();
			Thread.sleep(3000);
			signupobj.enterSignupUsername("asdfg@#");
			signupobj.enterSignupPassword("admin123");
			Thread.sleep(1000);
			signupobj.clickSignupBtn();	
			//performing assertiion or verification to confirm the successful 
			Thread.sleep(5000);
			Alert alert=driver.switchTo().alert();
			String actualText=alert.getText();
			Assert.assertEquals(actualText, "Sign up successful.");
		}
		
		@Test(priority = 2)
		public void signupWithExisitingUsername() throws InterruptedException {
//			This user already exist.
			signupobj=new GoogleSearch(driver); 
			String exisitingUsername=("asdfg@#");
			String password="admin123";
			signupobj.clickSignupLandingBtn();
			Thread.sleep(3000);
			signupobj.enterSignupUsername(exisitingUsername);
			signupobj.enterSignupPassword(password);
			Thread.sleep(1000);
			signupobj.clickSignupBtn();	

			//perform validation 
			Thread.sleep(1000);
			Alert alert=driver.switchTo().alert();
			String actualText=alert.getText();
			String expectedtText="This user already exist.";
			
			Assert.assertEquals(actualText, expectedtText);
			
		}

		
		
	
	@AfterTest
	public void AfterTest() {
		driver.quit();
	}
	
}
