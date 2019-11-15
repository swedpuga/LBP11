package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginUnifPOM {
	private WebDriver driver; 
	
	public LoginUnifPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="email")
	private WebElement userName;
	
	@FindBy(id ="input-password")
	private WebElement password;
	
	@FindBy(xpath ="//form/input[@type='submit']")
	private WebElement loginButton;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginButton.click(); 
	}
}
