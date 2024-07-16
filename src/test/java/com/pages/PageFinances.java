package com.pages;

import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class PageFinances extends BaseTest {

	public PageFinances(WebDriver driver) {
		this.driver = driver;
	}

	public void addIncomes() throws InterruptedException {
		driver.findElement(By.xpath(loc.getProperty("finances"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("incomeAct"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("newIncome"))).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(loc.getProperty("incomeHead"))).click();
		Thread.sleep(2000);
		WebElement incomeHead = driver.findElement(By.xpath(loc.getProperty("searchfield")));
		Thread.sleep(2000);
		for(int i=1;i<=2;i++) {
		incomeHead.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		}
		Thread.sleep(1000);
		incomeHead.sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		WebElement ele = driver.findElement(By.xpath(loc.getProperty("name")));
		Thread.sleep(2000);
		String incomeName = (data.getProperty("name"))+" "+UUID.randomUUID().toString();
		ele.sendKeys(incomeName);

		driver.findElement(By.xpath(loc.getProperty("cdate"))).click();
//		while(true)
//		{
//			String curYear = driver.findElement(By.xpath(loc.getProperty("currentYear"))).getText();
//			String curMonth = driver.findElement(By.xpath(loc.getProperty("currentMonth"))).getText();
//			if(curYear.equalsIgnoreCase("2024") && curMonth.equalsIgnoreCase("June"))
//			{
//				break;
//			}
//			else {
//				driver.findElement(By.xpath(loc.getProperty("prev"))).click();
//			}
//		}
		driver.findElement(By.xpath(loc.getProperty("date"))).click();

		driver.findElement(By.xpath(loc.getProperty("invoiceNumber"))).sendKeys(data.getProperty("amount"));;
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("amount"))).sendKeys(data.getProperty("amount"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("description"))).sendKeys(data.getProperty("description"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("save"))).click();
		Thread.sleep(2000);
//		driver.findElement(By.xpath(loc.getProperty("closeButton"))).click();
//		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("incomeCancel"))).click();
		Thread.sleep(3000);	}

	public void editIncomes() throws InterruptedException {
		driver.findElement(By.xpath(loc.getProperty("edit"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("editIh"))).click();
		Thread.sleep(2000);

		WebElement eih = driver.findElement(By.xpath(loc.getProperty("editsf")));
		Thread.sleep(1000);
		eih.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		eih.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		WebElement editName = driver.findElement(By.xpath(loc.getProperty("editName")));
		Thread.sleep(1000);
		editName.clear();
		Thread.sleep(1000);
		editName.sendKeys(data.getProperty("ename"));
		Thread.sleep(2000);

		WebElement editInvoiceNumber = driver.findElement(By.xpath(loc.getProperty("editInvoiceNumber")));
		Thread.sleep(1000);
		editInvoiceNumber.clear();
		Thread.sleep(1000);
		editInvoiceNumber.sendKeys(data.getProperty("einvoiceNumber"));
		Thread.sleep(2000);

		WebElement editAmount = driver.findElement(By.xpath(loc.getProperty("editAmount")));
		Thread.sleep(1000);
		editAmount.clear();
		Thread.sleep(1000);
		editAmount.sendKeys(data.getProperty("eamount"));
		Thread.sleep(2000);

		WebElement editDescription = driver.findElement(By.xpath(loc.getProperty("editDescription")));
		Thread.sleep(1000);
		editDescription.clear();
		Thread.sleep(1000);
		editDescription.sendKeys(data.getProperty("description"));
		Thread.sleep(2000);

		driver.findElement(By.xpath(loc.getProperty("editSave"))).click();
		Thread.sleep(3000);

	}
	
	public void filter() throws InterruptedException {
		driver.findElement(By.xpath(loc.getProperty("incomefilter"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(loc.getProperty("incomearrow"))).click();
		Thread.sleep(1000);
		WebElement sf = driver.findElement(By.xpath(loc.getProperty("incomesearchfield")));
		Thread.sleep(1000);
		for(int j=1;j<=2;j++) {
		sf.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		}
		Thread.sleep(1000);
		sf.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(loc.getProperty("incomeresetbtn"))).click();
		Thread.sleep(2000);
	}

	public void searchAndDelete() throws InterruptedException {
		WebElement search = driver.findElement(By.xpath(loc.getProperty("search")));
		Thread.sleep(1000);
		search.click();
		Thread.sleep(1000);
		search.sendKeys(data.getProperty("ename"));
		Thread.sleep(1000);
		search.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		WebElement y = driver.findElement(By.xpath(loc.getProperty("delete")));
		Thread.sleep(1000);
		y.click();
		driver.findElement(By.xpath(loc.getProperty("yesdelete"))).click();
		Thread.sleep(3000);
		
	}
	
	public void Validation_Delete() throws InterruptedException {
		
		
		WebElement z1 = driver.findElement(By.xpath(loc.getProperty("search")));
	
		
		
		
//		By x = By.xpath("//input[@class='form-control w-250px ps-10']]");
//		WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(10));
//		WebElement z1 = wait.until(ExpectedConditions.elementToBeClickable(x));
		z1.clear();
		z1.click();
		z1.sendKeys(data.getProperty("ename"));
		z1.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		WebElement ele = driver.findElement(By.xpath(loc.getProperty("table")));
		String s = ele.getText();
		String s1 = "No data available in table";
		if(s.contains(s1)) {
			System.out.println("Record is deleted");
		}
		else {
			System.out.println("Record is available");
		}
		


	}

}
