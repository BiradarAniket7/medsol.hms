package com.pages;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class PageDiagnosisCategories extends BaseTest {
	
	public PageDiagnosisCategories(WebDriver driver) {
		this.driver = driver;
	}
	
	public void addDiagnosis() throws InterruptedException {
		driver.findElement(By.xpath(loc.getProperty("diagnosis"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("newDiagnosis"))).click();
		Thread.sleep(1000);
		WebElement elem = driver.findElement(By.xpath(loc.getProperty("diagnosisCat")));
		String diagnosisCategory = (data.getProperty("diagnosisCat"))+" "+UUID.randomUUID().toString();
		elem.sendKeys(diagnosisCategory);
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("diagnosisDesc"))).sendKeys(data.getProperty("diagnosisDesc"));
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("diagnosisCatSave"))).click();
		Thread.sleep(3000);
	}
	
	public void editDiagnosis() throws InterruptedException {
		driver.findElement(By.xpath(loc.getProperty("editDiagnosis"))).click();
		Thread.sleep(1000);
		WebElement editCat = driver.findElement(By.xpath(loc.getProperty("editDiagnosisCat")));
		Thread.sleep(1000);
		editCat.clear();
		Thread.sleep(1000);
		editCat.sendKeys(data.getProperty("editdiagnosisCat"));
		Thread.sleep(1000);
		WebElement editDesc = driver.findElement(By.xpath(loc.getProperty("editDiagnosisDesc")));
		Thread.sleep(1000);
		editDesc.clear();
		Thread.sleep(1000);
		editDesc.sendKeys(data.getProperty("editdiagnosisDesc"));
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("editdiagnosisCatSave"))).click();
		Thread.sleep(3000);
	}
	
	public void searchAndDeleteDiagnosis() throws InterruptedException {
		WebElement editSearch = driver.findElement(By.xpath(loc.getProperty("searchDiagnosis")));
		Thread.sleep(1000);
		editSearch.sendKeys(data.getProperty("editdiagnosisCat"));
		Thread.sleep(1000);
		editSearch.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("deleteDiagnosis"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("yesDeleteDiagnosis"))).click();
		Thread.sleep(1000);
		
	}
	
	public void deleteValidation() throws InterruptedException {
		WebElement z3 = driver.findElement(By.xpath(loc.getProperty("searchDiagnosis")));
		z3.clear();
		z3.click();
		z3.sendKeys(data.getProperty("editdiagnosisCat"));
		z3.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		String x = driver.findElement(By.xpath(loc.getProperty("table"))).getText();
		String y = "No data available in table";
		if(x.contains(y)) {
			System.out.println("Record is deleted");
		}
		else {
			System.out.println("Record is available");
		}
	}
	

}
