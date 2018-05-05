package com.QA.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.QA.BaseClass.TestBaseClass;

public class LoginPage extends TestBaseClass {

	//// **************** Defining elements ********** ////
	// page Factory or Obj Repository
	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;

	@FindBy(name = "//a[contains(text(),'Sign Up')]")
	WebElement SignUpBtn;

	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;

	
	//// **************** Initializing elements ********** ////
	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	
	//// **************** Actions available on the page ********** ////
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCRMLogo() {
		return crmLogo.isDisplayed();
	}

	public UserHomePage UserLogin(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);
		return new UserHomePage();
	}
}
