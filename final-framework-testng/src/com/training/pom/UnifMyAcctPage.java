package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UnifMyAcctPage {
	private WebDriver driver;
	
	public UnifMyAcctPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (linkText="Change your password")
	private WebElement ChangeMyPasswordLink;
	
	public void clickChangeMyPasswordLink() {
		this.ChangeMyPasswordLink.click();
	}
}
