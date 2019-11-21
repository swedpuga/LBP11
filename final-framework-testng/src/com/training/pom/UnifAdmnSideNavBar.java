package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UnifAdmnSideNavBar {

	private WebDriver driver;
	private Actions actions;
	
	public UnifAdmnSideNavBar(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actions=new Actions(driver);
		
	}
	
	@FindBy(id="catalog")
	private WebElement catalogBtn;
	
	@FindBy(xpath="//a[contains(@href,'route=catalog/category&token')]")
	private WebElement categoriesLink;
	
	public void moveToCatalogBtn() {
		actions.moveToElement(this.catalogBtn).build().perform();
	}
	
	public void clickCategoriesLink() {
		this.categoriesLink.click();
	}

}
