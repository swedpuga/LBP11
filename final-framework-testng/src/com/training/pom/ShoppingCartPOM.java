package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ShoppingCartPOM {
	private WebDriver driver;
	
	public ShoppingCartPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="fa-times-circle")
	private WebElement removeBtn;
	
	@FindBy(xpath="//div[@id='content']/p")
	private WebElement cartEmptyMess;
	
	public void clickRemoveBtn() {
		this.removeBtn.click();
	}
	
	public void assertCartEmptyMess() {
		String cartEmptyMssg = this.cartEmptyMess.getText();
		cartEmptyMssg = cartEmptyMssg.trim();
		Assert.assertEquals("Your shopping cart is empty!",cartEmptyMssg);
	}

}
