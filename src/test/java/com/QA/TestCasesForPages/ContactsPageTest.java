package com.QA.TestCasesForPages;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.QA.BaseClass.TestBaseClass;
import com.QA.Pages.ContactsPage;
import com.QA.Pages.LoginPage;
import com.QA.Pages.UserHomePage;
import com.QA.Utillities.TimeOuts;

public class ContactsPageTest extends TestBaseClass {

	public LoginPage loginpg;
	public UserHomePage homepg;
	public ContactsPage contactspg;
	public TimeOuts util;

	String sheetName = "Contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		util = new TimeOuts();
		contactspg = new ContactsPage();
		loginpg = new LoginPage();
		homepg = loginpg.UserLogin(prop.getProperty("username"), prop.getProperty("password"));
		util.swithToFrame();
		contactspg = homepg.clickOnContactsLink();

	}

	@Test(priority = 1)
	public void verifyContactsPgLabel() {
		Assert.assertTrue(contactspg.verifyContactsLabel());
	}

	@Test(priority = 2)
	public void selectContacts() {
		contactspg.selectContactByName("Dena Heaton");
	}

	@Test(priority = 3)
	public void selectMultipleContacts() {
		contactspg.selectContactByName("Deepak Yadav");
		contactspg.selectContactByName("Dena Heaton");
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object[][] data = TimeOuts.getTestData(sheetName);
		return data;
	}

	@Test(priority = 4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String Title,String FirstName,String LastName,String Company) {
		homepg.clickOnNewContact();
		contactspg.createNewContact(Title,FirstName,LastName,Company);
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
