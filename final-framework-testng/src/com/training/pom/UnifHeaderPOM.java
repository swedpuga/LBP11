package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UnifHeaderPOM {
	
private WebDriver driver;
	
	public UnifHeaderPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="fa-user")
	private WebElement userIcon;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement loginLink;
	
	@FindBy(xpath="//a[text()='My Account']")
	private WebElement myAcctLink;
	
	@FindBy(id="cart")
	private WebElement cartIcon;
	
	@FindBy(partialLinkText="View Cart")
	private WebElement viewCartLink;
	
	private void clickUserIcon() {
		this.userIcon.click();
	}
	
	private void clickCartIcon() {
		this.cartIcon.click();
	}
	
	public void clickLoginLink() {
		this.clickUserIcon();
		this.loginLink.click();
	}
	
	public void clickMyAcctLink() {
		this.clickUserIcon();
		this.myAcctLink.click();
	}
	
	public void viewCartLink() {
		this.clickCartIcon();
		this.viewCartLink.click();
	}
	


}
