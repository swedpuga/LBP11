package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UnifAdmnCategoriesPage {
	private WebDriver driver;
	
	public UnifAdmnCategoriesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[contains(@class,'fa-plus')]")
	private WebElement plusBtn;
	
	@FindBy(id="input-name1")
	private WebElement categoryName;
	
	@FindBy(xpath="//div[contains(@class,'note-editable')]")
	private WebElement descriptionTxt;
	
	@FindBy(id="input-meta-title1")
	private WebElement metaTagTitle;
	
	@FindBy(id="input-meta-description1")
	private WebElement metaTagDescription;
	
	@FindBy(xpath="//i[contains(@class,'fa-save')]")
	private WebElement saveBtn;
	
	@FindBy(xpath="//div[contains(@class,'alert-success')]")
	private WebElement successMssg1;
	
	@FindBy(xpath="//*[@id=\"form-category\"]/div/table/tbody/tr[1]/td[4]/a/i")
	private WebElement firstCatgryEditBtn;
	
	public void clickAddCategory() {
		this.plusBtn.click();
	}
	
	public void sendCategoryName(String catgryNm) {
		this.categoryName.clear();
		this.categoryName.sendKeys(catgryNm);
	}
	
	public void sendDescriptionText(String txt) {
		this.descriptionTxt.clear();
		this.descriptionTxt.sendKeys(txt);
	}
	
	public void sendMetaTagTitle(String title) {
		this.metaTagTitle.clear();
		this.metaTagTitle.sendKeys(title);		
	}
	
	public void sendMetaTagDescription(String tagDescrptn) {
		this.metaTagDescription.clear();
		this.metaTagDescription.sendKeys(tagDescrptn);
	}
	
	public void clickSaveBtn() {
		this.saveBtn.click();
	}
	
	public void clickFirstCatgryEditBtn() {
		this.firstCatgryEditBtn.click();
	}
	
	public void assertSuccsMssg1() {
		String SuccsMssg = this.successMssg1.getText();
		int a = SuccsMssg.length();
		a=a-2;
		SuccsMssg=SuccsMssg.substring(0,a);
		SuccsMssg=SuccsMssg.trim();
		Assert.assertEquals(SuccsMssg, "Success: You have modified categories!");
	}
		
}
