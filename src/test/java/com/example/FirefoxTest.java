package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class FirefoxTest {

	WebDriver driver;

//	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
	}

//	@Test
	public void navigateToAUrl() {
		driver.get("https://www.amazon.com/");
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("iphone");
		
		WebElement searchButton = driver.findElement(By.className("nav-input"));
        searchButton.click();
		
		Assert.assertEquals(driver.getTitle(), "Amazon.com: iphone - Cell Phones: Cell Phones & Accessories");
	}

//	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
