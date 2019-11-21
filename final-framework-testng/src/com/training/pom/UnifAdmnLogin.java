package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UnifAdmnLogin {
	
	private WebDriver driver;
	
	public UnifAdmnLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit' and contains(@class,'btn-primary')]")
	private WebElement loginBtn;
	
	@FindBy(xpath="//div[contains(@class,'alert-danger')]")
	private WebElement errMssg1;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click();
	}
	
	public void assertErrMssg1() {
		String errMess = this.errMssg1.getText();
		int a = errMess.length();
		a=a-2;
		errMess = errMess.substring(0, a);
		errMess = errMess.trim();
		Assert.assertEquals(errMess,"No match for Username and/or Password.");
	}

}
