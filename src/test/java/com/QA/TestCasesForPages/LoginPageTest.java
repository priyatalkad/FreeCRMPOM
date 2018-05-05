package com.QA.TestCasesForPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.QA.BaseClass.TestBaseClass;
import com.QA.Pages.LoginPage;
import com.QA.Pages.UserHomePage;

public class LoginPageTest extends TestBaseClass {

	public LoginPage loginpg;
	public UserHomePage homepg;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpg = new LoginPage();

	}

	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginpg.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service",
				"Page title not as per requirement");
	}
	
	
	@Test(priority=2)
	public void CRMLogo() {
		boolean b = loginpg.validateCRMLogo();
		Assert.assertEquals(b, true, "CRM Logo not displayed");
	}
	
	
	public void userLogin() {
		homepg=loginpg.UserLogin(prop.getProperty("username"), prop.getProperty("password"));
	
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
}
