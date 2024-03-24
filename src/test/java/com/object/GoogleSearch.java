package com.object;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
// precondition
public class GoogleSearch {
	 WebDriver driver;

	 public GoogleSearch(WebDriver driver) {
	
		//intialized the driver object
			this.driver=driver;
			
			PageFactory.initElements(driver, this);
	 }
	 
	//Locators[find the element by id,xpath etc..]
		@FindBy(id="signin2")
		WebElement signuplandingbtn;
		
		@FindBy(id="sign-username")
		WebElement signupusername;
		
		
		@FindBy(id="sign-password")
		WebElement signuppassword;
		
		@FindBy(xpath="//button[@onclick='register()']")
		WebElement signupclickBtn;
		
		// perform action on it
		public void clickSignupLandingBtn() {
			signuplandingbtn.click();
}
		public void enterSignupUsername(String username) {
			signupusername.sendKeys(username);//comes from test method
		}
		
		public void enterSignupPassword(String password) {
			signuppassword.sendKeys(password);	//comes from test method
		}
		
		
		public void clickSignupBtn() {
			signupclickBtn.click();
		}		
		
}
