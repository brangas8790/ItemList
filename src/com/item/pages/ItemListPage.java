package com.item.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemListPage  {
	 WebDriver driver;
	
	@FindBy(xpath="/html/body/center[2]/table/tbody/tr[2]/td[2]")
	private WebElement itemcode;
	
	@FindBy(xpath="/html/body/center[2]/table/tbody/tr[2]/td[3]")
	private WebElement itemname;
	
	@FindBy(xpath="/html/body/center[2]/table/tbody/tr[2]/td[4]")
	private WebElement itemprice;
	
	@FindBy(xpath="/html/body/center[2]/table/tbody/tr[2]/td[5]")
	private WebElement desc;
	
	@FindBy(xpath="/html/body/center[2]/table/tbody/tr[2]/td[6]")
	private WebElement category;
	
	@FindBy(xpath="/html/body/center/h4")
	private WebElement emptyMessage;
	
	public String getItemCode(){
		return itemcode.getText();
	}
	public String getItemName(){
		return itemname.getText();
	}
	public String getItemPrice(){
		return itemprice.getText();
	}
	public String getItemDescription(){
		return desc.getText();
	}
	public String getEmptyMessage(){
		return emptyMessage.getText();
	}
	public void setDriver(WebDriver driver){
		this.driver=driver;
	}
	public  ItemListPage(WebDriver driver){
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
