package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class PageLogin extends BaseTest{
	
	public PageLogin(WebDriver driver) {
		this.driver = driver;
	}
	
	public void loginTest() throws InterruptedException {
		driver.findElement(By.xpath(loc.getProperty("email"))).sendKeys(prop.getProperty("email"));
		driver.findElement(By.xpath(loc.getProperty("password"))).sendKeys(prop.getProperty("password"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("login"))).click();
	}
	
	public void validation() throws InterruptedException {
		Thread.sleep(2000);
		WebElement db = driver.findElement(By.xpath(loc.getProperty("dashboard")));
		if(db.isDisplayed()) {
			System.out.println("Landed On The Home Page");
		}
		
	}
	
	


}
