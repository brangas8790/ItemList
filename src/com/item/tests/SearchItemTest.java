package com.item.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.item.pages.ItemListPage;
import com.item.pages.SearchPage;
import com.item.setup.DriverSetup;
import com.item.setup.ExcelUtils;


public class SearchItemTest extends DriverSetup{
	SearchPage searchpage;
	ItemListPage itemListPage;
	public static String blankErrTxt;
	public static String emptymessage;
	public static String itemCodeTxt;
	public static String itemNameTxt;
	public static String itemPriceTxt;
	public static String itemDescriptionTxt;
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		//searchpage=new SearchPage();
		driver = getDriver();
   }
	
	
    @Test
    
	public void testBlankForItemCategory() throws Exception {
    	searchpage=new SearchPage(driver);
		String category = ExcelUtils.getCellData(0, 1);
		System.out.println();
		String startPrice = ExcelUtils.getCellData(0, 1);
		String endPrice = ExcelUtils.getCellData(0, 1);
		searchpage.setCategory(category);
		searchpage.setStartPrice(startPrice);
		searchpage.setEndPrice(endPrice);
		searchpage.clickSearch();
		blankErrTxt=searchpage.getErrorMessage();
		System.out.println(blankErrTxt);
		assertEquals("Please enter valid inputs", blankErrTxt);
		driver.close();
}
	
		
    @Test(dataProvider="customerInvalid")
	public void testSearchForEmptyList() throws Exception {
    	//setUp();
		SearchPage searchpage=PageFactory.initElements(driver, SearchPage.class);
		//searchpage.setDriver(driver);
		String category = "FOOTWEAR";
		String startPrice = "50";
		String endPrice = "100";
		searchpage.setCategory(category);
		searchpage.setStartPrice(startPrice);
		searchpage.setEndPrice(endPrice);
		searchpage.clickSearch();
		ItemListPage itemlist=PageFactory.initElements(driver,ItemListPage.class);
		//itemlist.setDriver(driver);
		emptymessage=itemlist.getEmptyMessage();
		System.out.println(itemlist.getEmptyMessage());
		assertEquals("Item list is empty", emptymessage);
		driver.close();
		
	}
	@DataProvider
	public Object[][] customerInvalid(){
		Object[][] testarr=ExcelUtils.getExceldata();
		return testarr;
		
	}
	
	@Test 
	public void testSearchForResults() throws Exception {
		//setUp();
		SearchPage searchpage=PageFactory.initElements(driver, SearchPage.class);
		//searchpage.setDriver(driver);
		String category = "UTENSILS";
		String startPrice = "250";
		String endPrice = "1000";
		searchpage.setCategory(category);
		searchpage.setStartPrice(startPrice);
		searchpage.setEndPrice(endPrice);
		searchpage.clickSearch();
		ItemListPage itemlist=PageFactory.initElements(driver,ItemListPage.class);
		//itemlist.setDriver(driver);
		itemCodeTxt=itemlist.getItemCode();
		 itemNameTxt=itemlist.getItemName();
		itemPriceTxt=itemlist.getItemPrice();
		itemDescriptionTxt=itemlist.getItemPrice();
		System.out.println(itemCodeTxt+"---"+itemDescriptionTxt);
		driver.close();
		
	}
	

   @AfterMethod
	public void driverQuit(){
	   System.out.println("driver quit");
		driver.quit();
	}
	
	
}
