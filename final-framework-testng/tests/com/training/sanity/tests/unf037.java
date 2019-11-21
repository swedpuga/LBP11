package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.UnifAdmnLogin;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class unf037 {
	
	private WebDriver driver;
	private String baseUrl;
	private UnifAdmnLogin unifAdmnLogin;
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
	@Test(dataProvider="createData1")
	public void UnifAdminInvalidLoginTest(String userName,String password) {
		
		unifAdmnLogin.sendUserName(userName);
		unifAdmnLogin.sendPassword(password);
		unifAdmnLogin.clickLoginBtn();
		unifAdmnLogin.assertErrMssg1();
		screenShot.captureScreenShot("UniformAdminInvalidLoginTest"+userName+password);
		/*driver.findElement(By.id("input-username")).sendKeys("Nha");
		driver.findElement(By.id("input-password")).sendKeys("neha2345");
		driver.findElement(By.xpath("//button[@type='submit' and contains(@class,'btn-primary')]")).click();
		String errMssg = driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]")).getText();
		System.out.println(errMssg);*/
	}
	
	@DataProvider
		public Object[][] createData1() {
			Object[][] data1 = new Object[4][2];
			data1[0][0]="admin";
			data1[0][1]="23445";
			data1[1][0]="admin";
			data1[1][1]="admin";
			data1[2][0]="neha";
			data1[2][1]="admin@123";
			data1[3][0]="admin@123";
			data1[3][1]="admin@123";
			
			return data1;
			
		}
	}

