package com.example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChromeTest {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.setHeadless(true);
		driver = new ChromeDriver(chromeOptions);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void searchForIPhone() {
		driver.get("https://www.amazon.com/");
		
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("iphone");
		
		WebElement searchButton = driver.findElement(By.className("nav-input"));
        searchButton.click();
		
		Assert.assertEquals(driver.getTitle(), "Amazon.com: iphone - Cell Phones: Cell Phones & Accessories");
	}

	@Test(dependsOnMethods="searchForIPhone")
	public void checkPrice() throws InterruptedException {
		WebElement iPhone = driver.findElement(By.xpath("//*[@id=\"result_0\"]/div/div[4]/div[1]/a"));
		iPhone.click();
		
		WebElement iPhonePrice = driver.findElement(By.id("priceblock_ourprice"));
		
		Assert.assertEquals(iPhonePrice.getText(), "$199.99");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
