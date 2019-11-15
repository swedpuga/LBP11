package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UnifHomePage {
	private WebDriver driver;
	
	public UnifHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//img[contains(@src,'BacktoSchool')]")
	private WebElement shopUniformsBtn;

	@FindBy(xpath="//img[contains(@title,'REGULAR T-SHIRTS (YELLOW)')]")
	private WebElement yellowTShirtImg;
	
	@FindBy(xpath="//span[text()='Add to Cart' and contains(@class,'hidden')]")
	private WebElement yellowTShirtAddToCart;
	
	public void clickShopUniformsBtn() {
		this.shopUniformsBtn.click(); 
	}
	
	public void movetoYellowTshirtImg() {
		Actions actions = new Actions(driver);
		actions.moveToElement(this.yellowTShirtImg).perform();
	}
	
	public void clickAddtoCartYellowTShirt() {
		this.yellowTShirtAddToCart.click();
	}
}
