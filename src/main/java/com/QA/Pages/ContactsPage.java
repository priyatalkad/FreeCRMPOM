package com.QA.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.QA.BaseClass.TestBaseClass;

public class ContactsPage extends TestBaseClass {

	//// **************** Defining elements ********** ////
	// page Factory or Obj Repository

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement ContactsLabel;
	
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	

	//// **************** Initializing elements ********** ////
	public ContactsPage() {
		PageFactory.initElements(driver, this);

	}

	
	public boolean verifyContactsLabel() {
		return ContactsLabel.isDisplayed();
	}

	
	public void selectContactByName(String name) {
		driver.findElement(By.xpath("//a[text()='" + name + "']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		
	}
	

	public void createNewContact(String title, String ftName, String surname, String comp) {
		Select select= new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstName.sendKeys(ftName);
		lastName.sendKeys(surname);
		company.sendKeys(comp);
		saveBtn.click();
	}

}
