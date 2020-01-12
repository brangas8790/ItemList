package com.item.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	private WebDriver driver;
	
	@FindBy(name="category")
	private WebElement category;
	
	@FindBy(name="startPrice")
	private WebElement istartPrice;
	
	@FindBy(name="endPrice")
	private WebElement iendPrice;

	@FindBy(id="search")
	private WebElement isearch;
	
	@FindBy(id="errorMessage")
	private WebElement errormessage;
	
	public void setDriver(WebDriver driver){
		this.driver=driver;
	}
	public void setCategory(String iCategory){
		category.sendKeys(iCategory);
	}
	public void setStartPrice(String startPrice){
		istartPrice.sendKeys(startPrice);
	}
	public void setEndPrice(String endPrice){
		iendPrice.sendKeys(endPrice);
	}
	public String getErrorMessage(){
		return errormessage.getText();
	}
	public void clickSearch(){
		isearch.click();
	}
	public SearchPage(WebDriver driver){
		super();
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
}
