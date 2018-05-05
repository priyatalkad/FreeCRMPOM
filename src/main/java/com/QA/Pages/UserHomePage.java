package com.QA.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QA.BaseClass.TestBaseClass;

public class UserHomePage extends TestBaseClass{
	
////**************** Defining elements ********** ////
	// page Factory or Obj Repository
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement ContactsLink;

	@FindBy(xpath = "//td[contains(text(),'User: Naveen K')]")
	WebElement UserLabel;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement NewContactLink;
	

	
	//// **************** Initializing elements ********** ////
	public UserHomePage() {
		PageFactory.initElements(driver, this);

	}

	
	//// **************** Actions available on the page ********** ////
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean validateUserLabel() {
		return UserLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
	
		ContactsLink.click();
		return new ContactsPage();
	}
	
	public void clickOnNewContact() {
		
		Actions action = new Actions(driver);
		action.moveToElement(ContactsLink).build().perform();
		NewContactLink.click();
		
	}

}

