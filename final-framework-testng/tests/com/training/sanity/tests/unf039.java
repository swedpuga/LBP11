package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.UnifAdmnCategoriesPage;
import com.training.pom.UnifAdmnLogin;
import com.training.pom.UnifAdmnSideNavBar;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class unf039 {
	
	private WebDriver driver;
	private String baseUrl;
	private UnifAdmnLogin unifAdmnLogin;
	private UnifAdmnSideNavBar unifAdmnSideNavBar;
	private UnifAdmnCategoriesPage unifAdmnCategoriesPage;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		unifAdmnLogin = new UnifAdmnLogin(driver);
		unifAdmnSideNavBar = new UnifAdmnSideNavBar(driver);
		unifAdmnCategoriesPage = new UnifAdmnCategoriesPage(driver);
		baseUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void UnifAdmnEditCategory() {

		unifAdmnLogin.sendUserName("admin");
		unifAdmnLogin.sendPassword("admin@123");
		unifAdmnLogin.clickLoginBtn();
		
		unifAdmnSideNavBar.moveToCatalogBtn();
		unifAdmnSideNavBar.clickCategoriesLink();
		
		unifAdmnCategoriesPage.clickFirstCatgryEditBtn();
		unifAdmnCategoriesPage.sendMetaTagTitle("BLZ 05");
		unifAdmnCategoriesPage.sendMetaTagDescription("Uniform for students");
		unifAdmnCategoriesPage.clickSaveBtn();
		unifAdmnCategoriesPage.assertSuccsMssg1();
		screenShot.captureScreenShot("UniformAdminEditCategory");
		
	}

}
