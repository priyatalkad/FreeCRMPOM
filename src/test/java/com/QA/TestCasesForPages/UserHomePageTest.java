package com.QA.TestCasesForPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.QA.BaseClass.TestBaseClass;
import com.QA.Pages.ContactsPage;
import com.QA.Pages.LoginPage;
import com.QA.Pages.UserHomePage;
import com.QA.Utillities.TimeOuts;

public class UserHomePageTest extends TestBaseClass {

	public LoginPage loginpg;
	public UserHomePage homepg;
	public ContactsPage contactspg;
	public TimeOuts util;

	public UserHomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		util = new TimeOuts();
		contactspg = new ContactsPage();
		loginpg = new LoginPage();
		homepg = loginpg.UserLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void VerifyHomePageTitleTest() {
		String Homepgtitle = homepg.verifyHomePageTitle();
		Assert.assertEquals(Homepgtitle, "CRMPRO", "Page title not as per requirement");
	}



	@Test(priority = 2)
	public void contactsLink() throws InterruptedException {
		Thread.sleep(30000);
		util.swithToFrame();
		contactspg = homepg.clickOnContactsLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
