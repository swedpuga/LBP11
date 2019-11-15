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
import com.training.pom.LoginUnifPOM;
import com.training.pom.UnifChaneMyPassPage;
import com.training.pom.UnifHeaderPOM;
import com.training.pom.UnifMyAcctPage;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ufm007 {

	private WebDriver driver;
	private String baseUrl;
	private UnifHeaderPOM unifHeaderPOM;
	private LoginUnifPOM loginUnifPOM;
	private UnifMyAcctPage unifMyAcctPage;
	private UnifChaneMyPassPage unifChaneMyPassPage;
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
		unifHeaderPOM = new UnifHeaderPOM(driver);
		loginUnifPOM = new LoginUnifPOM(driver);
		unifMyAcctPage = new UnifMyAcctPage(driver);
		unifChaneMyPassPage = new UnifChaneMyPassPage(driver);
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
	public void ChangePasswordErrMessgTest() {
		
		unifHeaderPOM.clickLoginLink();
		loginUnifPOM.sendUserName("vggt@in.ibm.com");
		loginUnifPOM.sendPassword("1234qwe");
		loginUnifPOM.clickLoginBtn();
	
		unifHeaderPOM.clickMyAcctLink();
		unifMyAcctPage.clickChangeMyPasswordLink();
		
		unifChaneMyPassPage.sendNewPassword("sneha");
		unifChaneMyPassPage.sendConfirmNewPassword("snaeh");
		unifChaneMyPassPage.clickContinueBtn();
		screenShot.captureScreenShot("PasswordChangeErrMssg");
		unifChaneMyPassPage.assertErrMssg1();
	
	}
}
