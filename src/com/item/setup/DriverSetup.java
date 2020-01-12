package com.item.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverSetup{
	public static String baseUrl = "http://apps.qa2qe.cognizant.e-box.co.in/Item_search_4500/";
	
	public WebDriver getDriver() {
		   System.setProperty("webdriver.chrome.driver", "/Users/brangas/Documents/workspace/item_details/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to(DriverSetup.baseUrl);
		return driver;
	}

}
