package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UnifChaneMyPassPage {
	private WebDriver driver;
	
	public UnifChaneMyPassPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="input-password")
	private WebElement newPassword;
	
	@FindBy(id="input-confirm")
	private WebElement confirmNewPassword;
	
	@FindBy(className="btn-primary")
	private WebElement continueBtn;
	
	@FindBy(className="text-danger")
	private WebElement errMssg1;
	
	public void sendNewPassword (String newPassword) {
		this.newPassword.clear();
		this.newPassword.sendKeys(newPassword);
	}
	
	public void sendConfirmNewPassword (String confirmNewPassword) {
		this.confirmNewPassword.clear();
		this.confirmNewPassword.sendKeys(confirmNewPassword);
	}
	
	public void clickContinueBtn() {
		this.continueBtn.click();
	}
	
	public void assertErrMssg1() {
		String errMess=this.errMssg1.getText();
		Assert.assertEquals("Password confirmation does not match password!",errMess);
	}
}
