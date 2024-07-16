package com.pages;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class PageExpenses extends BaseTest {
	
	public PageExpenses(WebDriver driver) {
		this.driver = driver;
	}
	
	public void addExpenses() throws InterruptedException {
		driver.findElement(By.xpath(loc.getProperty("finances"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("expense"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("eAction"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("newExpenses"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("expenseHead"))).click();
		WebElement sf = driver.findElement(By.xpath(loc.getProperty("expensesf")));
		sf.click();
		for(int k=1;k<=2;k++) {
		sf.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		}
		Thread.sleep(1000);
		sf.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		WebElement element = driver.findElement(By.xpath(loc.getProperty("expenseName")));
		String expenseName = (data.getProperty("name"))+" "+UUID.randomUUID().toString();
		element.sendKeys(expenseName);
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("ecal"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("edate"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("expenseInvoice"))).sendKeys(data.getProperty("invoiceNumber"));
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("expenseAmount"))).sendKeys(data.getProperty("amount"));
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("expenseDescription"))).sendKeys(data.getProperty("description"));
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("expenseSave"))).click();
		Thread.sleep(1000);
//		driver.findElement(By.xpath(loc.getProperty("expenseclosebtn"))).click();
		driver.findElement(By.xpath(loc.getProperty("ecancel"))).click();
		Thread.sleep(3000);
	}
	
	public void editExpense() throws InterruptedException {
		driver.findElement(By.xpath(loc.getProperty("editExpensebtn"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("editExpenseHead"))).click();
		Thread.sleep(1000);
		WebElement eesf = driver.findElement(By.xpath(loc.getProperty("editExpensesf")));
		for(int j=1;j<=2;j++) {
		eesf.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		}
		Thread.sleep(1000);
		eesf.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		WebElement eName = driver.findElement(By.xpath(loc.getProperty("editExpenseName")));
		eName.clear();
		Thread.sleep(1000);
		eName.sendKeys(data.getProperty("ename"));
		Thread.sleep(1000);
		
//		driver.findElement(By.xpath(loc.getProperty("editcal"))).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath(loc.getProperty("editdate"))).click();
//		Thread.sleep(1000);
//		
		
		WebElement eInvoiceNumber = driver.findElement(By.xpath(loc.getProperty("editExpenseInvoiceNumber")));
		Thread.sleep(1000);
		eInvoiceNumber.clear();
		Thread.sleep(1000);
		eInvoiceNumber.sendKeys(data.getProperty("einvoiceNumber"));
		Thread.sleep(1000);
		
		WebElement eAmount = driver.findElement(By.xpath(loc.getProperty("editExpenseAmount")));
		Thread.sleep(1000);
		eAmount.clear();
		Thread.sleep(1000);
		eAmount.sendKeys(data.getProperty("eamount"));
		Thread.sleep(1000);
		
		WebElement eDescription = driver.findElement(By.xpath(loc.getProperty("editExpenseDescription")));
		Thread.sleep(1000);
		eDescription.clear();
		Thread.sleep(1000);
		eDescription.sendKeys(data.getProperty("description"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(loc.getProperty("editExpenseSave"))).click();
		Thread.sleep(3000);
	}
	
	public void expenseFilter() throws InterruptedException {
		driver.findElement(By.xpath(loc.getProperty("expensefilter"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("expensearrow"))).click();
		Thread.sleep(1000);
		WebElement exsf = driver.findElement(By.xpath(loc.getProperty("expensesearchfield")));
		Thread.sleep(1000);
		for(int i=1;i<=2;i++) {
		exsf.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		}
		Thread.sleep(1000);
		exsf.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(loc.getProperty("expenseresetbtn"))).click();
		Thread.sleep(2000);
	}
	
	public void searchAndDeleteExpense() throws InterruptedException {
		WebElement eSearch = driver.findElement(By.xpath(loc.getProperty("expenseSearch")));
		Thread.sleep(1000);
		eSearch.sendKeys(data.getProperty("ename"));
		Thread.sleep(1000);
		eSearch.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		WebElement x = driver.findElement(By.xpath(loc.getProperty("expenseDelete")));
		Thread.sleep(1000);
		x.click();
		driver.findElement(By.xpath(loc.getProperty("expenseyesdelete"))).click();
		Thread.sleep(2000);
	}
	
	public void deleteValidation() throws InterruptedException {
	WebElement z2 = driver.findElement(By.xpath(loc.getProperty("expenseSearch")));
		z2.clear();
		z2.click();
		z2.sendKeys(data.getProperty("ename"));
		z2.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		String str = driver.findElement(By.xpath(loc.getProperty("table"))).getText();
		String str1 = "No data available in table";
		if(str.contains(str1)) {
			System.out.println("Record is deleted");
		}
		else {
			System.out.println("Record is available");
		}

	}

}
