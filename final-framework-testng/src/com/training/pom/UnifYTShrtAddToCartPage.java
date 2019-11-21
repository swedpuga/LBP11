package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class UnifYTShrtAddToCartPage {
	private WebDriver driver;
	
	public UnifYTShrtAddToCartPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="input-option382")
	private WebElement sizeDropDown;
	
	@FindBy(id="button-cart")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//div[contains(@class,'alert-success')]")
	private WebElement succMess1;
	
	public void selectSize(String size) {
		Select Size = new Select(this.sizeDropDown);
		Size.selectByVisibleText(size);
	}
	
	public void clickAddToCart() {
		this.addToCartBtn.click();
	}
	
	public void assertSuccMess1() {
		String SuccMess = this.succMess1.getText();
		int a = SuccMess.length();
		a=a-2;
		SuccMess = SuccMess.substring(0, a);
		SuccMess = SuccMess.trim();
		Assert.assertEquals(SuccMess,"Success: You have added REGULAR T-SHIRTS (YELLOW) to your shopping cart!");
	}
}
