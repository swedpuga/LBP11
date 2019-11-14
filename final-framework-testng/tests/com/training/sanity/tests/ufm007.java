package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ufm007 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
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
		loginPOM = new LoginPOM(driver); 
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
		driver.findElement(By.className("fa-user")).click();
		//driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.name("email")).sendKeys("vggt@in.ibm.com");
		driver.findElement(By.id("input-password")).sendKeys("1234qwe");
		
		driver.findElement(By.xpath("//form/input[@type='submit']")).click();
		
		driver.findElement(By.linkText("Change your password")).click();
		
		driver.findElement(By.id("input-password")).sendKeys("sneha");
		driver.findElement(By.id("input-confirm")).sendKeys("snaeh");
		driver.findElement(By.className("btn-primary")).click();
		String errMess = driver.findElement(By.className("text-danger")).getText();
		Assert.assertEquals("Password confirmation does not match password!",errMess);

	}
}
