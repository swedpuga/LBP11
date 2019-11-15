package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ShoppingCartPOM;
import com.training.pom.UnifHeaderPOM;
import com.training.pom.UnifHomePage;
import com.training.pom.UnifYTShrtAddToCartPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ufm009 {
	
	private WebDriver driver;
	private String baseUrl;
	private UnifHomePage unifHomePage;
	private UnifYTShrtAddToCartPage unifYTShrtAddToCartPage;
	private UnifHeaderPOM unifHeaderPOM;
	private ShoppingCartPOM shoppingCartPOM;
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
		unifHomePage = new UnifHomePage(driver);
		unifYTShrtAddToCartPage = new UnifYTShrtAddToCartPage(driver);
		unifHeaderPOM = new UnifHeaderPOM(driver);
		shoppingCartPOM = new ShoppingCartPOM(driver);
		baseUrl = properties.getProperty("baseURL");
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
	public void RemProductFromCartTest() {
		
		unifHomePage.clickShopUniformsBtn();
		unifHomePage.movetoYellowTshirtImg();
		unifHomePage.clickAddtoCartYellowTShirt();
		unifYTShrtAddToCartPage.selectSize("28");
		unifYTShrtAddToCartPage.clickAddToCart();
		unifHeaderPOM.viewCartLink();
		shoppingCartPOM.clickRemoveBtn();
		shoppingCartPOM.assertCartEmptyMess();

	}

}
