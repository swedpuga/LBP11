package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ufm009 {
	
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
	public void RemProductFromCartTest() {
		driver.findElement(By.xpath("//img[contains(@src,'BacktoSchool')]")).click();
		Actions actions = new Actions(driver);
		WebElement YellowTShirt = driver.findElement(By.xpath("//img[contains(@title,'REGULAR T-SHIRTS (YELLOW)')]"));
		actions.moveToElement(YellowTShirt).perform();
		driver.findElement(By.xpath("//span[text()='Add to Cart' and contains(@class,'hidden')]")).click();
		Select Size = new Select(driver.findElement(By.id("input-option382")));
		Size.selectByVisibleText("28");
		driver.findElement(By.id("button-cart")).click();
		driver.findElement(By.id("cart")).click();
		driver.findElement(By.partialLinkText("View Cart")).click();
		driver.findElement(By.className("fa-times-circle")).click();
		//button[contains(@data-original-title,'Remove')]
		String CartEmptyMess = driver.findElement(By.xpath("//div[@id='content']/p")).getText();
		CartEmptyMess = CartEmptyMess.trim();
		//System.out.println(driver.findElement(By.xpath("//div[@id='content']/p")).getText());
		Assert.assertEquals("Your shopping cart is empty!",CartEmptyMess);
	}

}
