package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.UnifAdmnCategoriesPage;
import com.training.pom.UnifAdmnLogin;
import com.training.pom.UnifAdmnSideNavBar;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class unf038 {
	
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
	@Test(dataProvider="addCatgryData")
	public void UnifAdmnAddCategory(String categoryName,String description,String metaTagTitle,String metaTagDescription) {
		unifAdmnLogin.sendUserName("admin");
		unifAdmnLogin.sendPassword("admin@123");
		unifAdmnLogin.clickLoginBtn();
		unifAdmnSideNavBar.moveToCatalogBtn();		
		unifAdmnSideNavBar.clickCategoriesLink();		
		unifAdmnCategoriesPage.clickAddCategory();
		unifAdmnCategoriesPage.sendCategoryName(categoryName);
		unifAdmnCategoriesPage.sendDescriptionText(description);
		unifAdmnCategoriesPage.sendMetaTagTitle(metaTagTitle);
		unifAdmnCategoriesPage.sendMetaTagDescription(metaTagDescription);
		unifAdmnCategoriesPage.clickSaveBtn();
		unifAdmnCategoriesPage.assertSuccsMssg1();
		screenShot.captureScreenShot("UniformAdminAddCategory"+categoryName);
		
	}
	
	@DataProvider
	public Object[][] addCatgryData() {
		Object[][] testData = new Object[4][4];
		testData[0][0]="Sports wear";
		testData[0][1]="Sports";
		testData[0][2]="Sports";
		testData[0][3]="Sports";
		testData[1][0]="Cultural Wear";
		testData[1][1]="Cultural";
		testData[1][2]="Cultural";
		testData[1][3]="Cultural";
		testData[2][0]="Weekend uniform";
		testData[2][1]="Weekend";
		testData[2][2]="Weekend";
		testData[2][3]="Weekend";
		testData[3][0]="Formal wear";
		testData[3][1]="formal";
		testData[3][2]="formal";
		testData[3][3]="formal";
		
		return testData;
		
	}

}
